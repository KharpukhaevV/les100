import exceptions.FrodMonitorException;
import exceptions.ValidationFailedException;

public class FrodMonitor {
    protected void monitoring(User user, User recipient, long sum) throws FrodMonitorException, ValidationFailedException {
        if (sum > 50000) throw new FrodMonitorException();
    }
}
