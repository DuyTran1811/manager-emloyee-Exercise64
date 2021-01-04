package BT1;

public class Cat {
    private String color;
    private int age;
    private String petName;
    private String favoriteFood;

    public Cat() {
    }

    public Cat(String petName) {
        this.petName = petName;
    }

    public Cat(String color, int age, String petName, String favoriteFood) {
        this.color = color;
        this.age = age;
        this.petName = petName;
        this.favoriteFood = favoriteFood;
    }

    public void setAge(int age) throws TreatException {
        if (age > 0 && age <= 20) {
            this.age = age;
        } else {
            this.age = 0;
            var smg = "Tuoi Khong Hop Le" + age;
            throw new TreatException(smg, age);
        }
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public String getPetName() {
        return petName;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }
}
