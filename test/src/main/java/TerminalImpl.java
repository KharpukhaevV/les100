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
            System.out.println("123123123");
        }
        catch (ValidationFailedException e) {
            System.out.println("Не удалось авторизироваться");
        }
    }
}
