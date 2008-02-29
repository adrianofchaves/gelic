/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adriano
 */
public class CriptMD5Test {

    public CriptMD5Test() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of digest method, of class CriptMD5.
     */
    @Test
    public void digest() throws Exception {
        System.out.println("digest");
        String senha = "ADMIN";
        String senhaCript = CriptMD5.digest(senha);
        
        String senha1 = "admin";
        String senha1Cript = CriptMD5.digest(senha1);
        
        assertEquals( senhaCript, senha1Cript);
        
        byte[] input = "ADMIN".getBytes();
        byte[] expResult = "ADMIN".getBytes();
        byte[] result = CriptMD5.digest(input);
        assertEquals(expResult, result);        
    }

    /**
     * Test of byteArrayToHexString method, of class CriptMD5.
     */
    @Test
    public void byteArrayToHexString() {
        System.out.println("byteArrayToHexString");
        byte[] b = "ADMIN".getBytes();
        String expResult = "ADMIN";
        String result = CriptMD5.byteArrayToHexString(b);
        assertEquals(expResult, result);
    }

    /**
     * Test of hexStringToByteArray method, of class CriptMD5.
     */
    @Test
    public void hexStringToByteArray() {
        System.out.println("hexStringToByteArray");
        String hexa = "FF";
        int[] expResult = {255,255};
        byte[] result = CriptMD5.hexStringToByteArray(hexa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}