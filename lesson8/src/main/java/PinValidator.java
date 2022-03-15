import exceptions.IncorrectPinException;

import java.util.Scanner;

public class PinValidator {

    protected boolean validate(User user, Scanner scanner) throws IncorrectPinException {
        System.out.println("Введите PIN код: ");
        int pin = scanner.nextInt();
        if (pin != user.getPin()) {
            throw new IncorrectPinException();
        }
        return true;
    }
}
