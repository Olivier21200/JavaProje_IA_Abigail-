package ia.base.metier.algotithmes;

import ia.base.metier.algorithmes.ParcoursLargeur;
import ia.base.metier.carte.Carte;
import ia.base.metier.carte.Coordonnee;
import ia.base.metier.carte.cases.Case;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test unitaire du Parcours en largeur (calcul des distances)
 * @author simonetma
 */
public class ParcoursLargeurTest {
    
    /**
     * Test of calculerDistancesDepuis method, of class ParcoursLargeur.
     */
    @Test
    public void testCalculerDistancesDepuis() {
        System.out.println("calculerDistancesDepuis");
        Carte carte = new Carte(
                "TMDMT"
               +"EMMMA"
               +"TTTTH"
               +"HAAAH"
               +"HHHAH" 
        );
                
        Case depart = carte.getCase(new Coordonnee(0,2));
        ParcoursLargeur instance = new ParcoursLargeur(carte);
        instance.calculerDistancesDepuis(depart);
                
        assertEquals(null, instance.getDistance(carte.getCase(new Coordonnee(0,0))));
        assertEquals(null, instance.getDistance(carte.getCase(new Coordonnee(0,1))));
        assertEquals(new Integer(0), instance.getDistance(carte.getCase(new Coordonnee(0,2))));
        assertEquals(null, instance.getDistance(carte.getCase(new Coordonnee(0,3))));
        assertEquals(null, instance.getDistance(carte.getCase(new Coordonnee(0,4))));
        
        assertEquals(null, instance.getDistance(carte.getCase(new Coordonnee(1,0))));
        assertEquals(new Integer(2), instance.getDistance(carte.getCase(new Coordonnee(1,1))));
        assertEquals(new Integer(1), instance.getDistance(carte.getCase(new Coordonnee(1,2))));
        assertEquals(new Integer(2), instance.getDistance(carte.getCase(new Coordonnee(1,3))));
        assertEquals(null, instance.getDistance(carte.getCase(new Coordonnee(1,4))));
        
        assertEquals(new Integer(4), instance.getDistance(carte.getCase(new Coordonnee(2,0))));
        assertEquals(new Integer(3), instance.getDistance(carte.getCase(new Coordonnee(2,1))));
        assertEquals(new Integer(2), instance.getDistance(carte.getCase(new Coordonnee(2,2))));
        assertEquals(new Integer(3), instance.getDistance(carte.getCase(new Coordonnee(2,3))));
        assertEquals(new Integer(4), instance.getDistance(carte.getCase(new Coordonnee(2,4))));
        
        assertEquals(new Integer(5), instance.getDistance(carte.getCase(new Coordonnee(3,0))));
        assertEquals(null, instance.getDistance(carte.getCase(new Coordonnee(3,1))));
        assertEquals(null, instance.getDistance(carte.getCase(new Coordonnee(3,2))));
        assertEquals(null, instance.getDistance(carte.getCase(new Coordonnee(3,3))));
        assertEquals(new Integer(5), instance.getDistance(carte.getCase(new Coordonnee(3,4))));
        
        assertEquals(new Integer(6), instance.getDistance(carte.getCase(new Coordonnee(4,0))));
        assertEquals(new Integer(7), instance.getDistance(carte.getCase(new Coordonnee(4,1))));
        assertEquals(new Integer(8), instance.getDistance(carte.getCase(new Coordonnee(4,2))));
        assertEquals(null, instance.getDistance(carte.getCase(new Coordonnee(4,3))));
        assertEquals(new Integer(6), instance.getDistance(carte.getCase(new Coordonnee(4,4))));
    }
    
}
