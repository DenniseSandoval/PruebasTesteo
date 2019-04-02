/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Labs-DECC
 */
public class Servidor {

    private Socket socket;
    private ServerSocket serverSocket;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    Scanner escaner = new Scanner(System.in);
    final String COMANDO_TERMINACION = "salir()";

    public void realizarConexion(int puerto) {
        try {
            serverSocket = new ServerSocket(puerto);
            mostrarTexto("Esperando conexion entrante del puerto" + String.valueOf(puerto) + "...");
            socket = serverSocket.accept();//Accept comienza el socket y espera una conexión desde un cliente
            mostrarTexto("Conexion establecida con " + socket.getInetAddress() + "...");
        } catch (IOException e) {
            mostrarTexto("Error al realizar la Conexion" + e.getMessage());
            System.exit(0);
        }
    }

    public void flujoDatos() {
        try {
            bufferDeEntrada = new DataInputStream(socket.getInputStream());
            bufferDeSalida = new DataOutputStream(socket.getOutputStream());
            //Se obtiene el flujo(datos) de salida del cliente para enviarle mensajes
            bufferDeSalida.flush();
        } catch (IOException ex) {
            mostrarTexto("Error al realizar apertura de flujo" + ex.getMessage());
        }
    }
/*public void contarCaracteres(String cadena){

    char [] Arraycadena ;
    char caracter;
    Arraycadena=cadena.toCharArray();
    boolean[] car = new boolean[Character.MAX_VALUE];
    int[] contador = new int[Character.MAX_VALUE];
    for(int i =0;i<Arraycadena.length;i++){
        caracter = Arraycadena[i];            
        if(Arraycadena[i]==caracter){
            contador[caracter]++;
        }
        car[caracter] = true;
    }//Fin Para
    for(int i = 0; i < car.length; i++){
        if(car[i])
            System.out.println("  "+(char) i +"="+contador[i]+".");
    }
}*/
    public void recibirDatos() {
        String st = "";
        try {
            do {
                st = (String) bufferDeEntrada.readUTF();
                //Se lee mensaje de cliente usando su flujo de entrada
                mostrarTexto("\n Cliente ==> " + st);
                System.out.print("\n[Usted] -> ");
                //contarCaracteres(st);
                enviar("recibido");
            } while (!st.equals(COMANDO_TERMINACION));
            
        } catch (IOException e) {
            cerrarConexion();
        }
        
    }

    public void enviar(String s) {
        try {
            bufferDeSalida.writeUTF("Respuesta: "+s);
            //Se le envía un mensaje al cliente usando su flujo de salida
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("Error al realizar apertura de flujo" + e.getMessage());
        }
    }

    public static void mostrarTexto(String s) {
        System.out.print(s);
    }

    public void escribirDatos() {
        while (true) {
            System.out.print("[Usted] -> ");
            enviar(escaner.nextLine());
        }
    }

    public void cerrarConexion() {
        try {
            bufferDeEntrada.close();
            bufferDeSalida.close();
        } catch (IOException e) {
            mostrarTexto("Error en cerrar Conexion() " + e.getMessage());
        } finally {
            mostrarTexto("Conversacion Finalizada....");
            System.exit(0);
        }
    }

    public void ejecutarConexion(int puerto) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        realizarConexion(puerto);
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
        Servidor s = new Servidor();
        Scanner sc = new Scanner(System.in);
        
        mostrarTexto("Ingresa el puerto [5050 por defecto]: ");
        String puerto = sc.nextLine();
        if(puerto.length() <= 0){
            puerto = "5050";
        }
        s.ejecutarConexion(Integer.parseInt(puerto));
        s.escribirDatos();
    }
}
