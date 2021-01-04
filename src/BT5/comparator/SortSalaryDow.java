package BT5.comparator;

import BT5.Employee;

import java.util.Comparator;

public class SortSalaryDow implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Float.compare(o2.getSalary(), o1.getSalary());
    }
}
