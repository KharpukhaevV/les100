import exceptions.AccountlsLockedException;
import exceptions.IncorrectPinException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinValidator {

    protected boolean validate(User user) throws InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        boolean success = false;
        while (!success) {
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
                success = true;
                return success;
            } catch (IncorrectPinException e) {
                System.out.println("Неверынй PIN");
            } catch (IOException | NumberFormatException e) {
                System.out.println("Некоректный PIN");
            } catch (AccountlsLockedException e) {
                System.out.println("Превышено количество ошибок. Блокировка 5 секунд");
                Thread.sleep(5000);
            }
        }

        return success;
    }
}