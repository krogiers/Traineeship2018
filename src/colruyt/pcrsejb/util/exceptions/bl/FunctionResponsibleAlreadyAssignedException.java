package colruyt.pcrsejb.util.exceptions.bl;

public class FunctionResponsibleAlreadyAssignedException extends Exception {

    public FunctionResponsibleAlreadyAssignedException() {
    }

    public FunctionResponsibleAlreadyAssignedException(String message) {
        super(message);
    }

    public FunctionResponsibleAlreadyAssignedException(String message, Throwable cause) {
        super(message, cause);
    }

    public FunctionResponsibleAlreadyAssignedException(Throwable cause) {
        super(cause);
    }

    public FunctionResponsibleAlreadyAssignedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
