package Exceptions;

public class NotEnoughManyException extends RuntimeException {
    public NotEnoughManyException(String message) {
        super(message);
    }
}
