#!/bin/bash

# Benchmark settings
export ITERATIONS=10
export WARMUP_ITERATIIONS=5

# Files used
export RAW_CSV=input/output.csv
export CATEGORIES=input/categories.csv
export TEMPLATE_HTML=template.html
export CURRDIR=`readlink -e $(dirname $0)`

cd $CURRDIR/../
sbt -Dsbt.log.noformat=true clean "jmh:run -rff report/input/output.csv  -i $ITERATIONS -wi $WARMUP_ITERATIIONS -f1 -t1 .*"

cd $CURRDIR
cat $RAW_CSV | awk -F',' '{print $1}' | sed 's/"//g' | sed 's/\(.*\)\..*/\1/' | sort | uniq | tail -n+2 > $CATEGORIES

while read -r category
do
  echo "Graph: $category"
  OUTPUT_CSV_NAME=$category.csv
  OUTPUT_CSV=output/$OUTPUT_CSV_NAME
  OUTPUT_HTML=output/$category.html

  cat $RAW_CSV | head -1 | sed 's/"//g' | awk -F',' '{print $1","$5","$6}' > $OUTPUT_CSV
  cat $RAW_CSV | grep $category | sed 's/"//g' | sed "s/$category\.//" | awk -F',' '{print $1","$5","$6}' >> $OUTPUT_CSV

  cat $TEMPLATE_HTML | sed "s/TO_REPLACE_TITLE/$category/g" | \
    sed "s/TO_REPLACE_CSV/$OUTPUT_CSV_NAME/g" \
    > $OUTPUT_HTML

done < "$CATEGORIES"
