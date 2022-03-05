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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!lastName.equals(user.lastName)) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (patronymic != null ? !patronymic.equals(user.patronymic) : user.patronymic != null) return false;
        return accountNumber.equals(user.accountNumber);
    }

    @Override
    public int hashCode() {
        int result = lastName.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + accountNumber.hashCode();
        return result;
    }

    public String getFIO() {
        return this.lastName + " " + this.firstName + " " + " " + this.patronymic;
    }
}