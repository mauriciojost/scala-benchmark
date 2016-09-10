# README

This project aims to provide an empirical demonstration of the performance difference of similar (but not equal) algorithms. 

[![Build Status](https://api.travis-ci.org/mauriciojost/scala-mini-benchmark.svg)](https://travis-ci.org/mauriciojost/scala-mini-benchmark)

## How To Execute It

```
sbt clean "jmh:run -i 3 -wi 3 -f1 -t1 .*Identity.*"
```

## What Is Pending

- Add arguments to benchmarked functions (to make sure the JVM does not guess the results)
- Access benchmark results programatically and generate reports
- 
