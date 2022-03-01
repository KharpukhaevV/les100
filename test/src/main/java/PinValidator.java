import Exceptions.AccountlsLockedException;
import Exceptions.IncorrectPinException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinValidator {
    public static boolean validate(User user) throws AccountlsLockedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean result = false;
        int count = 0;
        while (!result) {
            try {
                if (count == 3) {
                    count = 0;
                    throw new AccountlsLockedException();
                }
                System.out.println("Введите PIN код: ");
                int pin = Integer.parseInt(reader.readLine());
                if (user.getPin() != pin) {
                    count++;
                    throw new IncorrectPinException();
                }
                result = true;
            }
            catch (IncorrectPinException e) {
                System.out.println("Неверынй PIN");
            }
            catch (IOException | NumberFormatException e) {
                System.out.println("Некоректный PIN");
            }

        }
        return result;
    }
}
