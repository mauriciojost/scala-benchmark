# README

This project aims to provide an empirical demonstration of the performance of sets of comparable algorithms.

Algorithms benchmarked are located [here](/tree/master/src/main/scala/org/mauritania/minibenchmark/catalog).

**New algorithm sets can be very easily added!**

It uses [JMH](http://openjdk.java.net/projects/code-tools/jmh/) under the hood for benchmarking.

[![REPORT](https://img.shields.io/badge/GOTO-REPORT-333399.svg)](https://mauriciojost.github.io/scala-benchmark/)

## EXECUTION

To execute the benchmarks using SBT just do:

```
sbt clean "jmh:run -help"
sbt clean "jmh:run -i 3 -wi 3 -f1 -t1 .*Identity.*"
```

## REPORT

You can generate a report with the benchmarking result of the algorithms available in the catalog, so that it can be shared later. 
For that you can do as follows:

```
cd report
bash generate-reports.bash
```
A new [raw.csv](report/input/raw.csv) file will be generated. Then you can locally browse [index.html](index.html).

### REPORT ON GITHUB

If you want to generate a report that you can share with other people, 
- fork the project in GitHub
- enable GitHub pages for your fork (on _master_ branch)
- generate the report and commit the changed _raw.csv_
- browse the GitHub page


