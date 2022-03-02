import Exceptions.FrodMonitorException;

public class FrodMonitor {
    public static boolean monitoring(User user, String recipient, long sum) {
        try {
            if (sum > 50000) throw new FrodMonitorException();
            return true;
        }
        catch (FrodMonitorException e) {
            e.printStackTrace();
            return false;
        }
    }
}
