import java.io.IOException;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {

        String host = "localhost";
        int puerto = 5000;

        try {
            // El cliente intenta conectarse al servidor
            Socket socket = new Socket(host, puerto);
            System.out.println("Conectado al servidor");

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
