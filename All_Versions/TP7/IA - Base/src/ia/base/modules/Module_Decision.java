package ia.base.modules;

import ia.base.IA;
import ia.base.metier.actions.Action;
import ia.base.metier.actions.FabriqueAction;
import ia.base.metier.actions.TypeAction;
import ia.base.metier.actions.TypeActionRecolte;
import static ia.base.metier.actions.TypeDemande.CARTE;
import ia.base.metier.carte.Coordonnee;
import ia.base.metier.carte.cases.Case;
import ia.base.metier.carte.objets.TypeRessource;
import ia.base.modules.automate.Automate;
import java.util.ArrayList;

/**
 * Module en charge de la prise de décision
 * @author Matthieu
 */
public class Module_Decision extends Module {

    private ArrayList<Action> listeDesActionsARealiser;
    private Automate automate;
    
    /**
     * Constructeur
     * @param ia l'IA dont ce module fait partie
     */
    public Module_Decision(IA ia) 
    {
        super(ia);
        this.listeDesActionsARealiser = new ArrayList<>();
        this.automate = new Automate(this);
    }

    /**
     * Méthode principale de prise de décision
     * @param messageRecu dernier message reçu par l'IUA
     * @return le message à envoyer au serveur
     */
    public String determinerNouvelleAction(String messageRecu) 
    {
        String messageAEnvoyer="END";
        
        Action actionAutomate = automate.evoluer();
        
        messageAEnvoyer = actionAutomate.getMessage();
        
        automate.getModuleMemoire().effectuerAction(actionAutomate);
        
        return  messageAEnvoyer;
    }
    
  
   
    
}
