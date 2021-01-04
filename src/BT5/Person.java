package BT5;

import BT5.exercises.nameException;

import java.util.Date;

public class Person implements Comparable<Person> {
    private String id; // số chứng minh thư/căn cước
    private FullName fullName; // họ tên đầy đủ
    private String address; // địa chỉ
    private Date dateOfBirth; // ngày tháng năm sinh
    private String email; // email
    private String phoneNumber; // số điện thoại

    public Person() {
    }

    public Person(String id, String fullName,
                  String address, Date dateOfBirth,
                  String email, String phoneNumber) throws nameException {
        this.id = id;
        this.setFullName(fullName);
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Person o) {
        return id.compareTo(o.id);
    }


    public final String getId() {
        return id;
    }

    public final String getFullNameString() {
        return fullName.last + " " + fullName.first + " " + fullName.mid;
    }

    public void setFullName(String fullName) throws nameException {
        this.fullName = new FullName();
        if (fullName != null && fullName.length() > 0) {
            if (!checkFullName(fullName.toLowerCase())) {
                var smg = "Ho Ten Khong Hop Le " + fullName;
                throw new nameException(smg, fullName);
            }
            var words = fullName.split("\\s+");
            this.fullName.last = words[words.length - 1];
            this.fullName.first = words[0];
            this.fullName.mid = "";
            for (int i = 0; i < words.length - 1; i++) {
                this.fullName.mid = words[i] + " ";
            }
        }
    }

    private boolean checkFullName(String fullName) {
        String check = "0123456789+-*/=]}[{'\";:/?.>,<)(&^%$#@!~`\\|";
        for (int i = 0; i < fullName.length(); i++) {
            for (int j = 0; j < check.length(); j++) {
                if (fullName.charAt(i) == check.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final FullName getFullName() {
        return fullName;
    }

    public final String getAddress() {
        return address;
    }

    public final Date getDateOfBirth() {
        return dateOfBirth;
    }

    public final String getEmail() {
        return email;
    }

    public final String getPhoneNumber() {
        return phoneNumber;
    }

    public class FullName {
        private String first;
        private String last;
        private String mid;

        public FullName() {
        }

        public FullName(String first, String last, String mid) {
            this.first = first;
            this.last = last;
            this.mid = mid;
        }

        public final String getFirst() {
            return first;
        }

        public final String getLast() {
            return last;
        }

        public final String getMid() {
            return mid;
        }
    }
}
