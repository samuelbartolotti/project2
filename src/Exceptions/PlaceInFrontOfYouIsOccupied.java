package Exceptions;

public class PlaceInFrontOfYouIsOccupied extends RuntimeException {
    public PlaceInFrontOfYouIsOccupied(String message) {
        super(message);
    }
}
