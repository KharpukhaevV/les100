import exceptions.IncorrectRecipientAccountNumber;
import exceptions.InsufficientFundsException;
import exceptions.ServerConnectionLostException;
import exceptions.ValidationFailedException;

public class TerminalServer {
    protected void serverOperation(User user, User recipient, long sum) throws ServerConnectionLostException, IncorrectRecipientAccountNumber, InsufficientFundsException, ValidationFailedException {
        boolean serverConnection = true;
        if (!serverConnection) throw new ServerConnectionLostException();
        if (user.getAccountNumber().equals(recipient.getAccountNumber())) throw new IncorrectRecipientAccountNumber();
        if (user.getBalance() < sum) throw new InsufficientFundsException();
    }
}
