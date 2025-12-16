package org.terrorinicio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

// Esta clase gestiona UN cliente
// Cada cliente se ejecuta en su propio hilo
public class GestorCliente implements Runnable {

    private Socket socket;

    public GestorCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            boolean salir = false;

            while (!salir) {
                String mensaje = entrada.readUTF();
                System.out.println("Cliente " + socket.getPort() + ": " + mensaje);

                salida.writeUTF("Servidor responde: " + mensaje);

                if (mensaje.equalsIgnoreCase("FIN")) {
                    salir = true;
                }
            }

            socket.close();
            System.out.println("Cliente desconectado");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
