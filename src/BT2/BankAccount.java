package BT2;

public class BankAccount {
    private String cardNumber;
    private String accountNumber;
    private String owner;
    private long balance;

    public BankAccount() {
    }

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankAccount(String cardNumber, String accountNumber,
                       String owner, long balance) {
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public long getBalance() {
        return balance;
    }

    // Phuong Thuc Nap Tien
    public void deposit(long amount) throws InvalidAmountException {
        if (amount > 0) {
            balance += amount;
            System.out.println("Giao Dich Nap Tien Vao Tai Khoan " + getAccountNumber() +
                    " Hoan Tat");
        } else {
            var smg = "So Tien Giao Dich Khong Hop Le" + amount;
            throw new InvalidAmountException(smg, amount);
        }
    }

    // Phuong Thuc rut Tien
    public void withdraw(long amount) throws InvalidAmountException {
        if (isValid(amount) && amount <= balance) {
            balance -= amount;
            System.out.println("Dut Tien Hoan Tat");
        } else {
            var smg = "So Tien Giao Dich Khong Hop le " + amount;
            throw new InvalidAmountException(smg, amount);
        }
    }

    public void transfer(BankAccount acc, long amount) throws InvalidAmountException {
        if (isValid(amount) && amount <= balance) {
            balance -= amount;
            acc.deposit(amount);
            System.out.println("Giao dich Chuyen Khoan Hoan Tat");
        } else {
            var smg = "So Tien Giao Dich Khong Hop Le " + amount;
            throw new InvalidAmountException(smg, amount);
        }
    }

    public void payBill(long amount) throws InvalidAmountException {
        if (isValid(amount) && amount <= balance) {
            balance -= amount;
            System.out.println("Thanh Toan Thanh Cong");
        } else {
            var smg = "So tien giao dich khong hop le " + amount;
            throw new InvalidAmountException(smg, amount);
        }
    }

    private boolean isValid(long amount) {
        return amount >= 0 && amount <= balance;
    }
}
