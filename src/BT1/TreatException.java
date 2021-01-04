package BT1;

public class TreatException extends Exception {
    private int invalidAge;

    public TreatException(int invalidAge) {
        this.invalidAge = invalidAge;
    }

    public TreatException(String message, int invalidAge) {
        super(message);
        this.invalidAge = invalidAge;
    }

    public int getInvalidAge() {
        return invalidAge;
    }
}
