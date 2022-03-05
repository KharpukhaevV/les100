package exceptions;

public class IncorrectRecipientAccountNumber extends Exception {
    public IncorrectRecipientAccountNumber() {
        super("Счета получателя и отправителя одинаковые");
    }
}
