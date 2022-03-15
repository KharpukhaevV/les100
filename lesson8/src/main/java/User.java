public class User {
    private String lastName;
    private String firstName;
    private String patronymic;
    private String accountNumber;
    private long balance;
    private int pin;

    public User(String lastName, String firstName, String patronymic, String accountNumber, long balance, int pin) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

}