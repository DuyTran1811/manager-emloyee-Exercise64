package BT5;

import BT5.comparator.*;
import BT5.exercises.dateFormatException;
import BT5.exercises.nameException;
import BT5.exercises.worKingDayException;

import javax.naming.InvalidNameException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Methods {

    public Employee ceartNewEmployee(Scanner input) throws dateFormatException {
        String format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        System.out.println("Nhap So CMTND");
        var cmt = input.nextLine();
        System.out.println("Nhap Ho Va Ten");
        var fullName = input.nextLine();
        System.out.println("Nhap Dia Chi");
        var address = input.nextLine();
        System.out.println("Nhap Email");
        var email = input.nextLine();
        System.out.println("Nhap Ngay Sinh");
        Date dateOfBirth = null;
        var dateStr = input.nextLine().trim();
        if (!dateStr.matches("\\d{2}/\\d{2}/\\d{4}")) {
            var smg = "Ngay Sinh Khong Dung Dinh Dang dd/MM/yyyy" + dateStr;
            throw new dateFormatException(smg, dateStr);
        }
        try {
            dateOfBirth = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            dateOfBirth = new Date();
        }
        System.out.println("Nhap So Dien thoai");
        var phoneNumber = input.nextLine();
        System.out.println("Chuc Vu");
        var duty = input.nextLine();
        System.out.println("Muc Luong");
        var salary = Float.parseFloat(input.nextLine());
        System.out.println("So Nam Kinh Ngiem");
        var exp = Float.parseFloat(input.nextLine());
        System.out.println("So Ngay Lam Viec Trong Thang");
        var work = Float.parseFloat(input.nextLine());
        try {
            return new Employee(cmt, fullName, address, dateOfBirth, email, phoneNumber, null, duty, salary, exp, work, 0, 0);
        } catch (nameException | worKingDayException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Manager ceartManager(Scanner input) {
        String format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Employee employee = null;
        try {
            employee = ceartNewEmployee(input);
        } catch (dateFormatException e) {
            e.printStackTrace();
        }
        System.out.println("Ngay Bat Dau Nhiem Ki dd/MM/yyyy");
        Date startDate = null;
        try {
            startDate = dateFormat.parse(input.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Ngay Ket Thuc Nhiem Ky");
        Date endDate = null;
        try {
            endDate = dateFormat.parse(input.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            return new Manager(employee, startDate, endDate);
        } catch (nameException | worKingDayException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void show(ArrayList<Employee> employeesList) {
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        System.out.println("Danh sách nhân viên");
        System.out.printf("%-12s%-25s%-15s%-15s%-20s%-15s%-15s%-15s%-15s%-15s\n",
                "Số CMT", "Tên NV", "Địa chỉ", "Ngày sinh", "Email",
                "Số ĐT", "Mã NV", "Chức vụ", "Lương", "Kinh nghiệm");
        for (var emp : employeesList) {
            System.out.printf("%-12s%-25s%-15s%-15s%-20s" +
                            "%-15s%-15s%-15s%-15.2f%-15.2f\n",
                    emp.getId(), emp.getFullNameString(), emp.getAddress(),
                    dateFormat.format(emp.getDateOfBirth()), emp.getEmail(),
                    emp.getPhoneNumber(), emp.getEmpId(), emp.getDuty(),
                    emp.getSalary(), emp.getExperience());
        }
    }

    public ArrayList<Employee> searchByName(ArrayList<Employee> employeesList, String name) {
        ArrayList<Employee> list = new ArrayList<>();
        for (var emp : employeesList) {
            if (emp.getFullName().getFirst().compareTo(name) == 0) {
                list.add(emp);
            }
        }
        return list;
    }

    public ArrayList<Employee> searchSalary(ArrayList<Employee> employeesList, float salary) {
        ArrayList<Employee> list = new ArrayList<>();
        for (var emp : employeesList) {
            if (emp.getSalary() >= salary) {
                list.add(emp);
            }
        }
        return list;
    }

    public ArrayList<Employee> findManagerTrem(ArrayList<Employee> employeesList, int startYear, int endYear) {
        ArrayList<Employee> list = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (var emp : employeesList) {
            if (emp instanceof Manager) {
                var manager = (Manager) emp;
                calendar.setTime(manager.getStartDate());
                var start = calendar.get(Calendar.YEAR);
                calendar.setTime(manager.getEndDate());
                var end = calendar.get(Calendar.YEAR);
                // nếu nhiệm kì cần tìm nằm trong giai đoạn
                // nhiệm kì của manager hiện tại, add vào danh sách kết quả
                if (start <= startYear && end >= endYear) {
                    list.add(manager);
                }
            }
        }
        return list;
    }

    public Boolean remove(ArrayList<Employee> employeesList, String id) {
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).getId().compareTo(id) == 0) {
                employeesList.remove(i);
                return true;
            }
        }
        return false;
    }

    public void caculatorSalary(ArrayList<Employee> employeesList) {
        for (Employee emp : employeesList) {
            emp.calculateTotalSalary();
        }
    }

    public void caculatorBonus(ArrayList<Employee> employeesList) {
        for (var emp : employeesList) {
            emp.caculateBonus();
        }
    }

    public void sortEmployee(ArrayList<Employee> list, int option) {
        switch (option) {
            case 1:
                list.sort(new SortByNameAZ());
                break;
            case 2:
                list.sort(new SortByNameZA());
                break;
            case 3:
                list.sort(new SortSalaryUp());
                break;
            case 4:
                list.sort(new SortSalaryDow());
                break;
            case 5:
                list.sort(new SortExperienceAscending());
                break;
            case 6:
                list.sort(new SortExperienceDow());
                break;
            case 7:
                list.sort(new SortAgeAscending());
                break;
            case 8:
                list.sort(new SortAgeDow());
                break;
        }
    }

    public void showBonus(ArrayList<Employee> employeesList) {
        System.out.printf("%-15s%-25s%-15s\n", "Mã NV", "Tên NV", "Bonus");
        for (var emp : employeesList) {
            System.out.printf("%-15s%-25s%-15.2f\n", emp.getEmpId(), emp.getFullNameString(), emp.getBonus());
        }
    }

    public void showPlayroll(ArrayList<Employee> employeesList) {
        System.out.printf("%-15s%-25s%-15s%-15s%-15s%-20s\n", "Mã NV", "Tên NV",
                "Mức lương", "Số ngày làm", "Thưởng", "Tổng lương");
        for (var emp : employeesList) {
            System.out.printf("%-15s%-25s%-15.2f%-15.2f%-15.2f%-20.2f\n", emp.getEmpId(),
                    emp.getFullNameString(), emp.getSalary(),
                    emp.getWorkingDay(), emp.getBonus(), emp.getTotalSalary());
        }
    }

    /**
     * Phương thức này dùng để ghi thông tin cả danh sách nhân viên
     * vào file. Chỉ ghi thông tin các nhân viên chưa xuất hiện trong file
     * Không bảo toàn dữ liệu trong file để update file.
     *
     * @param employeesList Danh sách nhân viên cần tìm
     * @param empFileName   FileName tên file cần ghi
     * @return true nếu ghi file thành công và false là ngược lại
     */
    public Boolean writeEmpToFile(ArrayList<Employee> employeesList, String empFileName) {
        try {
            PrintWriter printWriter = new PrintWriter(empFileName);
            var format = "dd/MM/yyyy";
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            for (var emp : employeesList) {
                if (emp instanceof Manager) {
                    printWriter.printf("%s-%s-%s-%s-%s-%s-%s-%s-%f-%f-%f-%f-%f-%s-%s\n",
                            emp.getId(), emp.getFullNameString(),
                            emp.getAddress(), dateFormat.format(emp.getDateOfBirth()),
                            emp.getEmail(), emp.getPhoneNumber(), emp.getEmpId(),
                            emp.getDuty(), emp.getSalary(), emp.getExperience(),
                            emp.getWorkingDay(), emp.getTotalSalary(), emp.getBonus(),
                            dateFormat.format(((Manager) emp).getStartDate()),
                            dateFormat.format(((Manager) emp).getEndDate()));
                } else {
                    printWriter.printf("%s-%s-%s-%s-%s-%s-%s-%s-%f-%f-%f-%f-%f\n",
                            emp.getId(), emp.getFullNameString(),
                            emp.getAddress(), dateFormat.format(emp.getDateOfBirth()),
                            emp.getEmail(), emp.getPhoneNumber(), emp.getEmpId(),
                            emp.getDuty(), emp.getSalary(), emp.getExperience(),
                            emp.getWorkingDay(), emp.getTotalSalary(), emp.getBonus());
                }
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Phương thức để đọc dữ liệu nhân viên từ file
     * @param empFileName là tên file cần đọc
     * @return danh sách sinh viên đọc được hoặc rỗng nếu file rỗng
     */
    public ArrayList<Employee> readFileName(String empFileName) {
        ArrayList<Employee> list = new ArrayList<>();
        var file = new File(empFileName);
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            file.createNewFile();
            var input = new Scanner(file);
            while (input.hasNextLine()) {
                var line = input.nextLine().split("-");
                Employee employee = ceartEmpData(line, dateFormat);
                if (employee != null) {
                    list.add(employee);
                }
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Phương thức tạo thông tin đối tượng nhân viên hoặc giám đốc
     * @param line Dữ liệu đã tách
     * @param dateFormat Định dạng thời gian
     * @return Đối tượng được tham chiếu đến bởi kiểu Employee
     */
    private Employee ceartEmpData(String[] line, SimpleDateFormat dateFormat) {
        var id = line[0];
        var fullName = line[1];
        var address = line[2];
        Date dob = null;
        try {
            dob = dateFormat.parse(line[3]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        var email = line[4];
        var phoneNum = line[5];
        var empId = line[6];
        var duty = line[7];
        var salary = Float.parseFloat(line[8]);
        var exp = Float.parseFloat(line[9]);
        var workingDay = Float.parseFloat(line[10]);
        var totalSalary = Float.parseFloat(line[11]);
        var bonus = Float.parseFloat(line[12]);
        Date start = null;
        Date end = null;
        if (line.length > 13) {
            try {
                start = dateFormat.parse(line[13]);
                end = dateFormat.parse(line[14]);
                return new Manager(id, fullName, address, dob,
                        email, phoneNum, empId, duty,
                        salary, exp, workingDay,
                        totalSalary, bonus, start, end);
            } catch (ParseException | worKingDayException | nameException e) {
                e.printStackTrace();
            }
        } else {
            try {
                return new Employee(id, fullName, address, dob,
                        email, phoneNum, empId, duty,
                        salary, exp, workingDay, totalSalary, bonus);
            } catch (worKingDayException | nameException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
