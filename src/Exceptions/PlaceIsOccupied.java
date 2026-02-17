package Exceptions;

public class PlaceIsOccupied extends RuntimeException {
    public PlaceIsOccupied(String message) {
        super(message);
    }
}
