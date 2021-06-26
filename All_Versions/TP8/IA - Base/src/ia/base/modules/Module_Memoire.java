package ia.base.modules;

import ia.base.IA;
import ia.base.metier.Joueur;
import ia.base.metier.actions.Action;
import ia.base.metier.actions.TypeAction;
import ia.base.metier.carte.Carte;
import ia.base.metier.carte.Coordonnee;
import ia.base.metier.carte.cases.Case;
import ia.base.metier.carte.objets.Objet;
import ia.base.metier.carte.objets.TypeObjet;
import ia.base.metier.carte.ressources.TypeRessource;
import java.util.HashMap;

/**
 * Module en charge de la mémorisation et de la restitution des informations obtenues
 * @author Matthieu
 */
public class Module_Memoire extends Module  
 {
    
    private Carte carte;
    private Joueur joueur;
    private HashMap<TypeRessource,Integer> inventaire = new HashMap<TypeRessource,Integer>();
    private HashMap<TypeRessource,Integer> stockMagasin;
   
    /**
     * Constructeur
     * @param ia l'IA dont ce module fait partie
     */
    public Module_Memoire(IA ia) 
    { 
        super(ia);
        inventaire.put(TypeRessource.BOIS,0);
        inventaire.put(TypeRessource.CAULIFLOWERMATURE,0);
        inventaire.put(TypeRessource.CAULIFLOWERSEED,0);
        inventaire.put(TypeRessource.CHICKEN,0);
        inventaire.put(TypeRessource.EGG,0);
        inventaire.put(TypeRessource.GOLD,500);
        inventaire.put(TypeRessource.MAYONNAISE,0);
        inventaire.put(TypeRessource.PARSNIPMATURE,0);
        inventaire.put(TypeRessource.PARSNIPSEED,0);
        stockMagasin= null;
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
    * @param coordonnee
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
        this.joueur.deplacer(action.getDirection());
       }
       else if(action.getType() == TypeAction.RECOLTE) 
       {
         if(action.getDirection() != null) 
         {
            Case caseDestination = this.carte.getCase(this.getCaseJoueur().GetCordonnee().getVoisin(action.getDirection())) ;
            recolter(caseDestination.getObjet());
            caseDestination.setObjet(null);
         }
       }
       else if (action.getType()== TypeAction.ACTIONSTATIQUE)
       {
           this.stockMagasin=null; 
       }
       else if (action.getType()== TypeAction.ACHAT)
       {
         if(this.getStockMagasin(TypeRessource.PARSNIPSEED)>=0)
         {
           this.inventaire.replace(TypeRessource.GOLD, this.getQuantiteRessource(TypeRessource.GOLD)-20);
           this.inventaire.replace(TypeRessource.PARSNIPSEED, getQuantiteRessource(TypeRessource.PARSNIPSEED) + 1);
           this.stockMagasin.replace(TypeRessource.PARSNIPSEED, this.getStockMagasin(TypeRessource.PARSNIPSEED) - 1);
         }
         else
         {
          this.inventaire.replace(TypeRessource.GOLD, this.getQuantiteRessource(TypeRessource.GOLD)-20);
          this.inventaire.replace(TypeRessource.CAULIFLOWERSEED, getQuantiteRessource(TypeRessource.CAULIFLOWERSEED) + 1);
          this.stockMagasin.replace(TypeRessource.CAULIFLOWERSEED, this.getStockMagasin(TypeRessource.CAULIFLOWERSEED) - 1);
         }
       }
   }
   
   /**
    * Opérateur qui ajoute a l’inventaire 
    * les ressources obtenues en récoltant l’objet. 
    * @param objet objet recolter.
    */
   private void recolter(Objet objet)
   {
       if(objet!=null)
       {                  
            switch(objet.getType())
            {
               case ARBRE : this.inventaire.replace(TypeRessource.BOIS, objet.getLoot().get(TypeObjet.ARBRE));
            }                
    }
   }
   
   /**
    * Opérateur qui return la quantité de la ressource du joueur.
    * @param type Type de la ressource.
    * @return Quantité de la ressource du joueur.
    */
   public int getQuantiteRessource(TypeRessource type)
   {
       int Resultat;
          
       Resultat = inventaire.get(type);
       return Resultat;
   }

   /**
    * Opérateur qui genere le stock du magasin.
    * @param nbGrainePanais Graine de panais.
    * @param nbGraineChouFleur Graine de choufleur.
    */
    public void genererStockMagasin(int nbGrainePanais,int nbGraineChouFleur)
    {
     stockMagasin = new HashMap<>();
     stockMagasin.put(TypeRessource.PARSNIPSEED,nbGrainePanais );
     stockMagasin.put(TypeRessource.CAULIFLOWERSEED, nbGraineChouFleur);
    
    }

    /**
     * Opérateur qui return si le magasin a du stock.
     * @return True si stockMagasin !=null.
     */
    public boolean hasStockMagasin()
    {
        boolean Resultat = false;
        if(stockMagasin !=null)
        {
            Resultat = true;
        }
        return Resultat;
    }
    
    /**
     * Opérateur qui return le stock du magasin en fonction du type de la ressource.
     * @param type type de la ressource.
     * @return  Stock du magasin.
     */
        public int getStockMagasin(TypeRessource type)
    {   
        int Resultat= 0;
        if(!this.stockMagasin.isEmpty())
        {
            Resultat= stockMagasin.get(type);
        }
        return Resultat;
    }
   
    
    

}
