import exceptions.*;

public class TerminalImpl implements Terminal {
    private final PinValidator pinValidator = new PinValidator();
    private final TerminalServer terminalServer = new TerminalServer();
    private final FrodMonitor frodMonitor = new FrodMonitor();

    @Override
    public void transfer(User user, User recipient, long sum) throws InterruptedException {


        boolean success = pinValidator.validate(user);
        try {
            if (!success) throw new ValidationFailedException("Ошибка валидации.");
            terminalServer.serverOperation(user, recipient, sum);
            frodMonitor.monitoring(user, recipient, sum);
            if ((sum % 100) == 0) {
                System.out.println("Перевод выполнен успешно.");
            } else throw new IncorrectSumTransfer();
        } catch (InsufficientFundsException | ServerConnectionLostException | IncorrectRecipientAccountNumber | IncorrectSumTransfer | FrodMonitorException | ValidationFailedException e) {
            e.printStackTrace();
        }
    }
}
