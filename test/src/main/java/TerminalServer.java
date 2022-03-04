import exceptions.IncorrectRecipientAccountNumber;
import exceptions.InsufficientFundsException;
import exceptions.ServerConnectionLostException;
import exceptions.ValidationFailedException;

public class TerminalServer {
    protected void serverOperation(PinValidator validator, User user, String recipient, long sum) throws ServerConnectionLostException, IncorrectRecipientAccountNumber, InsufficientFundsException, ValidationFailedException {
        if (!validator.isSuccess()) throw new ValidationFailedException("Ошибка валидации.");
        boolean serverConnection = true;
        if (!serverConnection) throw new ServerConnectionLostException();
        if (user.getAccountNumber().equals(recipient)) throw new IncorrectRecipientAccountNumber();
        if (user.getBalance() < sum) throw new InsufficientFundsException();
    }
}
