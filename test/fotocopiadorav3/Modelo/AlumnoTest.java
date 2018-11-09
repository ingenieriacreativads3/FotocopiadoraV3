/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;

import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tomas Contreras
 */
public class AlumnoTest {
    
    public AlumnoTest() {
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
     * Test of modificar method, of class Alumno.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        int legajoRecibido = 0;
        Persona personaRecibida = Persona.OBJETO_INVALIDO;
        Alumno instance = Alumno.nuevo(legajoRecibido, personaRecibida);
        Estado expResult = null;
        Estado result = instance.modificar(legajoRecibido, personaRecibida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrar method, of class Alumno.
     */
    @Test
    public void testBorrar() {
        System.out.println("borrar");
        Alumno instance = null;
        Estado expResult = null;
        Estado result = instance.borrar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getForId method, of class Alumno.
     */
    @Test
    public void testGetForId() {
        System.out.println("getForId");
        int idRecibido = 0;
        Alumno expResult = null;
        Alumno result = Alumno.getForId(idRecibido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardar method, of class Alumno.
     */
    @Test
    public void testGuardar() {
        System.out.println("guardar");
        Alumno instance = null;
        Estado expResult = null;
        Estado result = instance.guardar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInformacion method, of class Alumno.
     */
    @Test
    public void testGetInformacion() {
        System.out.println("getInformacion");
        Estado expResult = null;
        Estado result = Alumno.getInformacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nuevo method, of class Alumno.
     */
    @Test
    public void testNuevo() {
        System.out.println("nuevo");
        int legajoRecibido = 0;
        Persona personaRecibida = null;
        Alumno expResult = null;
        Alumno result = Alumno.nuevo(legajoRecibido, personaRecibida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaObjetos method, of class Alumno.
     */
    @Test
    public void testGetListaObjetos() {
        System.out.println("getListaObjetos");
        Set<Alumno> expResult = null;
        Set<Alumno> result = Alumno.getListaObjetos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Alumno.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Alumno instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLegajo method, of class Alumno.
     */
    @Test
    public void testGetLegajo() {
        System.out.println("getLegajo");
        Alumno instance = null;
        int expResult = 0;
        int result = instance.getLegajo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersona method, of class Alumno.
     */
    @Test
    public void testGetPersona() {
        System.out.println("getPersona");
        Alumno instance = null;
        Persona expResult = null;
        Persona result = instance.getPersona();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Alumno.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object objetoActual = null;
        Alumno instance = null;
        boolean expResult = false;
        boolean result = instance.equals(objetoActual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Alumno.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Alumno instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Alumno.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Alumno instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
