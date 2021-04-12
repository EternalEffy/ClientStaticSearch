public class Main {
    public static void main(String[] args) {
        Sender sender = new Sender();
        sender.start(4545);
        sender.sendRequest(Command.stop);
    }
}
