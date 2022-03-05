package exceptions;

public class FrodMonitorException extends Exception {
    public FrodMonitorException() {
        super("Попытка перевести подозретельную сумму, перевод заблокирован.");
    }
}
