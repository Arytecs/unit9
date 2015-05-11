/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit9;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Araceli Teruel
 */
public class CadenaAlumnoTest {
    
    public CadenaAlumnoTest() {
    }

    /**
     * Test of sonIguales method, of class CadenaAlumno.
     */
    @Test
    public void testSonIguales() {
        boolean igualesDevuelta=CadenaAlumno.sonIguales("entornos", "ento");
        boolean real="entornos".equals("ento");
        assertEquals(real,igualesDevuelta);
        igualesDevuelta=CadenaAlumno.sonIguales("ento", "entornos");
        real="ento".equals("entornos");
        assertEquals(real,igualesDevuelta);
        igualesDevuelta=CadenaAlumno.sonIguales("entornos", "sonrotne");
        real="entornos".equals("sonrotne");
        assertEquals(real,igualesDevuelta);
        igualesDevuelta=CadenaAlumno.sonIguales("entornos", "entornos");
        real="entornos".equals("entornos");
        assertEquals(real,igualesDevuelta);
    }

    /**
     * Test of esMayor method, of class CadenaAlumno.
     */
    @Test
    public void testEsMayor() {
        boolean devuelta=CadenaAlumno.esMayor("entornos", "ento");
        boolean real="entornos".compareTo("ento")>0?true:false;
        assertEquals(real,devuelta);
        devuelta=CadenaAlumno.esMayor("ento", "entornos");
        real="ento".compareTo("entornos")>0?true:false;
        assertEquals(real,devuelta);
        devuelta=CadenaAlumno.esMayor("entornos", "sonrotne");
        real="entornos".compareTo("sonrotne")>0?true:false;
        assertEquals(real,devuelta);
        devuelta=CadenaAlumno.esMayor("entornos", "entornos");
        real="entornos".compareTo("entornos")>0?true:false;
        assertEquals(real,devuelta);
    }

    /**
     * Test of esMenor method, of class CadenaAlumno.
     */
    @Test
    public void testEsMenor() {
        boolean devuelta=CadenaAlumno.esMenor("entornos", "ento");
        boolean real="entornos".compareTo("ento")<0?true:false;
        assertEquals(real,devuelta);
        devuelta=CadenaAlumno.esMenor("ento", "entornos");
        real="ento".compareTo("entornos")<0?true:false;
        assertEquals(real,devuelta);
        devuelta=CadenaAlumno.esMenor("entornos", "sonrotne");
        real="entornos".compareTo("sonrotne")<0?true:false;
        assertEquals(real,devuelta);
        devuelta=CadenaAlumno.esMenor("entornos", "entornos");
        real="entornos".compareTo("entornos")<0?true:false;
        assertEquals(real,devuelta);
    }

    /**
     * Test of comparaIgnorandoMayusculas method, of class CadenaAlumno.
     */
    @Test
    public void testComparaIgnorandoMayusculas() {
        boolean igualesDevuelta=CadenaAlumno.comparaIgnorandoMayusculas("entornos", "ento");
        boolean real="entornos".equalsIgnoreCase("ento");
        assertEquals(real,igualesDevuelta);
        igualesDevuelta=CadenaAlumno.comparaIgnorandoMayusculas("ento", "entornos");
        real="ento".equalsIgnoreCase("entornos");
        assertEquals(real,igualesDevuelta);
        igualesDevuelta=CadenaAlumno.comparaIgnorandoMayusculas("entornos", "sonrotne");
        real="entornos".equalsIgnoreCase("sonrotne");
        assertEquals(real,igualesDevuelta);
        igualesDevuelta=CadenaAlumno.comparaIgnorandoMayusculas("entornos", "entornos");
        real="entornos".equalsIgnoreCase("entornos");
        assertEquals(real,igualesDevuelta);
    }

    /**
     * Test of reemplazaTodos method, of class CadenaAlumno.
     */
    @Test
    public void testReemplazaTodos() {
        String igualesDevuelta=CadenaAlumno.reemplazaTodos("entornos", "ento","a");
        String real="entornos".replaceAll("ento","a");
        assertEquals(real,igualesDevuelta);
    }

    /**
     * Test of reemplazaPrimero method, of class CadenaAlumno.
     */
    @Test
    public void testReemplazaPrimero() {
        String igualesDevuelta=CadenaAlumno.reemplazaPrimero("entornos", "ento","a");
        String real="entornos".replaceFirst("ento","a");
        assertEquals(real,igualesDevuelta);
        igualesDevuelta=CadenaAlumno.reemplazaPrimero("entornos", "n", "a");
        real="entornos".replaceFirst("n", "a");
        assertEquals(real,igualesDevuelta);
    }
    
    /**
     * Test of quitaEspacios method, of class CadenaAlumno.
     */
    @Test
    public void testQuitaEspacios() {
        String devuelto=CadenaAlumno.quitaEspacios("   Hola");
        String real="   Hola".trim();
        assertEquals(real,devuelto);
    }

    /**
     * Test of convertirMayusculas method, of class CadenaAlumno.
     */
    @Test
    public void testConvertirMayusculas() {
        String devuelto=CadenaAlumno.convertirMayusculas("Hola");
        String real="Hola".toUpperCase();
        assertEquals(real,devuelto);
    }

    /**
     * Test of convertirMinusculas method, of class CadenaAlumno.
     */
    @Test
    public void testConvertirMinusculas() {
        String devuelto=CadenaAlumno.convertirMinusculas("HOLa");
        String real="HOLa".toLowerCase();
        assertEquals(real,devuelto);
    }

    /**
     * Test of longitudCadena method, of class CadenaAlumno.
     */
    @Test
    public void testLongitudCadena() {
        long devuelto=CadenaAlumno.longitudCadena("Hola que tal");
        long real="Hola que tal".length();
        assertEquals(real,devuelto);
    }

    /**
     * Test of empiezaCon method, of class CadenaAlumno.
     */
    @Test
    public void testEmpiezaCon() {
        boolean devuelto=CadenaAlumno.empiezaCon("Hola", "Ho");
        boolean real="Hola".startsWith("Ho");
        assertEquals(real,devuelto);
    }

    /**
     * Test of acabaEn method, of class CadenaAlumno.
     */
    @Test
    public void testAcabaEn() {
        boolean devuelto=CadenaAlumno.acabaEn("Hola", "la");
        boolean real="Hola".endsWith("la");
        assertEquals(real,devuelto);
        
    }

    /**
     * Test of posicionPrimeraCadena method, of class CadenaAlumno.
     */
    @Test
    public void testPosicionPrimeraCadena() {
        long devuelto=CadenaAlumno.posicionPrimeraCadena("Entornos", "no");
        long real="Entornos".indexOf("no");
        assertEquals(real,devuelto);
    }

    /**
     * Test of extraerSubstring method, of class CadenaAlumno.
     */
    @Test(expected=StringIndexOutOfBoundsException.class)
    public void testExtraerSubstring_String_int() {
        String devuelto=CadenaAlumno.extraerSubstring("Entornos", 10);
        String real="Entornos".substring(10);
        assertEquals(real,devuelto);
    }

    /**
     * Test of extraerSubstring method, of class CadenaAlumno.
     */
    @Test
    public void testExtraerSubstring_3args() {
        String devuelto=CadenaAlumno.extraerSubstring("Entornos", 2,5);
        String real="Entornos".substring(2,5);
        assertEquals(real,devuelto);
    }

    /**
     * Test of concatenaCadenas method, of class CadenaAlumno.
     */
    @Test
    public void testConcatenaCadenas() {
        String devuelto=CadenaAlumno.concatenaCadenas("Hola", " Estoy bien");
        String real="Hola".concat(" Estoy bien");
        assertEquals(real,devuelto);
    }
    
}
