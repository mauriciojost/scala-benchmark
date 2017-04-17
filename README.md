# README

This project aims to provide an empirical demonstration of the performance difference of similar (but not equal) algorithms.

It uses JMH under the hood for micro benchmarking.

[![BLOG](https://img.shields.io/badge/goto-webpage-333399.svg)](https://mauriciojost.github.io/scala-ubenchmark/)

[![GITHUB](https://img.shields.io/badge/goto-github-333399.svg)](https://github.com/mauriciojost/scala-ubenchmark/)

# Findings from the catalog

The catalog with all Scala algorithms being benchmarked is [here](https://github.com/mauriciojost/scala-ubenchmark/tree/master/src/main/scala/org/mauritania/minibenchmark/catalog).

You can easily add yours by forking the project.

## Execution

To execute the benchmarks using SBT just do:

```
sbt clean "jmh:run -help"
sbt clean "jmh:run -i 3 -wi 3 -f1 -t1 .*Identity.*"
```

## Reporting

Launch the reports generation script as follows:

```
cd report
bash generate-reports.bash
```

Also you may want to have a jenkins Job to generate regular reports on the performance of bencharmked functions. I recommend [jmh-jenkins](https://github.com/blackboard/jmh-jenkins) with a job like this one:

```
sbt -Dsbt.log.noformat=true clean "jmh:run -rff report/input/output.csv  -i 10 -wi 10 -f1 -t1 .*"

```

