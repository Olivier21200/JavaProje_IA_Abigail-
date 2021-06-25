/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphe;

import java.io.IOException;

/**
 *
 * @author lt846115
 */
public class Graphe {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Client c = new Client();
        c.connexion();
        c.creationFlux();
        c.boucleDeDiscussion();
    }
    
}
