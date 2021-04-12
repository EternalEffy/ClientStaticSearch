import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Sender {
    private static Socket client;
    private static DataInputStream inStream;
    private static DataOutputStream outStream;

    public void start(int port) {
        try {
            client = new Socket("localhost", port);
            inStream = new DataInputStream(client.getInputStream());
            outStream = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendRequest(String request){
        try {
            outStream.writeUTF(request);
            outStream.flush();
            System.out.println(inStream.readUTF());
            close();
        } catch (IOException e) {
            System.out.println("Server was stopped");
        }
    }

    public void close(){
        try {
            client.close();
            inStream.close();
            outStream.close();
        } catch (IOException e) {
            System.out.println("Client close");
        }
    }

}
