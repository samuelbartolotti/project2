package Exceptions;

public class NoneWeaponInYourSlot extends RuntimeException {
    public NoneWeaponInYourSlot(String message) {
        super(message);
    }
}
