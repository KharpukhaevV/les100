import exceptions.AccountlsLockedException;

public interface Terminal {
    void transfer(User user, User recipient, long sum) throws InterruptedException, AccountlsLockedException;
}
