public class Main {
    public static void main(String[] args) {
        User user1 = new User("Ivanov", "Ivan", "Ivanovich", "123_456_678", 123L, 111);
        TerminalImpl terminal = new TerminalImpl();

        terminal.Transfer(user1, user1.getAccountNumber(), 123L);
    }
}
