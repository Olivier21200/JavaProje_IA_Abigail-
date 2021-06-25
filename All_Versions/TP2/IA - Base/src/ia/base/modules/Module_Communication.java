package ia.base.modules;

import ia.base.IA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Module en charge de la communication avec le serveur
 * @author Matthieu
 */
public class Module_Communication extends Module {

    private Socket socket;
    private BufferedReader fluxEntrant;
    private PrintWriter fluxSortant;
    
    /**
     * Constructeur
     * @param ia l'IA dont ce module fait partie
     */
    public Module_Communication(IA ia) {
        super(ia);
    }
    
    /**
     * Connecte le client au serveur
     * @throws IOException en cas d'erreur de connexion
     */
    public void connexion() throws IOException {
        //Création du socket entre client et serveur
        this.socket = new Socket("127.0.0.1",1234);
    }
    
    /**
     * Crée les deux gestionnaires de flux
     * @throws IOException en cas d'erreur de connexion
     */
    public void creationFlux() throws IOException {
        //Création du gestionnaire de flux entrant
        InputStreamReader iSReader = new InputStreamReader(this.socket.getInputStream());
        this.fluxEntrant = new BufferedReader(iSReader);
        //Création du gestionnaire de flux sortant
        this.fluxSortant = new PrintWriter(this.socket.getOutputStream(),true);
    }

    /**
     * Envoie le message donné au serveur et l'affiche dans la console
     * @param message le message à envoyer
     */
    public void envoyerMessage(String message) {
        System.out.println(">> "+message);
        this.fluxSortant.println(message);
    }
    
    //
    /**
     * Ecoute et renvoie un message du serveur (en l'affichant aussi dans la console)
     * @throws java.io.IOException en cas d'erreur de connexion
     */
    public String recevoirMessage() throws IOException {
        String message = this.fluxEntrant.readLine();
        System.out.println("<< "+message);
        return message;
    }
    
}
