import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        int puerto = 5000;

        try {
            // Creamos el ServerSocket que queda a la espera de clientes
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado...");

            // accept() ES BLOQUEANTE:
            // el programa se queda aquí hasta que un Cliente se conecta
            Socket socketCliente = servidor.accept();
            System.out.println("Cliente conectado");

            // Simulamos que el servidor está ocupado
            // Mientras duerme, NO puede aceptar a otros clientes
            Thread.sleep(15000);

            System.out.println("Servidor vuelve a estar disponible");

            socketCliente.close();
            servidor.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
