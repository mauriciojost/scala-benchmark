#!/bin/bash

set -e
# Benchmark settings
export ITERATIONS=20
export WARMUP_ITERATIIONS=20
#export BENCHMARK_MODE=AverageTime
export BENCHMARK_MODE=Throughput

# Files used
export RAW_CSV=input/raw.csv

export CURRDIR=`readlink -e $(dirname $0)`

cd $CURRDIR/../
echo "### Show scala phases"
scala -Xshow-phases
echo "### Generate raw data"
sbt 'set scalacOptions ++=Seq("-Xprint:namer")' \
  -Dsbt.log.noformat=true \
  clean \
  "jmh:run -rff report/$RAW_CSV -bm $BENCHMARK_MODE -i $ITERATIONS -wi $WARMUP_ITERATIIONS -f1 -t1 .*"


