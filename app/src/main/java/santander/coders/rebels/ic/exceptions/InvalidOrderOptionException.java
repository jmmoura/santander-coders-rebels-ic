package santander.coders.rebels.ic.exceptions;

public class InvalidOrderOptionException extends Exception{
    public InvalidOrderOptionException(String message) {
        super(message);
    }

    public InvalidOrderOptionException(String message, Throwable cause) {
        super(message, cause);
    }
}
