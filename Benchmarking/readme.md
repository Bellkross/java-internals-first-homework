# Java GL ProCamp Benchmarking task
Author: Kyrylo Vasylenko\
Teacher: Andrii Rodionov

## Results

### Methods with\without stack trace benchmarking

#### 1. With StackTrace operations per milliseconds

    Result "methods.Methods.exceptionProcessingWithStackTrace":
    331,387 ±(99.9%) 27,725 ops/ms [Average]
  
#### 2. Without StackTrace operations per milliseconds

    Result "methods.Methods.exceptionProcessingWithoutStackTrace":
    609,366 ±(99.9%) 43,785 ops/ms [Average]
  
#### 3. Summary
##### Exception processing with stack trace
    Mode: thrpt
    Cnt: 25
    Score: 331,387 operations per ms
    Error: ± 27,725 operations per ms

##### Exception processing without stack trace
    Mode: thrpt
    Cnt: 25
    Score: 609,366 operations per ms
    Error: ± 43,785 operations per ms

- Exceptions without stack trace more efficient in ~1.8 times than with stack trace.
___
### Streams vs loops

#### 1. Sum of int array

###### 1.1. For array sum

    Result "streams_vs_loops.Streams.forArraySum":
    2632,629 ±(99.9%) 530,771 ops/ms [Average]

##### 1.2. For each array sum

    Result "streams_vs_loops.Streams.forEachArraySum":
    2745,479 ±(99.9%) 158,783 ops/ms [Average]
  
##### 1.3. intStream array sum

    Result "streams_vs_loops.Streams.intStreamArraySum":
    425,737 ±(99.9%) 28,037 ops/ms [Average]

#### Example summary
- For loop more efficient than for-each loop in ~3.3 times
- For each loop more efficient than intStream in ~5.5 times
- For loop more efficient than intStream in ~18.9 times
  
#### 2. Sum of elements from 0 to n with iteration

##### 2.1. Plain iteration sum with for loop

    Result "streams_vs_loops.Streams.forLoopSum":
    2727,513 ±(99.9%) 98,306 ops/ms [Average]
  
##### 2.2. Plain iteration sum with intStream

    Result "streams_vs_loops.Streams.intStreamSum":
    240,543 ±(99.9%) 401,378 ops/ms [Average]
    
#### Example summary
- intStream more efficient than for loop in ~4 times

#### 3. Sum of Integer array

##### 3.1. For loop

    Result "streams_vs_loops.Streams.integerForArraySum":
    199,142 ±(99.9%) 91,670 ops/ms [Average]

##### 3.2. For each loop

    Result "streams_vs_loops.Streams.integerForEachArraySum":
    286,267 ±(99.9%) 2,410 ops/ms [Average]

##### 3.3. Stream

    Result "streams_vs_loops.Streams.integerStreamArraySum":
    182,526 ±(99.9%) 74,099 ops/ms [Average]

#### Example summary
- For loop more efficient than for-each loop in ~38 times
- For loop more efficient than intStream in ~1.2 times
    
#### Summary

    Sum of int Array:
    Benchmark                        Mode  Cnt     Score     Error   Units
    Streams.forArraySum             thrpt    5  2632,629 ± 530,771  ops/ms
    Streams.forEachArraySum         thrpt    5  2745,479 ± 158,783  ops/ms
    Streams.intStreamArraySum       thrpt    5   425,737 ±  28,037  ops/ms
    Streams.forLoopSum              thrpt    5  2727,513 ±  98,306  ops/ms
    Streams.intStreamSum            thrpt    5   240,543 ± 401,378  ops/ms
    Streams.integerForArraySum      thrpt    5   199,142 ±  91,670  ops/ms
    Streams.integerForEachArraySum  thrpt    5   286,267 ±   2,410  ops/ms
    Streams.integerStreamArraySum   thrpt    5   182,526 ±  74,099  ops/ms