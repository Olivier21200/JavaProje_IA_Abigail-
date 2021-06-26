package ia.base.modules;

import ia.base.IA;
import ia.base.metier.TypeMouvement;
import ia.base.metier.actions.Action;
import ia.base.metier.actions.FabriqueAction;
import ia.base.metier.actions.TypeAction;
import ia.base.metier.actions.TypeActionRecolte;
import ia.base.metier.actions.TypeActionStatique;
import ia.base.metier.actions.TypeDemande;
import static ia.base.metier.actions.TypeDemande.CARTE;
import ia.base.metier.algorithmes.AlgorithmeCalculDistance;
import ia.base.metier.algorithmes.Dijkstra;
import ia.base.metier.algorithmes.ParcoursLargeur;
import ia.base.metier.carte.Carte;
import ia.base.metier.carte.Coordonnee;
import ia.base.metier.carte.cases.Case;
import ia.base.metier.carte.objets.TypeObjet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Module en charge de la prise de décision
 * @author Matthieu
 */
public class Module_Decision extends Module {

    private ArrayList<Action> listeDesActionsARealiser;
    
    /**
     * Constructeur
     * @param ia l'IA dont ce module fait partie
     */
    public Module_Decision(IA ia) {
        super(ia);
        this.listeDesActionsARealiser = new ArrayList<>();
    }

    /**
     * Méthode principale de prise de décision
     * @param messageRecu dernier message reçu par l'IUA
     * @return le message à envoyer au serveur
     */
    public String determinerNouvelleAction(String messageRecu) {
        String messageAEnvoyer = "END";
        
        //Gestion de la carte
        if(!this.getIA().getModuleMemoire().hasCarte()) {
            this.listeDesActionsARealiser.add(FabriqueAction.creerDemande(CARTE));
        }
              
        //L'IA n'a plus rien à faire
        if(this.listeDesActionsARealiser.isEmpty()) {
            this.determinerNouvellesActions();
        }
        
        
        //Réalisation de la première action
        if(!this.listeDesActionsARealiser.isEmpty()) {
            Action action = this.listeDesActionsARealiser.get(0);
            if(action.getType() == TypeAction.MOUVEMENT) {
                Coordonnee coordonneDestination = this.getIA().getModuleMemoire().getCaseJoueur().getCoordonnee().getVoisin(action.getDirection());
                Case caseDestination = this.getIA().getModuleMemoire().getCarte().getCase(coordonneDestination);
                if(caseDestination.getObjet() != null && caseDestination.getObjet().getType() == TypeObjet.ARBRE) {
                    this.listeDesActionsARealiser.add(0,FabriqueAction.creerActionRecolte(TypeActionRecolte.COUPERARBRE,action.getDirection()));
                    this.listeDesActionsARealiser.add(0,FabriqueAction.creerActionRecolte(TypeActionRecolte.COUPERARBRE,action.getDirection()));
                }
            }
            messageAEnvoyer = this.listeDesActionsARealiser.get(0).getMessage();
            this.getIA().getModuleMemoire().effectuerAction(this.listeDesActionsARealiser.get(0));
            this.listeDesActionsARealiser.remove(0);
        }
        else {
            this.allerDormir();
            messageAEnvoyer = this.listeDesActionsARealiser.get(0).getMessage();
            this.getIA().getModuleMemoire().effectuerAction(this.listeDesActionsARealiser.get(0));
            this.listeDesActionsARealiser.remove(0);
        }
        
        return messageAEnvoyer;
    }
    
    private void determinerNouvellesActions() {
        ArrayList<Coordonnee> listeCoordonneeArbres = new ArrayList<>();
        for(Case c : this.getIA().getModuleMemoire().getCarte().getCases()) {
            if(c.getObjet() != null && c.getObjet().getType() == TypeObjet.ARBRE) {
                listeCoordonneeArbres.add(c.getCoordonnee());
            }
        }
        
        Random gen = new Random();
        if(listeCoordonneeArbres.size()>0) {
            this.seDeplacerEn(listeCoordonneeArbres.get(gen.nextInt(listeCoordonneeArbres.size())));
        }
    }
    
    /**
     * Se déplacer en
     * @param coordonnee coordonnée destination 
     */
    private void seDeplacerEn(Coordonnee coordonnee) {
        System.out.println("--- Je veux aller en "+coordonnee+" ---");
        //On récupère la carte
        Carte carte = this.getIA().getModuleMemoire().getCarte();
        //On crée l'algo
        AlgorithmeCalculDistance algo = new Dijkstra(carte);
        //On récupère la case du joueur
        Case caseJoueur = this.getIA().getModuleMemoire().getCaseJoueur();
        //On lance les calculs de distance
        algo.calculerDistancesDepuis(caseJoueur);
        //On détermine la case de destination
        Case destination = carte.getCase(coordonnee);
        //On calcule le chemin
        List<TypeMouvement> listeMouvement = algo.getChemin(destination);
        //On crée les actions
        for(TypeMouvement typeMouvement : listeMouvement) {
            this.listeDesActionsARealiser.add(FabriqueAction.creerMouvement(typeMouvement));
        }
        
    }
    
    private void allerDormir() {
        this.seDeplacerEn(getIA().getModuleMemoire().getCarte().getCoordonneeDepart());
        this.listeDesActionsARealiser.add(FabriqueAction.creerActionStatique(TypeActionStatique.DORMIR));
    } 
}
