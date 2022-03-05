public class Main {
    public static void main(String[] args) throws InterruptedException {
        User user1 = new User("Ivanov", "Ivan", "Ivanovich", "123_456_678", 123L, 111);
        User user2 = new User("Ivanov", "Ivan", "Ivanovich", "123_285_678", 100L, 112);
        TerminalImpl terminal = new TerminalImpl();

        terminal.transfer(user1, user2, 100L);
    }
}
