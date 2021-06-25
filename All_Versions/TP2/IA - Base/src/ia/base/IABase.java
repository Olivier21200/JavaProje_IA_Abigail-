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
    public static void main(String[] args) {
        try {
            IA nouvelleIA = new IA();
            nouvelleIA.start();
        } catch (IOException ex) {
            System.err.println("Problème de connexion avec le serveur");
        }
    }
    
}
