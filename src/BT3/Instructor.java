package BT3;

public class Instructor {
    private String id;
    private String fullName;
    private String major;
    private long salary;
    private float experience;

    public Instructor() {
    }

    public Instructor(String id) {
        this.id = id;
    }

    public Instructor(String id, String fullName,
                      String major, long salary, float experience) {
        this.id = id;
        this.fullName = fullName;
        this.major = major;
        this.salary = salary;
        this.experience = experience;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSalary(long salary)throws InvalidSalaryException {
        if (salary >= 0 && salary <= 5000000l) {
        this.salary = salary;
        }else {
            this.salary = 0;
            var smg = "Muc luong Khong Hop le "+salary;
            throw new InvalidSalaryException(smg,salary);
        }
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getMajor() {
        return major;
    }

    public long getSalary() {
        return salary;
    }

    public float getExperience() {
        return experience;
    }
}
