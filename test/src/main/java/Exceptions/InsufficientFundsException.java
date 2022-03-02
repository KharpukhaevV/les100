package Exceptions;

public class InsufficientFundsException extends Exception{
    public InsufficientFundsException() {
        super("Ошибка. Недостаточно средств для выполнения операции.");
    }
}
