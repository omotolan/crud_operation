package exception;

public class UserDoesNotExistException extends CrudOperationException {
    public UserDoesNotExistException(String message) {
        super(message);
    }
}
