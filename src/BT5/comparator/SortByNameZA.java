package BT5.comparator;

import BT5.Employee;
import BT5.Person;

import java.util.Comparator;

public class SortByNameZA implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getFullName().getFirst().compareTo(o2.getFullName().getFirst());
    }
}
