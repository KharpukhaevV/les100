package exceptions;

public class ValidationFailedException extends Exception {
    public ValidationFailedException() {
        super("Ошибка валидации.");
    }
}
