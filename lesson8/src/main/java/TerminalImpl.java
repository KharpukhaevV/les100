import exceptions.*;

import java.util.Scanner;

public class TerminalImpl implements Terminal {
    private final PinValidator pinValidator;
    private final TerminalServer terminalServer;
    private final FrodMonitor frodMonitor;

    public TerminalImpl() {
        pinValidator = new PinValidator();
        terminalServer = new TerminalServer();
        frodMonitor = new FrodMonitor();
    }

    @Override
    public boolean transfer(User user, User recipient, long sum) throws Exception {
        boolean success = false;
        int tryCount = 0;
        Scanner scanner = new Scanner(System.in);
        while (!success) {
            try {
                if (tryCount == 3) {
                    tryCount = 0;
                    throw new CapsuleAccountsLockedException();
                }
                success = pinValidator.validate(user, scanner);
            } catch (CapsuleAccountsLockedException e) {
                e.printStackTrace();
                Thread.sleep(5000);
            } catch (IncorrectPinException e) {
                tryCount++;
                e.printStackTrace();
            }
        }
        boolean transferSuccess = false;
        try {
            if (!success) {
                throw new ValidationFailedException();
            }
            terminalServer.serverOperation(user, recipient, sum, true);
            frodMonitor.monitoring(sum);
            if ((sum % 100) == 0) {
                transferSuccess = true;
            } else {
                throw new IncorrectSumTransfer();
            }

        }
        catch (FrodMonitorException | InsufficientFundsException | ServerConnectionLostException | IncorrectRecipientAccountNumber e) {
            e.printStackTrace();
        }
        return transferSuccess;
    }
}
