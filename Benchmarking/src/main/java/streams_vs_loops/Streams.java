package streams_vs_loops;

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
public class Streams {

    @State(Scope.Benchmark)
    public static class Data {
        public int iterations = 1000;
        public int arraySize = 1000;
        public int[] array = new int[arraySize];
        public Integer[] integerArray = new Integer[arraySize];
        public Data() {
            Arrays.fill(array, 1);
            Arrays.fill(integerArray,1);
        }
    }

    @Benchmark
    public void forLoopSum(Blackhole blackhole, Data data) {
        int sum = 0;
        for (int i = 0; i < data.iterations; ++i) {
            sum += i;
        }
        blackhole.consume(sum);
    }

    @Benchmark
    public void intStreamSum(Blackhole blackhole, Data data) {
        int sum = IntStream.range(0, data.iterations).sum();
        blackhole.consume(sum);
    }

    @Benchmark
    public void forEachArraySum(Blackhole blackhole, Data data) {
        int sum = 0;
        for (int i : data.array) {
            sum += i;
        }
        blackhole.consume(sum);
    }

    @Benchmark
    public void intStreamArraySum(Blackhole blackhole, Data data) {
        int sum = Arrays.stream(data.array).sum();
        blackhole.consume(sum);
    }

    @Benchmark
    public void forArraySum(Blackhole blackhole, Data data) {
        int sum = 0;
        for (int i = 0; i < data.array.length; ++i) {
            sum += data.array[i];
        }
        blackhole.consume(sum);
    }

    @Benchmark
    public void integerStreamArraySum(Blackhole blackhole, Data data) {
        Integer sum = Stream.of(data.integerArray).reduce((a, b) -> a + b).orElse(0);
        blackhole.consume(sum);
    }

    @Benchmark
    public void integerForArraySum(Blackhole blackhole, Data data) {
        Integer sum = 0;
        for (int i = 0; i < data.integerArray.length; ++i) {
            sum += data.integerArray[i];
        }
        blackhole.consume(sum);
    }

    @Benchmark
    public void integerForEachArraySum(Blackhole blackhole, Data data) {
        Integer sum = 0;
        for (Integer i:data.integerArray) {
            sum += i;
        }
        blackhole.consume(sum);
    }

}
