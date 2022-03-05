package exceptions;

public class IncorrectSumTransfer extends Exception {
    public IncorrectSumTransfer() {
        super("Неккоректная сумма перевода. Сумма должна быть кратна 100.");
    }
}
