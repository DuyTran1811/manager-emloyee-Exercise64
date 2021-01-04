package BT5.exercises;

public class dateFormatException extends Exception {
    private String invalidDateForm;

    public dateFormatException() {
    }

    public dateFormatException(String invalidDateForm) {
        this.invalidDateForm = invalidDateForm;
    }

    public dateFormatException(String message, String invalidDateForm) {
        super(message);
        this.invalidDateForm = invalidDateForm;
    }

    public String getInvalidDateForm() {
        return invalidDateForm;
    }
}
