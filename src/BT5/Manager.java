package BT5;

import BT5.exercises.nameException;
import BT5.exercises.worKingDayException;

import java.util.Date;

public class Manager extends Employee {
    private Date startDate;
    private Date endDate;

    public Manager() {
    }

    public Manager(Employee emp, Date startDate, Date endDate) throws worKingDayException, nameException {
        super(emp.getId(), emp.getFullNameString(), emp.getAddress(),
                emp.getDateOfBirth(), emp.getEmail(), emp.getPhoneNumber(),
                emp.getEmpId(), emp.getDuty(), emp.getSalary(),
                emp.getExperience(), emp.getWorkingDay(),
                emp.getTotalSalary(), emp.getBonus());
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public Manager(String empId, String duty,
                   float salary, float experience,
                   float workingDay, float totalSalary,
                   float bonus, Date startDate, Date endDate) throws worKingDayException {
        super(empId, duty, salary, experience, workingDay, totalSalary, bonus);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Manager(String id, String fullName,
                   String address, Date dateOfBirth,
                   String email, String phoneNumber,
                   String empId, String duty, float salary,
                   float experience, float workingDay,
                   float totalSalary, float bonus, Date startDate,
                   Date endDate) throws worKingDayException, nameException {
        super(id, fullName, address, dateOfBirth,
                email, phoneNumber, empId, duty,
                salary, experience, workingDay, totalSalary, bonus);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public void caculateBonus() {
        if (getWorkingDay() >= 22) {
            setBonus(getTotalSalary() * 1.25f);
        } else {
            setBonus(0);
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
