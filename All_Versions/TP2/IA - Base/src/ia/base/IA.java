package ia.base;

import ia.base.modules.Module_Communication;
import ia.base.modules.Module_Decision;
import ia.base.modules.Module_Memoire;
import ia.base.modules.Module_Reaction;
import java.io.IOException;

/**
 * Classe principale de l'IA
 * @author Matthieu
 */
public class IA {


    private Module_Communication moduleCommunication;                           //Module de communication avec le serveur
    private Module_Decision moduleDecision;                                     //Module en charge de la prise de décisions
    private Module_Memoire moduleMemoire;                                       //Module en charge de la mémorisation des informations
    private Module_Reaction moduleReaction;                                     //Module en charge de la réaction de l'IA à un message du serveur
    private boolean isDiscussionTerminee;                                       //La discussion avec le serveur est-elle terminée
    private String messageEnvoye;                                               //Dernier message envoyé au serveur (ou devant être envoyé)
    private String messageRecu;                                                 //Dernier message reçu du serveur
    
    /**
     * Constructeur de l'IIA
     */
    public IA() {
        this.messageEnvoye = "";
        this.messageRecu = "";
        this.initialisation_Modules();
    }
    
    /**
     * Initialise les différents modules de l'IA
     */
    private void initialisation_Modules() {
        //Module de communication avec le serveur
        this.moduleCommunication = new Module_Communication(this);
        //Module de prise de décision
        this.moduleDecision = new Module_Decision(this);
        //Module de gestion de la mémoire
        this.moduleMemoire = new Module_Memoire(this);
        //Module de réaction aux messages du serveur
        this.moduleReaction = new Module_Reaction(this);
    }
    
    /**
     * Getter du module de communication
     * @return le module de communication
     */
    public Module_Communication getModuleCommunication() {
        return this.moduleCommunication; 
    }
    
    /**
     * Getter du module de décisiopn
     * @return le module de décision
     */
    public Module_Decision getModuleDecision() {
        return this.moduleDecision;
    }
    
    /**
     * Getter du module mémoire
     * @return le module mémoire
     */
    public Module_Memoire getModuleMemoire() {
        return this.moduleMemoire;
    }
    
    /**
     * Getter du module de réaction
     * @return le module de réaction
     */
    public Module_Reaction getModuleReaction() {
        return this.moduleReaction;
    }
    
    /**
     * Fonction servant à démarrer l'IA
     * @throws java.io.IOException en cas de problème de connexion
     */
    public void start() throws IOException {
        //LANCEMENT DU MODULE DE COMMUNICATION
            //Connexion au serveur
        this.moduleCommunication.connexion();   
            //Création des gestoionnaires des flux de communication
        this.moduleCommunication.creationFlux();                                
        
        //LANCEMENT DE LA BOUCLE DE DISCUSSION
        this.isDiscussionTerminee = false;
        while(!isDiscussionTerminee) {
            //Recepetion d'un message du serveur
            messageRecu = this.moduleCommunication.recevoirMessage();
            //On traite ce message
            this.reagirAuMessageRecu();
            //On détermine quoi faire
            messageEnvoye = this.determinerNouvelleAction();
            //On encoit le message au serveur
            this.moduleCommunication.envoyerMessage(messageEnvoye);
            
        }
    }
    
    
    /**
     * Interpréter la réponse du serveur et la prendre en compte
     */
    private void reagirAuMessageRecu() {
        this.moduleReaction.reagirAuMessageRecu(messageEnvoye,messageRecu);
    }
    
    /**
     * Déterminer la prochaine action à faire
     */
    private String determinerNouvelleAction() {
        return this.moduleDecision.determinerNouvelleAction(messageRecu);
    }
    
    
    /**
     * Met un terme à la discussion après le prochain message envoyé
     */
    public void arretDiscussion() {
        this.isDiscussionTerminee = true;
    }
}
