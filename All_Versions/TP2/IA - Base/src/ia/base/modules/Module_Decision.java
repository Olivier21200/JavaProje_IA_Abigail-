package ia.base.modules;

import ia.base.IA;

/**
 * Module en charge de la prise de décision
 * @author Matthieu
 */
public class Module_Decision extends Module {

    /**
     * Constructeur
     * @param ia l'IA dont ce module fait partie
     */
    public Module_Decision(IA ia) {
        super(ia);
    }

    /**
     * Méthode principale de prise de décision
     * @param messageRecu dernier message reçu par l'IUA
     * @return le message à envoyer au serveur
     */
    public String determinerNouvelleAction(String messageRecu) {
        
        if(hasCarte()==false)
        {
            return "Map";
        }
        else
        this.getIA().arretDiscussion();  
        return "END";
        
    }
}
