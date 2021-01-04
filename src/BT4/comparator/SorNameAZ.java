package BT4.comparator;

import BT4.Smartphone;

import java.util.Comparator;

public class SorNameAZ implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getBrand().compareTo(o2.getBrand());
    }
}
