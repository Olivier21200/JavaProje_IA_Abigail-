/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.algorithmes;

import ia.base.metier.TypeMouvement;
import static ia.base.metier.TypeMouvement.*;
import ia.base.metier.carte.Carte;
import ia.base.metier.carte.Coordonnee;
import ia.base.metier.carte.cases.Case;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author simonetma
 */
public class DijkstraTest {
    
    public DijkstraTest() {
    }
    
    /**
     * Test of calculerDistancesDepuis method, of class Dijkstra.
     */
    @Test
    public void testCalculerDistancesDepuis() {
        System.out.println("calculerDistancesDepuis");
        Carte carte = new Carte(
                "MDMEEH"
               +"MMMEEA"
               +"HEEEHH"
               +"HAHHHE"
               +"HAHEEE" 
               +"HHHEEE" 
        );
                
        Case depart = carte.getCase(new Coordonnee(0,1));
        Dijkstra instance = new Dijkstra(carte);
        instance.calculerDistancesDepuis(depart);
        
        int infini = 1+carte.getTaille()*carte.getTaille()*16;
                
        assertEquals(new Integer(infini), instance.getDistance(carte.getCase(new Coordonnee(0,0))));
        assertEquals(new Integer(0), instance.getDistance(carte.getCase(new Coordonnee(0,1))));
        assertEquals(new Integer(infini), instance.getDistance(carte.getCase(new Coordonnee(0,2))));
        assertEquals(new Integer(infini), instance.getDistance(carte.getCase(new Coordonnee(0,3))));
        assertEquals(new Integer(infini), instance.getDistance(carte.getCase(new Coordonnee(0,4))));
        assertEquals(new Integer(16), instance.getDistance(carte.getCase(new Coordonnee(0,5))));
        
        assertEquals(new Integer(2), instance.getDistance(carte.getCase(new Coordonnee(1,0))));
        assertEquals(new Integer(1), instance.getDistance(carte.getCase(new Coordonnee(1,1))));
        assertEquals(new Integer(2), instance.getDistance(carte.getCase(new Coordonnee(1,2))));
        assertEquals(new Integer(infini), instance.getDistance(carte.getCase(new Coordonnee(1,3))));
        assertEquals(new Integer(infini), instance.getDistance(carte.getCase(new Coordonnee(1,4))));
        assertEquals(new Integer(15), instance.getDistance(carte.getCase(new Coordonnee(1,5))));
        
        assertEquals(new Integer(3), instance.getDistance(carte.getCase(new Coordonnee(2,0))));
        assertEquals(new Integer(infini), instance.getDistance(carte.getCase(new Coordonnee(2,1))));
        assertEquals(new Integer(infini), instance.getDistance(carte.getCase(new Coordonnee(2,2))));
        assertEquals(new Integer(infini), instance.getDistance(carte.getCase(new Coordonnee(2,3))));
        assertEquals(new Integer(11), instance.getDistance(carte.getCase(new Coordonnee(2,4))));
        assertEquals(new Integer(12), instance.getDistance(carte.getCase(new Coordonnee(2,5))));
        
        assertEquals(new Integer(4), instance.getDistance(carte.getCase(new Coordonnee(3,0))));
        assertEquals(new Integer(7), instance.getDistance(carte.getCase(new Coordonnee(3,1))));
        assertEquals(new Integer(8), instance.getDistance(carte.getCase(new Coordonnee(3,2))));
        assertEquals(new Integer(9), instance.getDistance(carte.getCase(new Coordonnee(3,3))));
        assertEquals(new Integer(10), instance.getDistance(carte.getCase(new Coordonnee(3,4))));
        assertEquals(new Integer(infini), instance.getDistance(carte.getCase(new Coordonnee(3,5))));
        
        assertEquals(new Integer(5), instance.getDistance(carte.getCase(new Coordonnee(4,0))));
        assertEquals(new Integer(8), instance.getDistance(carte.getCase(new Coordonnee(4,1))));
        assertEquals(new Integer(9), instance.getDistance(carte.getCase(new Coordonnee(4,2))));
        assertEquals(new Integer(infini), instance.getDistance(carte.getCase(new Coordonnee(4,3))));
        assertEquals(new Integer(infini), instance.getDistance(carte.getCase(new Coordonnee(4,4))));
        assertEquals(new Integer(infini), instance.getDistance(carte.getCase(new Coordonnee(4,5))));
        
        assertEquals(new Integer(6), instance.getDistance(carte.getCase(new Coordonnee(5,0))));
        assertEquals(new Integer(7), instance.getDistance(carte.getCase(new Coordonnee(5,1))));
        assertEquals(new Integer(8), instance.getDistance(carte.getCase(new Coordonnee(5,2))));
        assertEquals(new Integer(infini), instance.getDistance(carte.getCase(new Coordonnee(5,3))));
        assertEquals(new Integer(infini), instance.getDistance(carte.getCase(new Coordonnee(5,4))));
        assertEquals(new Integer(infini), instance.getDistance(carte.getCase(new Coordonnee(5,5))));
    }

    /**
     * Test of getChemin method, of class Dijkstra.
     */
    @Test
    public void testGetChemin() {
       System.out.println("getChemin");
        Carte carte = new Carte(
                "MDMEEH"
               +"MMMEEA"
               +"HEEEHH"
               +"HAHHHE"
               +"HAHEEE" 
               +"HHHEEE" 
        );
                
        Case depart = carte.getCase(new Coordonnee(0,1));
        Dijkstra instance = new Dijkstra(carte);
        instance.calculerDistancesDepuis(depart);
        
        int infini = 1+carte.getTaille()*carte.getTaille()*16;
        
        
        
        System.out.println(" - Chemin vers (5,1)");
        ArrayList<TypeMouvement> result = instance.getChemin(carte.getCase(new Coordonnee(5,1)));
        TypeMouvement[] expResultArray = {BOTTOM, LEFT, BOTTOM, BOTTOM, BOTTOM, BOTTOM, RIGHT};
        ArrayList<TypeMouvement> expResult = new ArrayList<>(Arrays.asList(expResultArray));
        assertEquals(expResult,result);
        
        System.out.println(" - Chemin vers (0,5)");
        ArrayList<TypeMouvement> result2 = instance.getChemin(carte.getCase(new Coordonnee(0,5)));
        TypeMouvement[] expResultArray2 = {BOTTOM, LEFT, BOTTOM, BOTTOM, RIGHT, RIGHT, RIGHT, RIGHT, TOP, RIGHT, TOP, TOP};
        ArrayList<TypeMouvement> expResult2 = new ArrayList<>(Arrays.asList(expResultArray2));
        assertEquals(expResult2,result2);
        
    }
    
}
