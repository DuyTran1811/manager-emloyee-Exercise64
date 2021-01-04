package BT4.comparator;

import BT4.InvalidBrandNameException;
import BT4.Smartphone;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var choice = 0;
        var smartPhoneList = new ArrayList<Smartphone>();
        do {
            System.out.println("=================== MENU ===================");
            System.out.println("1. Thêm 1 smartphone vào danh sách");
            System.out.println("2. Sắp xếp smartphone theo tên hãng a-z");
            System.out.println("3. Sắp xếp smartphone theo giá bán giảm dần");
            System.out.println("4. Sắp xếp smartphone theo giá bán tăng dần");
            System.out.println("5. Sắp xếp smartphone theo năm sản xuất cũ->mới");
            System.out.println("6. Sắp xếp smartphone theo năm sản xuất mới->cũ");
            System.out.println("7. Hiển thị danh sách smartphone ra màn hình");
            System.out.println("0. Thoát chương trình");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 0:
                    System.out.println("Cam On Ban da Su dung dich vu");
                    System.exit(0);
                case 1:
                    Smartphone smartphone = ceatSmartPhone(input);
                    if (smartphone != null) smartPhoneList.add(smartphone);
                    else System.out.println("Tao That Bai");
                    break;
                case 2:
                    if (smartPhoneList.size() > 0) {
                        smartPhoneList.sort(new SorNameAZ());
                        show(smartPhoneList);
                    } else System.out.println("Danh Sach Rong");
                    break;
                case 3:
                    if (smartPhoneList.size() > 0) {
                        smartPhoneList.sort(new SortPriceDow());
                        show(smartPhoneList);
                    } else System.out.println("Danh sach Rong");
                    break;
                case 4:
                    if (smartPhoneList.size() > 0) {
                        smartPhoneList.sort(new SortPriceUp());
                        show(smartPhoneList);
                    } else System.out.println("Dach Sach Rong");
                    break;
                case 5:
                    if (smartPhoneList.size()>0){
                        smartPhoneList.sort(new SortYearDow());
                        show(smartPhoneList);
                    }else System.out.println("Danh sach rong");
                    break;
                case 6:
                    if (smartPhoneList.size()>0){
                        smartPhoneList.sort(new SortPriceUp());
                        show(smartPhoneList);
                    }else System.out.println("Danh Sach Rong");
                    break;
                case 7:
                    if (smartPhoneList.size()>0)
                        show(smartPhoneList);
                    break;
            }
        } while (true);
    }

    private static void show(ArrayList<Smartphone> smartPhoneList) {
        System.out.printf("%-20s%-20s%-20s%-15s%-15s%-15s\n",
                "Mã thiết bị", "Hãng sản xuất", "Tên thiết bị",
                "Giá bán", "Năm sản xuất", "Màn hình");
        for (var smartphone : smartPhoneList) {
            System.out.printf("%-20s%-20s%-20s%-15.2f%-15d%-15s\n",
                    smartphone.getId(), smartphone.getBrand(),
                    smartphone.getName(), smartphone.getPrice(),
                    smartphone.getYear(), smartphone.getScreenSize());
        }
    }

    private static Smartphone ceatSmartPhone(Scanner input) {
        System.out.println("Mã thiết bị: ");
        var id = input.nextLine();
        System.out.println("Hãng sản xuất: ");
        var brand = input.nextLine();
        System.out.println("Tên thiết bị: ");
        var name = input.nextLine();
        System.out.println("Giá bán: ");
        var price = Float.parseFloat(input.nextLine());
        System.out.println("Năm sản xuất: ");
        var year = Integer.parseInt(input.nextLine());
        System.out.println("Kích thước màn hình: ");
        var screenSize = input.nextLine();
        try {
            return new Smartphone(id, brand, name, price, year, screenSize);
        } catch (InvalidBrandNameException e) {
            e.printStackTrace();
            return null;
        }
    }
}
