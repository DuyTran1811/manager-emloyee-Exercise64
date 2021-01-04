package BT5.comparator;

import BT5.Employee;

import java.util.Comparator;

public class SortExperienceAscending implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getExperience() < o2.getExperience()) return -1;
        if (o1.getExperience() > o2.getExperience()) return 0;
        return 1;
    }
}
