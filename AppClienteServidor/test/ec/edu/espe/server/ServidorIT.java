/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.server;

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
public class ServidorIT {
    
    public ServidorIT() {
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
     * Test of realizarConexion method, of class Servidor.
     */
    @Test
    public void testRealizarConexion() {
        System.out.println("realizarConexion");
        int puerto = 0;
        Servidor instance = new Servidor();
        instance.realizarConexion(puerto);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of flujoDatos method, of class Servidor.
     */
    @Test
    public void testFlujoDatos() {
        System.out.println("flujoDatos");
        Servidor instance = new Servidor();
        instance.flujoDatos();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of recibirDatos method, of class Servidor.
     */
    @Test
    public void testRecibirDatos() {
        System.out.println("recibirDatos");
        Servidor instance = new Servidor();
        instance.recibirDatos();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of enviar method, of class Servidor.
     */
    @Test
    public void testEnviar() {
        System.out.println("enviar");
        String s = "Hola mundo";
        Servidor instance = new Servidor();
        instance.enviar(s);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarTexto method, of class Servidor.
     */
    @Test
    public void testMostrarTexto() {
        System.out.println("mostrarTexto");
        String s = "Hola mundo";
        Servidor.mostrarTexto(s);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of escribirDatos method, of class Servidor.
     */
    @Test
    public void testEscribirDatos() {
        System.out.println("escribirDatos");
        Servidor instance = new Servidor();
        instance.escribirDatos();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cerrarConexion method, of class Servidor.
     */
    /*@Test
    public void testCerrarConexion() {
        System.out.println("cerrarConexion");
        Servidor instance = new Servidor();
        instance.cerrarConexion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ejecutarConexion method, of class Servidor.
     */
    @Test
    public void testEjecutarConexion() {
        System.out.println("ejecutarConexion");
        int puerto = 0;
        Servidor instance = new Servidor();
        instance.ejecutarConexion(puerto);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Servidor.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Servidor.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
