package methods;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class Methods {


    private static void throwStackTraceException() throws StackTraceException {
        throw new StackTraceException();
    }

    private static void throwNoStackTraceException() throws NoStackTraceException {
        throw new NoStackTraceException();
    }

    @Benchmark
    public void exceptionProcessingWithStackTrace() {
        try {
            throwStackTraceException();
        } catch (StackTraceException e) {
            // ignore
        }
    }

    @Benchmark
    public void exceptionProcessingWithoutStackTrace() {
        try {
            throwNoStackTraceException();
        } catch (NoStackTraceException e) {
            e.getStackTrace();
        }
    }

}
