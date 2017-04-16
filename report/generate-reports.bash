#!/bin/bash

set -e
# Benchmark settings
export ITERATIONS=5
export WARMUP_ITERATIIONS=5
#export BENCHMARK_MODE=AverageTime
export BENCHMARK_MODE=Throughput

# Files used
export RAW_CSV=input/output.csv
export CATEGORIES=input/categories.csv

export HEADER_HTML=header.html
export DIV_HTML=div.html
export INITSCRIPT_HTML=initscript.html
export SCRIPT_HTML=script.html
export ENDSCRIPT_HTML=endscript.html
export TAIL_HTML=tail.html

export CURRDIR=`readlink -e $(dirname $0)`
export OUTPUT_HTML=$CURRDIR/../README.md

cd $CURRDIR/../
echo "### Show scala phases"
scala -Xshow-phases
echo "### Generate raw data"
sbt 'set scalacOptions ++=Seq("-Xprint:namer")' \
  -Dsbt.log.noformat=true \
  clean \
  "jmh:run -rff report/input/output.csv -bm $BENCHMARK_MODE -i $ITERATIONS -wi $WARMUP_ITERATIIONS -f1 -t1 .*"

cd $CURRDIR
cat $RAW_CSV | awk -F',' '{print $1}' | sed 's/"//g' | sed 's/\(.*\)\..*/\1/' | sort | uniq | tail -n+2 > $CATEGORIES

echo "### Write header"
cat $HEADER_HTML > $OUTPUT_HTML

echo "### Write divs"
while read -r category
do
  CHART_ID=`echo $category | sed "s/\.//g"`
  cat $DIV_HTML | sed "s/TO_REPLACE_CHART_ID/$CHART_ID/g" >> $OUTPUT_HTML
done < "$CATEGORIES"

echo "### Write scripts"
cat $INITSCRIPT_HTML >> $OUTPUT_HTML

while read -r category
do
  CHART_ID=`echo $category | sed "s/\.//g"`
  echo "     For $category ..."
  OUTPUT_CSV_NAME=$category.csv
  OUTPUT_CSV=output/$OUTPUT_CSV_NAME
  UNITS="`cat $RAW_CSV | tail -n+2 | sed 's/"//g' | sed 's/\// per /g' | awk -F',' '{print $7}' | head -1 | sed 's/[^ a-zA-Z0-9]//g' `"

  cat $RAW_CSV | head -1 | sed 's/"//g' | awk -F',' '{print $1","$5","$6}' > $OUTPUT_CSV
  cat $RAW_CSV | grep "$category\." | sed 's/"//g' | sed "s/$category\.//" | awk -F',' '{print $1","$5","$6}' >> $OUTPUT_CSV

  cat $SCRIPT_HTML | sed "s/TO_REPLACE_TITLE/$category/g" | \
    sed "s/TO_REPLACE_CSV/report\/output\/$OUTPUT_CSV_NAME/g" | \
    sed "s/TO_REPLACE_CHART_ID/$CHART_ID/g" | \
    sed "s/TO_REPLACE_UNITS/$UNITS/g" | \
    sed "s/TO_REPLACE_CATEGORY/$category/g" >> $OUTPUT_HTML

done < "$CATEGORIES"

echo "### Write tail"
cat $ENDSCRIPT_HTML >> $OUTPUT_HTML
cat $TAIL_HTML >> $OUTPUT_HTML
