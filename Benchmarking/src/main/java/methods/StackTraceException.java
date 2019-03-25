package methods;

public class StackTraceException extends RuntimeException {

    public StackTraceException() {
        super("message", new IllegalArgumentException(), false, true);
    }

    protected StackTraceException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
