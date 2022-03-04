package exceptions;

public class IncorrectPinException extends Exception{
    public IncorrectPinException() {
        super("Неверный PIN.");
    }
}
