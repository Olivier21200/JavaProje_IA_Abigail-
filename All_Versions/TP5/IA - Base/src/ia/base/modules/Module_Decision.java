package ia.base.modules;

import ia.base.IA;
import ia.base.metier.TypeMouvement;
import ia.base.metier.actions.Action;
import ia.base.metier.actions.FabriqueAction;
import ia.base.metier.actions.TypeActionStatique;
import static ia.base.metier.actions.TypeDemande.CARTE;
import ia.base.metier.algorithmes.AlgorithmeCalculDistance;
import ia.base.metier.algorithmes.ParcoursLargeur;
import ia.base.metier.carte.Carte;
import ia.base.metier.carte.Coordonnee;
import ia.base.metier.carte.cases.Case;
import java.util.ArrayList;

/**
 * Module en charge de la prise de décision
 * @@author Matthieu @os586357
 */
public class Module_Decision extends Module 
{
    private ArrayList<Action> listeDesActionsARealiser;
    /**
     * Constructeur
     * @param ia l'IA dont ce module fait partie
     */
    public Module_Decision(IA ia) 
    {
        super(ia);
        //miste des action a effectueer
        this.listeDesActionsARealiser = new ArrayList<>();
    }

    /**
     * Méthode principale de prise de décision
     * @param messageRecu dernier message reçu par l'IUA
     * @return le message à envoyer au serveur
     */
    public String determinerNouvelleAction(String messageRecu) 
    {
        String messageReponse = "END";
        
        //Gestion de la carte et du joueur
        if(this.getIA().getModuleMemoire().hasCarte() == false)       
        {   
            this.listeDesActionsARealiser.add(FabriqueAction.creerDemande(CARTE));
        }
        
        //Détermine de nouvelles actions si besoin
        if(this.listeDesActionsARealiser.isEmpty()==true)       
        {
            //générations de déplacement aléatoire.
            determinerNouvellesActions();
        }
        
        //Réalisation de la première action de la liste
        if(this.listeDesActionsARealiser.isEmpty()==false)           
        {
            this.getIA().getModuleMemoire().effectuerAction(listeDesActionsARealiser.get(0));
            messageReponse=this.listeDesActionsARealiser.get(0).getMessage();
            this.listeDesActionsARealiser.remove(0);
        }
        else
        {
            this.allerDormir();
            messageReponse = this.listeDesActionsARealiser.get(0).getMessage();
            this.getIA().getModuleMemoire().effectuerAction(this.listeDesActionsARealiser.get(0));
            this.listeDesActionsARealiser.remove(0);
        }
        
        return messageReponse;
    }    
        
    /**
     * Opérateur qui determine plusieur nouvelle actions
     */
    private void determinerNouvellesActions()
    {
        seDeplacerEn(new Coordonnee ((int) (Math.random()*40),(int)(Math.random()*40)));
    } 
    
    /**
     * Opérateur qui permet de ce déplacée
     * @param coordonnee coordonné de déplacement.
     */
    private void seDeplacerEn(Coordonnee coordonnee)
    {
        //Variables de travail.
        Carte Carte=null;
        Case CaseDuJoueur=null;
        Case CaseDeDestination=null;
         
        //Affichage console
        System.out.println("---Je veux aller en "+ String.valueOf(coordonnee)+"---");
        
        //On récupère la carte en la demandant au module mémoire
        Carte = this.getIA().getModuleMemoire().getCarte();
        
        //On crée un nouvel algorithme de parcours en largeur
        AlgorithmeCalculDistance AlgoDistance = new ParcoursLargeur(Carte);
        
        //On récupère la case où se trouve le joueur
        CaseDuJoueur= this.getIA().getModuleMemoire().getCaseJoueur();
        
        //On lance le calcul des distances à partir de cette case
        AlgoDistance.calculerDistancesDepuis(CaseDuJoueur);
        
        //On détermine la case de destination
        CaseDeDestination = Carte.getCase(coordonnee);
        ArrayList<TypeMouvement> listeMouvement = AlgoDistance.getChemin(CaseDeDestination);
        
        //Création des différantes action et ajout à la liste.
        for(TypeMouvement typeMouvement : listeMouvement) 
        {
            //On demande à la fabrique de créer une nouvelle actionMouvement
            //On ajoute cette action à la liste des actions à réaliser
            this.listeDesActionsARealiser.add(FabriqueAction.creerMouvement(typeMouvement));
        }
    }
    
    /**
     * Opérateur qui effectue l'action d'aller dormir a notre IA.
     */
     private void allerDormir() 
     {
        this.seDeplacerEn(getIA().getModuleMemoire().getCarte().getCDepart());
        this.listeDesActionsARealiser.add(FabriqueAction.creerActionStatique(TypeActionStatique.DORMIR));
    } 
}
