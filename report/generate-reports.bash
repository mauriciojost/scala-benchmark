#!/bin/bash

export RAW_CSV=input/output.csv
export CATEGORIES=input/categories.csv
export TEMPLATE_HTML=template.html

cat $RAW_CSV | awk -F',' '{print $1}' | sed 's/"//g' | sed 's/\(.*\)\..*/\1/' | sort | uniq | tail -n+2 > $CATEGORIES

while read -r category
do
  echo "Graph: $category"
  OUTPUT_CSV_NAME=$category.csv
  OUTPUT_CSV=output/$OUTPUT_CSV_NAME
  OUTPUT_HTML=output/$category.html
  #cat $RAW_CSV | grep $category | awk -F',' '{print $1}' | sed 's/"//g' | sed "s/$category\.//"
  cat $RAW_CSV | head -1 | sed 's/"//g' > $OUTPUT_CSV
  cat $RAW_CSV | grep $category | sed 's/"//g' | sed "s/$category\.//" >> $OUTPUT_CSV

  cat $TEMPLATE_HTML | sed "s/TO_REPLACE_TITLE/$category/g" | sed "s/TO_REPLACE_CSV/$OUTPUT_CSV_NAME/g" > $OUTPUT_HTML

done < "$CATEGORIES"
