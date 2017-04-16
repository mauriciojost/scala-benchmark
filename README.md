# README

This project aims to provide an empirical demonstration of the performance difference of similar (but not equal) algorithms.

It uses JMH under the hood for micro benchmarking.

# Findings from the catalog

The catalog with all Scala algorithms being benchmarked is [here](https://github.com/mauriciojost/scala-ubenchmark/tree/master/src/main/scala/org/mauritania/minibenchmark/catalog).

You can easily add yours by forking the project.

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Scala Micro Benchmarking</title>
    <style>
        body{
        margin-top: 30px;
        margin-left:40px;
        }
        pre {
        border:1px solid red;
        }
    </style>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="http://code.highcharts.com/highcharts.js"></script>
    <script src="http://code.highcharts.com/modules/data.js"></script>
    <script src="http://code.highcharts.com/modules/exporting.js"></script>
</head>
<body>
<h1>Scala Micro Benchmarking</h1>

<div id="orgmauritaniaminibenchmarkcatalogCollectionConcatenationcontainer" style="width:1024px; min-width: 310px; height: 400px; margin: 0 auto"></div>
<div id="orgmauritaniaminibenchmarkcatalogCollectionPatternMatchingcontainer" style="width:1024px; min-width: 310px; height: 400px; margin: 0 auto"></div>
<div id="orgmauritaniaminibenchmarkcatalogCollectionRandomAccesscontainer" style="width:1024px; min-width: 310px; height: 400px; margin: 0 auto"></div>
<div id="orgmauritaniaminibenchmarkcatalogIdentitycontainer" style="width:1024px; min-width: 310px; height: 400px; margin: 0 auto"></div>
<div id="orgmauritaniaminibenchmarkcatalogIdentityTrickycontainer" style="width:1024px; min-width: 310px; height: 400px; margin: 0 auto"></div>
<div id="orgmauritaniaminibenchmarkcatalogPartialFunctionscontainer" style="width:1024px; min-width: 310px; height: 400px; margin: 0 auto"></div>
<div id="orgmauritaniaminibenchmarkcatalogSeqVsListSumcontainer" style="width:1024px; min-width: 310px; height: 400px; margin: 0 auto"></div>
<div id="orgmauritaniaminibenchmarkcatalogTailRecursivecontainer" style="width:1024px; min-width: 310px; height: 400px; margin: 0 auto"></div>
<script type="text/javascript">
var orgmauritaniaminibenchmarkcatalogCollectionConcatenationOptions = {
    chart: {
        renderTo: 'orgmauritaniaminibenchmarkcatalogCollectionConcatenationcontainer',
        defaultSeriesType: 'column'
    },
    title: {
        text: 'org.mauritania.minibenchmark.catalog.CollectionConcatenation'
    },
    xAxis: {
        categories: []
    },
    yAxis: {
        title: {
            text: 'ops per s'
        }
    },
    series: []
};

$.get('report/output/org.mauritania.minibenchmark.catalog.CollectionConcatenation.csv', function(data) {
    var lines = data.split('\n');

    // Iterate over the lines and add categories or series
    $.each(lines, function(lineNo, line) {
        console.log('Parsing line: ' + line)
        var items = line.split(',');
        // header line contains categories
        if (lineNo == 0) {
            $.each(items, function(itemNo, item) {
                console.log('Pushing category: ' + item)
                if (itemNo > 0) orgmauritaniaminibenchmarkcatalogCollectionConcatenationOptions.xAxis.categories.push(item);
            });
        } else {
            // the rest of the lines contain data with their name in the first
            // position
            var series = {
                data: []
            };
            $.each(items, function(itemNo, item) {
                if (itemNo == 0) {
                    series.name = item;
                    console.log('Pushing item category: ' + item)
                } else {
                    series.data.push(parseFloat(item));
                    console.log('Pushing item value: ' + item)
                }
            });
            if (series.data.length != 0) {
                orgmauritaniaminibenchmarkcatalogCollectionConcatenationOptions.series.push(series);
            }
        }
    });
    // Create the chart
    var chart = new Highcharts.Chart(orgmauritaniaminibenchmarkcatalogCollectionConcatenationOptions);

});


var orgmauritaniaminibenchmarkcatalogCollectionPatternMatchingOptions = {
    chart: {
        renderTo: 'orgmauritaniaminibenchmarkcatalogCollectionPatternMatchingcontainer',
        defaultSeriesType: 'column'
    },
    title: {
        text: 'org.mauritania.minibenchmark.catalog.CollectionPatternMatching'
    },
    xAxis: {
        categories: []
    },
    yAxis: {
        title: {
            text: 'ops per s'
        }
    },
    series: []
};

$.get('report/output/org.mauritania.minibenchmark.catalog.CollectionPatternMatching.csv', function(data) {
    var lines = data.split('\n');

    // Iterate over the lines and add categories or series
    $.each(lines, function(lineNo, line) {
        console.log('Parsing line: ' + line)
        var items = line.split(',');
        // header line contains categories
        if (lineNo == 0) {
            $.each(items, function(itemNo, item) {
                console.log('Pushing category: ' + item)
                if (itemNo > 0) orgmauritaniaminibenchmarkcatalogCollectionPatternMatchingOptions.xAxis.categories.push(item);
            });
        } else {
            // the rest of the lines contain data with their name in the first
            // position
            var series = {
                data: []
            };
            $.each(items, function(itemNo, item) {
                if (itemNo == 0) {
                    series.name = item;
                    console.log('Pushing item category: ' + item)
                } else {
                    series.data.push(parseFloat(item));
                    console.log('Pushing item value: ' + item)
                }
            });
            if (series.data.length != 0) {
                orgmauritaniaminibenchmarkcatalogCollectionPatternMatchingOptions.series.push(series);
            }
        }
    });
    // Create the chart
    var chart = new Highcharts.Chart(orgmauritaniaminibenchmarkcatalogCollectionPatternMatchingOptions);

});


var orgmauritaniaminibenchmarkcatalogCollectionRandomAccessOptions = {
    chart: {
        renderTo: 'orgmauritaniaminibenchmarkcatalogCollectionRandomAccesscontainer',
        defaultSeriesType: 'column'
    },
    title: {
        text: 'org.mauritania.minibenchmark.catalog.CollectionRandomAccess'
    },
    xAxis: {
        categories: []
    },
    yAxis: {
        title: {
            text: 'ops per s'
        }
    },
    series: []
};

$.get('report/output/org.mauritania.minibenchmark.catalog.CollectionRandomAccess.csv', function(data) {
    var lines = data.split('\n');

    // Iterate over the lines and add categories or series
    $.each(lines, function(lineNo, line) {
        console.log('Parsing line: ' + line)
        var items = line.split(',');
        // header line contains categories
        if (lineNo == 0) {
            $.each(items, function(itemNo, item) {
                console.log('Pushing category: ' + item)
                if (itemNo > 0) orgmauritaniaminibenchmarkcatalogCollectionRandomAccessOptions.xAxis.categories.push(item);
            });
        } else {
            // the rest of the lines contain data with their name in the first
            // position
            var series = {
                data: []
            };
            $.each(items, function(itemNo, item) {
                if (itemNo == 0) {
                    series.name = item;
                    console.log('Pushing item category: ' + item)
                } else {
                    series.data.push(parseFloat(item));
                    console.log('Pushing item value: ' + item)
                }
            });
            if (series.data.length != 0) {
                orgmauritaniaminibenchmarkcatalogCollectionRandomAccessOptions.series.push(series);
            }
        }
    });
    // Create the chart
    var chart = new Highcharts.Chart(orgmauritaniaminibenchmarkcatalogCollectionRandomAccessOptions);

});


var orgmauritaniaminibenchmarkcatalogIdentityOptions = {
    chart: {
        renderTo: 'orgmauritaniaminibenchmarkcatalogIdentitycontainer',
        defaultSeriesType: 'column'
    },
    title: {
        text: 'org.mauritania.minibenchmark.catalog.Identity'
    },
    xAxis: {
        categories: []
    },
    yAxis: {
        title: {
            text: 'ops per s'
        }
    },
    series: []
};

$.get('report/output/org.mauritania.minibenchmark.catalog.Identity.csv', function(data) {
    var lines = data.split('\n');

    // Iterate over the lines and add categories or series
    $.each(lines, function(lineNo, line) {
        console.log('Parsing line: ' + line)
        var items = line.split(',');
        // header line contains categories
        if (lineNo == 0) {
            $.each(items, function(itemNo, item) {
                console.log('Pushing category: ' + item)
                if (itemNo > 0) orgmauritaniaminibenchmarkcatalogIdentityOptions.xAxis.categories.push(item);
            });
        } else {
            // the rest of the lines contain data with their name in the first
            // position
            var series = {
                data: []
            };
            $.each(items, function(itemNo, item) {
                if (itemNo == 0) {
                    series.name = item;
                    console.log('Pushing item category: ' + item)
                } else {
                    series.data.push(parseFloat(item));
                    console.log('Pushing item value: ' + item)
                }
            });
            if (series.data.length != 0) {
                orgmauritaniaminibenchmarkcatalogIdentityOptions.series.push(series);
            }
        }
    });
    // Create the chart
    var chart = new Highcharts.Chart(orgmauritaniaminibenchmarkcatalogIdentityOptions);

});


var orgmauritaniaminibenchmarkcatalogIdentityTrickyOptions = {
    chart: {
        renderTo: 'orgmauritaniaminibenchmarkcatalogIdentityTrickycontainer',
        defaultSeriesType: 'column'
    },
    title: {
        text: 'org.mauritania.minibenchmark.catalog.IdentityTricky'
    },
    xAxis: {
        categories: []
    },
    yAxis: {
        title: {
            text: 'ops per s'
        }
    },
    series: []
};

$.get('report/output/org.mauritania.minibenchmark.catalog.IdentityTricky.csv', function(data) {
    var lines = data.split('\n');

    // Iterate over the lines and add categories or series
    $.each(lines, function(lineNo, line) {
        console.log('Parsing line: ' + line)
        var items = line.split(',');
        // header line contains categories
        if (lineNo == 0) {
            $.each(items, function(itemNo, item) {
                console.log('Pushing category: ' + item)
                if (itemNo > 0) orgmauritaniaminibenchmarkcatalogIdentityTrickyOptions.xAxis.categories.push(item);
            });
        } else {
            // the rest of the lines contain data with their name in the first
            // position
            var series = {
                data: []
            };
            $.each(items, function(itemNo, item) {
                if (itemNo == 0) {
                    series.name = item;
                    console.log('Pushing item category: ' + item)
                } else {
                    series.data.push(parseFloat(item));
                    console.log('Pushing item value: ' + item)
                }
            });
            if (series.data.length != 0) {
                orgmauritaniaminibenchmarkcatalogIdentityTrickyOptions.series.push(series);
            }
        }
    });
    // Create the chart
    var chart = new Highcharts.Chart(orgmauritaniaminibenchmarkcatalogIdentityTrickyOptions);

});


var orgmauritaniaminibenchmarkcatalogPartialFunctionsOptions = {
    chart: {
        renderTo: 'orgmauritaniaminibenchmarkcatalogPartialFunctionscontainer',
        defaultSeriesType: 'column'
    },
    title: {
        text: 'org.mauritania.minibenchmark.catalog.PartialFunctions'
    },
    xAxis: {
        categories: []
    },
    yAxis: {
        title: {
            text: 'ops per s'
        }
    },
    series: []
};

$.get('report/output/org.mauritania.minibenchmark.catalog.PartialFunctions.csv', function(data) {
    var lines = data.split('\n');

    // Iterate over the lines and add categories or series
    $.each(lines, function(lineNo, line) {
        console.log('Parsing line: ' + line)
        var items = line.split(',');
        // header line contains categories
        if (lineNo == 0) {
            $.each(items, function(itemNo, item) {
                console.log('Pushing category: ' + item)
                if (itemNo > 0) orgmauritaniaminibenchmarkcatalogPartialFunctionsOptions.xAxis.categories.push(item);
            });
        } else {
            // the rest of the lines contain data with their name in the first
            // position
            var series = {
                data: []
            };
            $.each(items, function(itemNo, item) {
                if (itemNo == 0) {
                    series.name = item;
                    console.log('Pushing item category: ' + item)
                } else {
                    series.data.push(parseFloat(item));
                    console.log('Pushing item value: ' + item)
                }
            });
            if (series.data.length != 0) {
                orgmauritaniaminibenchmarkcatalogPartialFunctionsOptions.series.push(series);
            }
        }
    });
    // Create the chart
    var chart = new Highcharts.Chart(orgmauritaniaminibenchmarkcatalogPartialFunctionsOptions);

});


var orgmauritaniaminibenchmarkcatalogSeqVsListSumOptions = {
    chart: {
        renderTo: 'orgmauritaniaminibenchmarkcatalogSeqVsListSumcontainer',
        defaultSeriesType: 'column'
    },
    title: {
        text: 'org.mauritania.minibenchmark.catalog.SeqVsListSum'
    },
    xAxis: {
        categories: []
    },
    yAxis: {
        title: {
            text: 'ops per s'
        }
    },
    series: []
};

$.get('report/output/org.mauritania.minibenchmark.catalog.SeqVsListSum.csv', function(data) {
    var lines = data.split('\n');

    // Iterate over the lines and add categories or series
    $.each(lines, function(lineNo, line) {
        console.log('Parsing line: ' + line)
        var items = line.split(',');
        // header line contains categories
        if (lineNo == 0) {
            $.each(items, function(itemNo, item) {
                console.log('Pushing category: ' + item)
                if (itemNo > 0) orgmauritaniaminibenchmarkcatalogSeqVsListSumOptions.xAxis.categories.push(item);
            });
        } else {
            // the rest of the lines contain data with their name in the first
            // position
            var series = {
                data: []
            };
            $.each(items, function(itemNo, item) {
                if (itemNo == 0) {
                    series.name = item;
                    console.log('Pushing item category: ' + item)
                } else {
                    series.data.push(parseFloat(item));
                    console.log('Pushing item value: ' + item)
                }
            });
            if (series.data.length != 0) {
                orgmauritaniaminibenchmarkcatalogSeqVsListSumOptions.series.push(series);
            }
        }
    });
    // Create the chart
    var chart = new Highcharts.Chart(orgmauritaniaminibenchmarkcatalogSeqVsListSumOptions);

});


var orgmauritaniaminibenchmarkcatalogTailRecursiveOptions = {
    chart: {
        renderTo: 'orgmauritaniaminibenchmarkcatalogTailRecursivecontainer',
        defaultSeriesType: 'column'
    },
    title: {
        text: 'org.mauritania.minibenchmark.catalog.TailRecursive'
    },
    xAxis: {
        categories: []
    },
    yAxis: {
        title: {
            text: 'ops per s'
        }
    },
    series: []
};

$.get('report/output/org.mauritania.minibenchmark.catalog.TailRecursive.csv', function(data) {
    var lines = data.split('\n');

    // Iterate over the lines and add categories or series
    $.each(lines, function(lineNo, line) {
        console.log('Parsing line: ' + line)
        var items = line.split(',');
        // header line contains categories
        if (lineNo == 0) {
            $.each(items, function(itemNo, item) {
                console.log('Pushing category: ' + item)
                if (itemNo > 0) orgmauritaniaminibenchmarkcatalogTailRecursiveOptions.xAxis.categories.push(item);
            });
        } else {
            // the rest of the lines contain data with their name in the first
            // position
            var series = {
                data: []
            };
            $.each(items, function(itemNo, item) {
                if (itemNo == 0) {
                    series.name = item;
                    console.log('Pushing item category: ' + item)
                } else {
                    series.data.push(parseFloat(item));
                    console.log('Pushing item value: ' + item)
                }
            });
            if (series.data.length != 0) {
                orgmauritaniaminibenchmarkcatalogTailRecursiveOptions.series.push(series);
            }
        }
    });
    // Create the chart
    var chart = new Highcharts.Chart(orgmauritaniaminibenchmarkcatalogTailRecursiveOptions);

});


</script>
</body>
</html>

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
