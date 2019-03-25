# Java GL ProCamp Benchmarking task
Author: Kyrylo Vasylenko\
Teacher: Andrii Rodionov

## Results

### Methods with\without stack trace benchmarking
___
#### With StackTrace operations per milliseconds

Result "methods.Methods.exceptionProcessingWithStackTrace":
  331,387 ±(99.9%) 27,725 ops/ms [Average]
  (min, avg, max) = (239,112, 331,387, 387,807), stdev = 37,012
  CI (99.9%): [303,662, 359,111] (assumes normal distribution)
  
#### Without StackTrace operations per milliseconds

Result "methods.Methods.exceptionProcessingWithoutStackTrace":
  609,366 ±(99.9%) 43,785 ops/ms [Average]
  (min, avg, max) = (465,382, 609,366, 678,948), stdev = 58,451
  CI (99.9%): [565,581, 653,150] (assumes normal distribution)
  
#### Summary
##### Exception processing with stack trace
Mode: thrpt\
Cnt: 25\
Score: 331,387 operations per ms\
Error: ± 27,725 operations per ms

##### Exception processing without stack trace
Mode: thrpt\
Cnt: 25\
Score: 609,366 operations per ms\
Error: ± 43,785 operations per ms

Exceptions without stack trace more efficient in ~1.8 times than with stack trace.

