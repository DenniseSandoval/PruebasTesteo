/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Labs-DECC
 */
public class Cliente {

    private Socket socket;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    Scanner teclado = new Scanner(System.in);
    final String COMANDO_TERMINACION = "salir()";

    public void realizarConexion(String ip, int puerto) {
        try {
            socket = new Socket(ip, puerto);
            mostrarTexto("Conectando a: " + socket.getInetAddress().getHostAddress() + "...");
        } catch (IOException e) {
            mostrarTexto("Error al realizar la Conexion" + e.getMessage());
            System.exit(0);
        }
    }

    public void flujoDatos() {
        try {
            bufferDeEntrada = new DataInputStream(socket.getInputStream());
            bufferDeSalida = new DataOutputStream(socket.getOutputStream());
            bufferDeSalida.flush();
        } catch (IOException ex) {
            mostrarTexto("Error al realizar apertura de flujo" + ex.getMessage());
        }
    }

    public void enviar(String s) {
        try {
            bufferDeSalida.writeUTF(s);
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("Error al realizar apertura de flujo" + e.getMessage());
        }
    }

    public void recibirDatos() {
        String st = "";
        try {
            do {
                st = (String) bufferDeEntrada.readUTF();
                mostrarTexto("\n Servidor ==> " + st);
                System.out.print("\n[Usted] -> ");
            } while (!st.equals(COMANDO_TERMINACION));
        } catch (IOException e) {
            cerrarConexion();
        }
    }

    public static void mostrarTexto(String s) {
        System.out.print(s);
    }

    public void escribirDatos() {
        String entrada = "";
        while (true) {
            System.out.print("[Usted] -> ");
            enviar(teclado.nextLine());
            if (entrada.length() == 0) {
                enviar(entrada);
            }
        }
    }

    public void cerrarConexion() {
        try {
            bufferDeEntrada.close();
            bufferDeSalida.close();
            socket.close();
            mostrarTexto("Conversacion Finalizada ...");
        } catch (IOException e) {
            mostrarTexto("Error en cerrar Conexion() " + e.getMessage());
        } finally {
            System.exit(0);
        }
    }

    public void ejecutarConexion(String ip, int puerto) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        realizarConexion(ip, puerto);
                        flujoDatos();
                        recibirDatos();
                    } finally {
                        cerrarConexion();
                    }
                }
            }
        });
        hilo.start();
    }

    public static void main(String[] args) throws IOException {
        Cliente s = new Cliente();
        Scanner sc = new Scanner(System.in);
        mostrarTexto("Ingresa IP [localhost por defecto]: ");
        String ip = sc.nextLine();
        if (ip.length() <= 0) {
            ip = "localhost";
        }
        mostrarTexto("Ingresa el puerto [5050 por defecto]: ");
        String puerto = sc.nextLine();
        if (puerto.length() <= 0) {
            puerto = "5050";
        }
        s.ejecutarConexion(ip, Integer.parseInt(puerto));
        s.escribirDatos();
    }
}
