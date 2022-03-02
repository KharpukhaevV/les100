import Exceptions.AccountlsLockedException;
import Exceptions.ValidationFailedException;

public class TerminalImpl implements Terminal{

    @Override
    public void Transfer(User user, String recipient, long sum) {
        boolean validate = false;
        try {
            validate = PinValidator.validate(user);
        }
        catch (AccountlsLockedException e) {
            System.out.println("Превышено количество ошибок");
        }
        try {
            if (!validate) throw new ValidationFailedException();
            boolean frodMonitor = FrodMonitor.monitoring(user, recipient, sum);
            boolean terminalServer = TerminalServer.serverOperation(user, recipient, sum);
            if (frodMonitor && terminalServer) {
                System.out.println("Перевод выполнен успешно.");
            }
        }
        catch (ValidationFailedException e) {
            System.out.println("Не удалось авторизироваться");
        }
    }
}
