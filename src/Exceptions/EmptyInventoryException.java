package Exceptions;

public class EmptyInventoryException extends RuntimeException {
    public EmptyInventoryException(String message) {
        super(message);
    }
}
