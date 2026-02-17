package Exceptions;

public class EmptyInventorySlot extends RuntimeException {
    public EmptyInventorySlot(String message) {
        super(message);
    }
}
