package methods;

public class NoStackTraceException extends RuntimeException {

    public NoStackTraceException() {
        super("message", new IllegalArgumentException(), true, false);
    }

    protected NoStackTraceException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
