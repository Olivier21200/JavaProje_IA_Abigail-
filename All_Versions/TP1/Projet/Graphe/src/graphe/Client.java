/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author lt846115
 */
public class Client {
    private Socket socket;
    private BufferedReader fluxEntrant;
    private PrintWriter fluxSortant;
    
    public void connexion() throws IOException
    {
        Socket s = new Socket ("127.0.0.1",1234);
        this.socket = s;
    }
    
    public void creationFlux() throws IOException{
        InputStream is = this.socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        this.fluxEntrant = new BufferedReader(isr);
        
        
        OutputStream os = this.socket.getOutputStream();
        this.fluxSortant = new PrintWriter(os, true);
    }
    
    
    
    
    public void boucleDeDiscussion() throws IOException {
        String messageRecu = "" ;
        String messageAEnvoyer = "" ;
        int i;
        System.out.println("−− Debut de la transmission −−") ;
        do{
            //Reception du message du serveur
            messageRecu = this.fluxEntrant.readLine() ;
            System.out.println("< "+messageRecu) ;
            //Envoi du message de réponse
            fluxSortant.println(messageAEnvoyer) ;
            System.out.println("> "+messageAEnvoyer) ;
            
            for (i=0; i<2; i++){
                messageAEnvoyer = "MOVE|BOTTOM";
                fluxSortant.println(messageAEnvoyer) ;
                System.out.println("> "+messageAEnvoyer) ;
            }
            if (messageRecu.equals("NOK|MOUVEMENT IMPOSSIBLE : La case destination n'existe pas !")){
                messageAEnvoyer = "END";
            }
            while (!messageRecu.equals("NOK|MOUVEMENT IMPOSSIBLE : La case destination n'existe pas !")){
                messageAEnvoyer = "MOVE|RIGHT";
                fluxSortant.println(messageAEnvoyer) ;
                System.out.println("> "+messageAEnvoyer) ;
            }
        }while(!messageRecu.equals("END")) ;
            System.out.println("END") ;
    }

}
