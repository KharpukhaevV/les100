package Exceptions;

public class ValidationFailedException extends Exception{
    public ValidationFailedException() {
        super("Ошибка валидации.");
    }
}
