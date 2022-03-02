package Exceptions;

public class ServerConnectionLostException extends Exception{
    public ServerConnectionLostException() {
        super("Не удалось установить соединение с сервером.");
    }
}
