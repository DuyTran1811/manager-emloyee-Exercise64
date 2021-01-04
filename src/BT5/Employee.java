package BT5;

import BT5.exercises.*;

import java.util.Date;

public class Employee extends Person {
    private static int nextId = 101;
    private String empId; // mã nhân viên
    private String duty; // chức vụ
    private float salary; // lương
    private float experience; // số năm kinh nghiệm
    private float workingDay; // số ngày làm việc
    private float totalSalary; // tổng lương
    private float bonus; // thưởng

    public Employee() {
    }


    public Employee(String empId, String duty, float salary,
                    float experience, float workingDay,
                    float totalSalary, float bonus) throws worKingDayException {
        setEmpId(empId);
        this.duty = duty;
        this.salary = salary;
        this.experience = experience;
        this.setWorkingDay(workingDay);
        this.totalSalary = totalSalary;
        this.bonus = bonus;
    }

    public Employee(String id, String fullName, String address,
                    Date dateOfBirth, String email, String phoneNumber,
                    String empId, String duty, float salary, float experience,
                    float workingDay, float totalSalary, float bonus) throws nameException, worKingDayException {
        super(id, fullName, address, dateOfBirth, email, phoneNumber);
        setEmpId(empId);
        this.duty = duty;
        this.setSalary(salary);
        this.experience = experience;
        this.setWorkingDay(workingDay);
        this.totalSalary = totalSalary;
        this.bonus = bonus;
    }

    // Tinh Luong Thuong
    public void caculateBonus() {
        if (workingDay >= 20) {
            var bonusDay = workingDay - 20;
            bonus = bonusDay * 0.5f * salary / 22;
        } else {
            bonus = 0;
        }
    }

    public void receiveSalary() {
        System.out.println("Muc Luong Chuyen Khoan Nhan Vien " +
                getFullNameString() + ": " + totalSalary);
    }

    public void calculateTotalSalary() {
        totalSalary = workingDay * salary / 22 + bonus;
    }

    /**
     * Phuong thuc kiem tra ID
     *
     * @param empId ID of empID
     */
    public void setEmpId(String empId) {
        if (empId == null) {
            this.empId = "EMP" + nextId;
            nextId++;
        } else {
            this.empId = empId;
        }
    }

    /**
     * Phuong thuc bat loi exception WorKing Day
     *
     * @param workingDay Ngay Lam Viec
     * @throws worKingDayException Su Ly Loi
     */
    public void setWorkingDay(float workingDay) throws worKingDayException {
        if (workingDay >= 0 && workingDay <= 30) {
            this.workingDay = workingDay;
        } else {
            var msg = "Ngay Khong Hop Le " + workingDay;
            throw new worKingDayException(msg, workingDay);
        }
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public static int getNextId() {
        return nextId;
    }

    public String getEmpId() {
        return empId;
    }

    public String getDuty() {
        return duty;
    }

    public float getSalary() {
        return salary;
    }

    public float getExperience() {
        return experience;
    }

    public float getWorkingDay() {
        return workingDay;
    }

    public float getTotalSalary() {
        return totalSalary;
    }

    public float getBonus() {
        return bonus;
    }
}
