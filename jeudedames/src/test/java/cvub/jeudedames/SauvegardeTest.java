/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cvub.jeudedames;

import java.io.File;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author utaab
 */
public class SauvegardeTest {
    
    public SauvegardeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of createDirIfNotExists method, of class Sauvegarde.
     */
    @Test
    public void testCreateDirIfNotExists() {
        System.out.println("createDirIfNotExists");
        Sauvegarde instance = new Sauvegarde("test_dir");
        instance.createDirIfNotExists();
        File dir = new File("test_dir");
        assertTrue(dir.exists());
        dir.delete();
    }

    /**
     * Test of pionToString method, of class Sauvegarde.
     */
    @Test
    public void testPionToString() {
        System.out.println("pionToString");
        Pion p = new Pion(new Case(0,0), true);
        Sauvegarde instance = new Sauvegarde();
        String expResult = "D00 ";
        String result = instance.pionToString(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of stringToPion method, of class Sauvegarde.
     */
    @Test
    public void testStringToPion() {
        System.out.println("stringToPion");
        String s = "D00 ";
        Sauvegarde instance = new Sauvegarde();
        ArrayList<Pion> result = instance.stringToPion(s);
        Pion p = result.get(0);
        assertEquals(true, p.isDame());
        assertEquals(0, p.getC().getX());
        assertEquals(0, p.getC().getY());
    }

    /**
     * Test of save method, of class Sauvegarde.
     */
    @Test
    public void testSaveAndLoad() {
        System.out.println("save");
        Jeu jeu = new Jeu();
        String file_name = "test.dame";
        Sauvegarde instance = new Sauvegarde();
        
        boolean expResultJ1 = true;
        boolean expResultJ2 = true;
        
        jeu.getJ1().add(new Pion(new Case(0,0), true));
        jeu.getJ2().add(new Pion(new Case(0,0), true));
        instance.save(jeu, file_name);
        jeu.getJ1().get(0).setDame(false);
        jeu.getJ2().get(0).setDame(false);
        jeu = instance.load(file_name);
        
        boolean resultJ1 = jeu.getJ1().get(0).isDame();
        boolean resultJ2 = jeu.getJ1().get(0).isDame();
        assertEquals(expResultJ1, resultJ1);
        assertEquals(expResultJ1, resultJ2);
        
        File file = new File(file_name);
        file.delete();
    }

}
