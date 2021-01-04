package BT5.exercises;

public class nameException extends Exception{
    private String invalidName;

    public nameException() {
    }

    public nameException(String invalidName) {
        this.invalidName = invalidName;
    }

    public nameException(String message, String invalidName) {
        super(message);
        this.invalidName = invalidName;
    }

    public String getInvalidName() {
        return invalidName;
    }
}
