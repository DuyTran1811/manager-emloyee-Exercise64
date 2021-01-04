package BT5.comparator;

import BT5.Employee;

import java.util.Comparator;

public class SortByNameAZ implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.getFullName().getFirst().compareTo(o1.getFullName().getFirst());
    }
}
