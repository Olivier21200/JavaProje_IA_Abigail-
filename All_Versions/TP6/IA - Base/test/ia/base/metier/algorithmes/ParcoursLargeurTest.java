package ia.base.metier.algorithmes;

import ia.base.metier.TypeMouvement;
import static ia.base.metier.TypeMouvement.*;
import ia.base.metier.carte.Carte;
import ia.base.metier.carte.Coordonnee;
import ia.base.metier.carte.cases.Case;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test unitaire du Parcours en largeur (calcul du chemin)
 * @author simonetma
 */
public class ParcoursLargeurTest {
    
    /**
     * Test of calculerDistancesDepuis method, of class ParcoursLargeur.
     */
    @Test
    public void testGetChemin() {
        System.out.println("getChemin");
        Carte carte = new Carte(
                "MDMTT"
               +"MMMAT"
               +"TTETH"
               +"HAAAH"
               +"HHHHH" 
        );
                
        Case depart = carte.getCase(new Coordonnee(0,1));
        ParcoursLargeur instance = new ParcoursLargeur(carte);
        instance.calculerDistancesDepuis(depart);
        
        ArrayList<TypeMouvement> result = instance.getChemin(carte.getCase(new Coordonnee(0,3)));
        TypeMouvement[] expResultArray = {BOTTOM,BOTTOM,LEFT,BOTTOM,BOTTOM,RIGHT,RIGHT,RIGHT,RIGHT,TOP,TOP,TOP,TOP,LEFT};
        /**
         * vue et validé en cours pour le test qui ne passe pas avec le LEFT avant le BOTTOM, même liste d'action.
         */
        ArrayList<TypeMouvement> expResult = new ArrayList<>(Arrays.asList(expResultArray));
        
        assertEquals(expResult,result);
        
    }
    
}
