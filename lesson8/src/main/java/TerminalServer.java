import exceptions.IncorrectRecipientAccountNumber;
import exceptions.InsufficientFundsException;
import exceptions.ServerConnectionLostException;
import exceptions.ValidationFailedException;

public class TerminalServer {
    protected boolean serverOperation(User user, User recipient, long sum, boolean connection) throws ServerConnectionLostException, IncorrectRecipientAccountNumber, InsufficientFundsException, ValidationFailedException {
        if (!connection) throw new ServerConnectionLostException();
        if (user.getAccountNumber().equals(recipient.getAccountNumber())) throw new IncorrectRecipientAccountNumber();
        if (user.getBalance() < sum) throw new InsufficientFundsException();
        return true;
    }
}
