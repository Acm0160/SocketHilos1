package org.terrorinicio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        int puerto = 5000;

        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Servidor multihilo iniciado");

            // El servidor nunca se cierra
            while (true) {
                Socket socketCliente = servidor.accept();
                System.out.println("Nuevo cliente conectado");

                // Se crea un gestor para ese cliente
                GestorCliente gestor = new GestorCliente(socketCliente);

                // Se lanza un hilo nuevo
                Thread hilo = new Thread(gestor);
                hilo.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
