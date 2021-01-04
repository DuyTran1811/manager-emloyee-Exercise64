package BT4.comparator;

import BT4.Smartphone;

import java.util.Comparator;

public class SortPriceDow implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        if (o1.getPrice() > o2.getPrice()) return -1;
        if (o1.getPrice() < o2.getPrice()) return 0;
        return 1;
    }
}
