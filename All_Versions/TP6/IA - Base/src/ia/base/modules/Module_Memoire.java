package ia.base.modules;

import ia.base.IA;
import ia.base.metier.Joueur;
import ia.base.metier.actions.Action;
import ia.base.metier.actions.TypeAction;
import ia.base.metier.carte.Carte;
import ia.base.metier.carte.Coordonnee;
import ia.base.metier.carte.cases.Case;

/**
 * Module en charge de la mémorisation et de la restitution des informations obtenues
 * @author Matthieu
 */
public class Module_Memoire extends Module  
 {
    
    private Carte carte;
    private Joueur joueur;
    /**
     * Constructeur
     * @param ia l'IA dont ce module fait partie
     */
    public Module_Memoire(IA ia) {
        super(ia);
    }
    
    /**
     * Opérateur qui génère la carte.
     * @param messageRecu Message recu
     */
    public void genererCarte(String messageRecu)
    {
        this.carte = new Carte(messageRecu);
       genererJoueur(this.carte.getCDepart());
       this.carte.afficheConsole();
    }
    
    /**
     * Opérateur qui test si la carte a été créer
     * @return true si la carte a étét créée 
     */
    public boolean hasCarte()
    {
        boolean Resultat = false;
        if (this.carte != null)
        {
             Resultat=true;
        }
        else Resultat=false;
            
        return Resultat;
    }
    
    /**
     * Opérateur qui test et return si le joueur est créer
     * @return true si joueur==null
     */
    public boolean hasJoueur() 
    {
        boolean Resultat =false;
        if(this.joueur==null)
        {
           Resultat = true;
        }
        else Resultat = false;
        return Resultat;
    }
    
    /**
    * Opérateur qui return l’attribut joueur.
    * @return joueur 
    */            
    public Joueur getJoueur()
    {
        return this.joueur;
    }

    /**
    * Opérateur qui génère le joueur à partir 
    * des coordonnées données en paramètre.
    * @param coordonnne Coordonne de génération du joueur.
    */
    public void genererJoueur(Coordonnee coordonnee) 
    {
         this.joueur = new Joueur(coordonnee);     
    }

    /**
     * Opérateur qui return la carte.
     * @return Carte du jeux.
     */
    public Carte getCarte() 
    {
        return carte;
    }
    
    /**
     * Opérateur qui return la case di joueur.
     * @return Case du joueur.
     */
    public Case getCaseJoueur() 
    {
        //Variable de sortie.
        Case Resultat =null;
        
        Resultat=this.carte.getCase(this.joueur.getCoordonnee());
        
        return Resultat;
    }
    
   /**
    * Opérateur qui fait faire des actions au joueur.
    * @param action action donner au joueur.
    */ 
   public void effectuerAction(Action action)
   {
       if(action.getType() == TypeAction.MOUVEMENT) 
       {
        this.joueur.deplacer(action.getDirection()) ;
       }
       else if(action.getType() == TypeAction.RECOLTE) 
       {
         if(action.getDirection() != null) 
         {
            Case caseDestination = this.carte.getCase(this.getCaseJoueur().GetCordonnee().getVoisin(action.getDirection())) ;
            caseDestination.setObjet(null) ;
         }
        }
   }
    
}
