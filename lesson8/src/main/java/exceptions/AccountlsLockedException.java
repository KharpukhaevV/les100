package exceptions;

public class AccountlsLockedException extends Exception {
    public AccountlsLockedException() {
        super("Превышено количество ошибок ввода PIN кода. Вы заблокированы на 5 секунд.");
    }
}
