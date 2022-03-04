import exceptions.FrodMonitorException;
import exceptions.ValidationFailedException;

public class FrodMonitor {
    protected void monitoring(PinValidator validator, User user, String recipient, long sum) throws FrodMonitorException, ValidationFailedException {
        if (!validator.isSuccess()) throw new ValidationFailedException("Ошибка валидации");
        if (sum > 50000) throw new FrodMonitorException();
    }
}
