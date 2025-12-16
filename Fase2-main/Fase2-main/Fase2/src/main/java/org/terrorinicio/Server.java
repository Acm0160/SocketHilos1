package org.terrorinicio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        int puerto = 5000;

        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Servidor esperando cliente...");

            Socket socketCliente = servidor.accept();
            System.out.println("Cliente conectado");

            // Streams para enviar y recibir mensajes
            DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());
            DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());

            boolean salir = false;

            // Bucle de comunicación
            while (!salir) {
                String mensaje = entrada.readUTF();
                System.out.println("Cliente: " + mensaje);

                salida.writeUTF("Servidor recibe: " + mensaje);

                // Condición de salida
                if (mensaje.equalsIgnoreCase("FIN")) {
                    salir = true;
                }
            }

            socketCliente.close();
            servidor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
