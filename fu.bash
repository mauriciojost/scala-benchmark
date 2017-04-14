#!/bin/bash

export OUTPUT_CSV=output.csv
export CATEGORIES=categories.csv

cat $OUTPUT_CSV | awk -F',' '{print $1}' | sed 's/"//g' | sed 's/\(.*\)\..*/\1/' | sort | uniq | tail -n+2 > $CATEGORIES

while read -r category
do
  echo $category
  cat $OUTPUT_CSV | grep $category | awk -F',' '{print $1}' | sed 's/"//g' | sed "s/$category\.//"
  cat $OUTPUT_CSV | grep $category | awk -F',' '{print $5}' | sed 's/"//g'
done < "$CATEGORIES"
