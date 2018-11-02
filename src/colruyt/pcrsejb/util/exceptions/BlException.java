package colruyt.pcrsejb.util.exceptions;

public class BlException extends Exception {

    public BlException() {
        super();
    }

    public BlException(String message) {
        super(message);
    }

    public BlException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlException(Throwable cause) {
        super(cause);
    }

    protected BlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
