package colruyt.pcrsejb.util.exceptions.bl;

public class UserIsNotMemberOfTeamException extends Exception {

    public UserIsNotMemberOfTeamException() {
    }

    public UserIsNotMemberOfTeamException(String message) {
        super(message);
    }

    public UserIsNotMemberOfTeamException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIsNotMemberOfTeamException(Throwable cause) {
        super(cause);
    }

    public UserIsNotMemberOfTeamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
