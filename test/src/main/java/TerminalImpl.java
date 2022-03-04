import exceptions.*;

public class TerminalImpl implements Terminal{
    private final PinValidator pinValidator = new PinValidator();
    private final TerminalServer terminalServer = new TerminalServer();
    private final FrodMonitor frodMonitor = new FrodMonitor();

    @Override
    public void Transfer(User user, String recipient, long sum) throws InterruptedException {

        pinValidator.validate(user);
        try {
            terminalServer.serverOperation(pinValidator, user, recipient, sum);
            frodMonitor.monitoring(pinValidator, user, recipient, sum);
            if ((sum % 100) == 0) {
                System.out.println("Перевод выполнен успешно.");
            }
            else throw new IncorrectSumTransfer();
        }
        catch (InsufficientFundsException | ServerConnectionLostException | IncorrectRecipientAccountNumber | IncorrectSumTransfer | FrodMonitorException | ValidationFailedException e) {
            e.printStackTrace();
        }
    }
}
