package BT5;

import BT5.exercises.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String empFileName = "EMP.CSV";
        Methods methods = new Methods();
        var input = new Scanner(System.in);
        var employeesList = new ArrayList<Employee>(methods.readFileName(empFileName));
        var choice = 0;
        do {
            System.out.println("=================== MENU ===================");
            System.out.println("1. Thêm mới 1 nhân viên");
            System.out.println("2. Hiển thị thông tin các nhân viên");
            System.out.println("3. Tìm nhân viên theo tên");
            System.out.println("4. Tìm nhân viên có mức lương >= x");
            System.out.println("5. Tìm giám đốc theo nhiệm kì");
            System.out.println("6. Xóa nhân viên theo mã cho trước");
            System.out.println("7. Tính lương nhân viên");
            System.out.println("8. Tính thưởng nhân viên");
            System.out.println("9. Sắp xếp danh sách nhân viên");
            System.out.println("10. Hiển thị mức thưởng và cách nhận thưởng");
            System.out.println("11. Hiển thị bảng lương");
            System.out.println("12. Lưu danh sách nhân viên, giám đốc");
            System.out.println("0. Thoát chương trình");
            System.out.println("Xin mời bạn chọn: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("Chọn \n1: Thêm nhân viên hoặc 2: Thêm giám đốc");
                    var slot = Integer.parseInt(input.nextLine());
                    if (slot == 1) {
                        Employee emp = null;
                        try {
                            emp = methods.ceartNewEmployee(input);
                            employeesList.add(emp);
                        } catch (dateFormatException e) {
                            e.printStackTrace();
                        }
                    } else if (slot == 2) {
                        var emp = methods.ceartManager(input);
                        if (emp != null) {
                            employeesList.add(emp);
                        } else {
                            System.out.println("Vui Long Chon Lai");
                        }
                    }
                    break;
                case 2:
                    if (employeesList.size() > 0) {
                        methods.show(employeesList);
                    } else {
                        System.out.println("Danh Sach Rong");
                    }
                    break;
                case 3:
                    if (employeesList.size() > 0) {
                        var name = "";
                        System.out.println("Nhap Nhan vien Can Tim");
                        name = input.next();
                        input.nextLine();
                        var result = methods.searchByName(employeesList, name);
                        if (result.size() > 0) {
                            System.out.println("Tim Thay " + result.size() + "Ket Qua");
                            methods.show(result);
                        } else {
                            System.out.println("Khong Tim Thay Nhan Vien Nao Ten " + name);
                        }
                    } else {
                        System.out.println("Danh Sach Rong");
                    }
                    break;
                case 4:
                    if (employeesList.size() > 0) {
                        System.out.println("Nhap Muc Luong Can tim");
                        var salary = Float.parseFloat(input.nextLine());
                        var result = methods.searchSalary(employeesList, salary);
                        if (result.size() > 0) {
                            System.out.println("Tim Thay " + result.size() + " ket Qua");
                            methods.show(result);
                        } else {
                            System.out.println("Khong Tim Thay");
                        }
                    } else {
                        System.out.println("Danh Sach Rong");
                    }
                    break;
                case 5:
                    if (employeesList.size() > 0) {
                        System.out.println("Nhap Bat Dau Nhiem Ky Vi Du 2020");
                        var startYear = Integer.parseInt(input.nextLine());
                        System.out.println("Nhap Nam Ket thuc");
                        var endYear = Integer.parseInt(input.nextLine());
                        var result = methods.findManagerTrem(employeesList, startYear, endYear);
                        if (result.size() > 0) {
                            System.out.println("Tim Thay " + result.size() + " Ket Qua");
                        } else {
                            System.out.println("Khong Tim Thay ket qua");
                        }
                    } else {
                        System.out.println("Danh Sach Rong");
                    }
                    break;
                case 6:
                    if (employeesList.size() > 0) {
                        System.out.println("Nhap Ma Nhan Vien");
                        var id = input.nextLine();
                        var isDeleted = methods.remove(employeesList, id);
                        if (isDeleted) {
                            System.out.println("Xoa Thanh cong");
                        } else {
                            System.out.println("Xoa That Bai");
                        }
                    } else {
                        System.out.println("Danh Sach Rong");
                    }
                case 7:
                    if (employeesList.size() > 0) {
                        methods.caculatorSalary(employeesList);
                    } else {
                        System.out.println("Danh Sach Nhan Vien rong");
                    }
                    break;
                case 8:
                    if (employeesList.size() > 0) {
                        methods.caculatorBonus(employeesList);
                    } else {
                        System.out.println("Danh Sach Rong");
                    }
                    break;
                case 9:
                    if (employeesList.size() > 0) {
                        System.out.println("Chọn tiêu chí sắp xếp: ");
                        System.out.println("1. Tên tăng dần a-z");
                        System.out.println("2. Tên giảm dần z-a");
                        System.out.println("3. Mức lương tăng dần");
                        System.out.println("4. Mức lương giảm dần");
                        System.out.println("5. Số năm kinh nghiệm tăng dần");
                        System.out.println("6. Số năm kinh nghiệm giảm dần");
                        System.out.println("7. Từ trẻ đến già");
                        System.out.println("8. Từ già đến trẻ");
                        System.out.println("9. Tổng lương thực lĩnh giảm dần");
                        var option = Integer.parseInt(input.nextLine());
                        methods.sortEmployee(employeesList, option);
                        methods.show(employeesList);
                    } else {
                        System.out.println("Danh Sach Nhan Vien Rong");
                    }
                    break;
                case 10:
                    if (employeesList.size() > 0) {
                        methods.showBonus(employeesList);
                    } else {
                        System.out.println("Danh Sach Rong");
                    }
                    break;
                case 11:
                    if (employeesList.size() > 0) {
                        methods.showPlayroll(employeesList);
                    } else {
                        System.out.println("Danh Sach Rong");
                    }
                    break;
                case 12:
                    if (employeesList.size() > 0) {
                        var isSuccess = methods.writeEmpToFile(employeesList, empFileName);
                        if (isSuccess) {
                            System.out.println("Ghi File Thanh Cong");
                        } else {
                            System.out.println("Ghi File That bai");
                        }
                    } else {
                        System.out.println("Danh Sach Nhan Vien Rong");
                    }
                    break;
            }
        } while (true);
    }
}
