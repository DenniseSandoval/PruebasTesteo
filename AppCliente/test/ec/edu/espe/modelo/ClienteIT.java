/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 *
 * @author Dennise
 */
public class ClienteIT {
    
    public ClienteIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of realizarConexion method, of class Cliente.
     */
    @Test
    public void testRealizarConexion() {
        System.out.println("realizarConexion");
        String ip = "localhost";
        int puerto = 5050;
        Cliente instance = new Cliente();
        instance.realizarConexion(ip, puerto);        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of flujoDatos method, of class Cliente.
     */
    @Test
    public void testFlujoDatos() {
        System.out.println("flujoDatos");
        Cliente instance = new Cliente();
        instance.realizarConexion("localhost", 5050);
        instance.flujoDatos();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of enviar method, of class Cliente.
     */
    @Test
    public void testEnviar() {
        System.out.println("enviar");
        String s = "Hi";
        Cliente instance = new Cliente();
        instance.realizarConexion("localhost", 5050);
        instance.flujoDatos();        
        instance.enviar(s);
        // TODO review the generated test code and remove the default call to fail.
       //fail("The test case is a prototype.");
    }

    /**
     * Test of recibirDatos method, of class Cliente.
     */
    @Test
    public void testRecibirDatos() throws IOException {
        System.out.println("recibirDatos");  
        String s = "Hi";
        Cliente instance = new Cliente();       
        DataOutputStream bufferDeSalida= null;
        instance.realizarConexion("localhost", 5050);
        instance.flujoDatos(); 
//        instance.recibirDatos();
//        instance.cerrarConexion();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarTexto method, of class Cliente.
     */
    @Test
    public void testMostrarTexto() {
        System.out.println("mostrarTexto");
        String s = "Hi";
        Cliente.mostrarTexto(s);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of escribirDatos method, of class Cliente.
     */
    @Test
    public void testEscribirDatos() {
        System.out.println("escribirDatos");
        String ip = "localhost";
        int puerto = 5050;
        Cliente instance = new Cliente();
        Scanner teclado = new Scanner(System.in);
        instance.ejecutarConexion(ip, puerto);      
        //instance.escribirdatos();
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cerrarConexion method, of class Cliente.
     */
    /*@Test
    public void testCerrarConexion() {
        System.out.println("cerrarConexion");
        Cliente instance = new Cliente();
        instance.cerrarConexion();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ejecutarConexion method, of class Cliente.
     */
    @Test
    public void testEjecutarConexion() {
        System.out.println("ejecutarConexion");
        String ip = "localhost";
        int puerto = 5050;
        Cliente instance = new Cliente();
        instance.ejecutarConexion(ip, puerto);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    /**
//     * Test of main method, of class Cliente.
//     */
//    @Test
//    public void testMain() throws Exception {
//        System.out.println("main");        
//        String[] args =null;        
//        Cliente.main(args);
//        Scanner sc= new Scanner(System.in);
//        String ip="localhost";
//        String puerto ="5050";
//        
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
    
}
