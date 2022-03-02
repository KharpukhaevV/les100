import Exceptions.IncorrectRecipientAccountNumber;
import Exceptions.InsufficientFundsException;
import Exceptions.ServerConnectionLostException;

public class TerminalServer {
    public static boolean serverOperation(User user, String recipient, long sum) {
        boolean serverConnection = true;
        try {
            if (!serverConnection) throw new ServerConnectionLostException();
            if (user.getAccountNumber().equals(recipient)) throw new IncorrectRecipientAccountNumber();
            if (user.getBalance() < sum) throw new InsufficientFundsException();
            return true;
        } catch (IncorrectRecipientAccountNumber | InsufficientFundsException | ServerConnectionLostException e) {
            e.printStackTrace();
            return false;
        }
    }
}
