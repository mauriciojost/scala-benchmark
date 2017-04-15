#!/bin/bash

# Benchmark settings
export ITERATIONS=4
export WARMUP_ITERATIIONS=3

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
export OUTPUT_HTML=output/index.html

cd $CURRDIR/../
# Show scala phases
scala -Xshow-phases
# Generate raw data
#sbt 'set scalacOptions ++=Seq("-Xprint:namer")' -Dsbt.log.noformat=true clean "jmh:run -rff report/input/output.csv  -i $ITERATIONS -wi $WARMUP_ITERATIIONS -f1 -t1 .*"

cd $CURRDIR
cat $RAW_CSV | awk -F',' '{print $1}' | sed 's/"//g' | sed 's/\(.*\)\..*/\1/' | sort | uniq | tail -n+2 > $CATEGORIES

cat $HEADER_HTML > $OUTPUT_HTML

while read -r category
do
  CHART_ID=`echo $category | sed "s/\.//g"`
  cat $DIV_HTML | sed "s/TO_REPLACE_CHART_ID/$CHART_ID/g" >> $OUTPUT_HTML
done < "$CATEGORIES"

cat $INITSCRIPT_HTML >> $OUTPUT_HTML

while read -r category
do
  CHART_ID=`echo $category | sed "s/\.//g"`
  OUTPUT_CSV_NAME=$category.csv
  OUTPUT_CSV=output/$OUTPUT_CSV_NAME

  cat $RAW_CSV | head -1 | sed 's/"//g' | awk -F',' '{print $1","$5","$6}' > $OUTPUT_CSV
  cat $RAW_CSV | grep "$category\." | sed 's/"//g' | sed "s/$category\.//" | awk -F',' '{print $1","$5","$6}' >> $OUTPUT_CSV

  cat $SCRIPT_HTML | sed "s/TO_REPLACE_TITLE/$category/g" | \
    sed "s/TO_REPLACE_CSV/$OUTPUT_CSV_NAME/g" | \
    sed "s/TO_REPLACE_CHART_ID/$CHART_ID/g" | \
    sed "s/TO_REPLACE_CATEGORY/$category/g" >> $OUTPUT_HTML

done < "$CATEGORIES"

cat $ENDSCRIPT_HTML >> $OUTPUT_HTML
cat $TAIL_HTML >> $OUTPUT_HTML
