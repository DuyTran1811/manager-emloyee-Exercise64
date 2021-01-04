package BT5.exercises;

public class worKingDayException extends Exception {
    private float invalidWordKingDay;

    public worKingDayException() {
    }

    public worKingDayException(float invalidWordKingDay) {
        this.invalidWordKingDay = invalidWordKingDay;
    }

    public worKingDayException(String message, float invalidWordKingDay) {
        super(message);
        this.invalidWordKingDay = invalidWordKingDay;
    }

    public float getInvalidWordKingDay() {
        return invalidWordKingDay;
    }
}
