import exceptions.AccountlsLockedException;

public interface Terminal {
    void Transfer(User user, String recipient, long sum) throws InterruptedException, AccountlsLockedException;
}
