package Exceptions;

public class CantWalkIntoWall extends RuntimeException {
    public CantWalkIntoWall(String message) {
        super(message);
    }
}
