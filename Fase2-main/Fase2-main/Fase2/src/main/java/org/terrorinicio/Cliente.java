package org.terrorinicio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {

        String host = "localhost";
        int puerto = 5000;

        try {
            Socket socket = new Socket(host, puerto);

            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            Scanner teclado = new Scanner(System.in);
            boolean salir = false;

            while (!salir) {
                System.out.print("Mensaje: ");
                String mensaje = teclado.nextLine();

                salida.writeUTF(mensaje);
                System.out.println(entrada.readUTF());

                if (mensaje.equalsIgnoreCase("FIN")) {
                    salir = true;
                }
            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
