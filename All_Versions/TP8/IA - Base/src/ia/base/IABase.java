package ia.base;

import java.io.IOException;

/**
 * Main
 * @author simonetma
 */
public class IABase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        boolean test=false;
        System.out.println(String.valueOf(!test));
        try {
            IA nouvelleIA = new IA();
            nouvelleIA.start();
        } catch (IOException ex) {
            System.err.println("Problème de connexion avec le serveur");
        }
    }
    
}
