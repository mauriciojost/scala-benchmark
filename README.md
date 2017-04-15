# README

This project aims to provide an empirical demonstration of the performance difference of similar (but not equal) algorithms. 

## How To Execute It

To execute the benchmarks using SBT just do: 

```
sbt clean "jmh:run -help"
sbt clean "jmh:run -i 3 -wi 3 -f1 -t1 .*Identity.*"
```

## How To Generate Reports

It is very useful to have a jenkins Job to generate regular reports on the performance of bencharmked functions. I recommend [jmh-jenkins](https://github.com/blackboard/jmh-jenkins) with a job like this one: 

```
sbt -Dsbt.log.noformat=true clean "jmh:run -rff report/input/output.csv  -i 10 -wi 10 -f1 -t1 .*"

```

## What Is Pending

- Add arguments to benchmarked functions (to make sure the JVM does not guess the results)

- Access benchmark results programatically and generate reports (not needed)

