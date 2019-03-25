package streams;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1, warmups = 2)
@Warmup(iterations = 2)
@Measurement(iterations = 5)
public class ParallelStreams {
    @State(Scope.Benchmark)
    public static class Data {
        public int iterations = 1000;
        public int arraySize = 100000;
        public int[] array = new int[arraySize];
        public Integer[] integerArray = new Integer[arraySize];
        public Data() {
            Arrays.fill(array, 1);
            Arrays.fill(integerArray,1);
        }
    }

    @Benchmark
    public void intStreamSum(Blackhole blackhole, Data data) {
        int sum = IntStream.range(0, data.iterations).sum();
        blackhole.consume(sum);
    }

    @Benchmark
    public void parallelIntStreamSum(Blackhole blackhole, Data data) {
        int sum = IntStream.range(0, data.iterations).parallel().sum();
        blackhole.consume(sum);
    }

    @Benchmark
    public void integerStreamArraySum(Blackhole blackhole, Data data) {
        Integer sum = Stream.of(data.integerArray).reduce((a, b) -> a + b).orElse(0);
        blackhole.consume(sum);
    }

    @Benchmark
    public void parallelIntegerStreamArraySum(Blackhole blackhole, Data data) {
        Integer sum = Stream.of(data.integerArray).parallel().reduce((a, b) -> a + b).orElse(0);
        blackhole.consume(sum);
    }

    @Benchmark
    public void intStreamMapAndSum(Blackhole blackhole, Data data) {
        int sum = IntStream.range(0, data.iterations).map(i -> i * 10).sum();
        blackhole.consume(sum);
    }

    @Benchmark
    public void intParallelStreamMapAndSum(Blackhole blackhole, Data data) {
        int sum = IntStream.range(0, data.iterations).parallel().map(i -> i * 10).sum();
        blackhole.consume(sum);
    }

}
