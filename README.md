# README

This project aims to provide an empirical demonstration of the performance of sets of comparable algorithms implemented in Scala.

A set of comparable argorithms is implemented in a regular class with a simple anotation on benchmarked methods. 
For example:

<script src="https://gist.github.com/mauriciojost/62d32583e1465a0e14e8addae697c618.js"></script>

Algorithms benchmarked are located [in the catalog](src/main/scala/org/mauritania/minibenchmark/catalog).

[![REPORT](https://img.shields.io/badge/GOTO-REPORT-3333FF.svg)](https://mauriciojost.github.io/scala-benchmark/)

**New algorithm sets can be very easily added!**

It uses [JMH](http://openjdk.java.net/projects/code-tools/jmh/) under the hood for benchmarking.

## EXECUTION

To execute the benchmarks using SBT just do:

```bash
sbt clean "jmh:run -help"
sbt clean "jmh:run -i 3 -wi 3 -f1 -t1 .*Identity.*"
```

## REPORT

You can generate a report with the benchmarking result of the algorithms available in the catalog, so that it can be shared later. 
For that you can do as follows:

```bash
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

## NOTES

I recommend to use the following commands to go further in the investigation:

```bash
scala -Xshow-phases
sbt 'set scalacOptions ++=Seq("-Xprint:namer")' compile
sbt 'set scalacOptions ++=Seq("-Xprint:mixin")' compile
```


