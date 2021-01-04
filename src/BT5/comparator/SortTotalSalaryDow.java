package BT5.comparator;

import BT5.Employee;

import java.util.Comparator;

public class SortTotalSalaryDow implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Float.compare(o2.getTotalSalary(),o1.getTotalSalary());
    }
}
