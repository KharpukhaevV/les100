import exceptions.FrodMonitorException;

public class FrodMonitor {
    protected boolean monitoring(long sum) throws FrodMonitorException {
        if (sum > 1000) {
            throw new FrodMonitorException();
        }
        return true;
    }
}
