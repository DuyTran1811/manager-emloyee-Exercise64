package BT5.comparator;

import BT5.Employee;

import java.util.Comparator;

public class SortAgeAscending implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Long.compare(o1.getDateOfBirth().getTime(), o2.getDateOfBirth().getTime());
    }
}
