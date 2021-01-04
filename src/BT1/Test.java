package BT1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhap Ten Con Meo: ");
        var name = input.nextLine();
        Cat cat = new Cat(name);
        System.out.println("Nhap Tuoi Cua Con meo: ");
        var age = input.nextLine().trim();
        var age_ = Integer.parseInt(age);
        try {
            cat.setAge(age_);
        } catch (TreatException e) {
            e.printStackTrace();
            System.out.println("Tuoi Khong Hop Le tu 0-20.");
        }
        showInfor(cat);
    }

    private static void showInfor(Cat cat) {
        System.out.println("==========MEOW==========");
        System.out.println("Pet name: " + cat.getPetName());
        System.out.println("Age: "+ cat.getAge());
    }
}
