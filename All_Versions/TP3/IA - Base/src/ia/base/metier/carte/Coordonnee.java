/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte;

import ia.base.metier.TypeMouvement;

/**
 * Classe qui représente des coordonnée
 * @author os586357
 * @version 1.0
 */
public class Coordonnee 
{
    private int ligne;
    private int  colonne;
    
    
    /**
     * Constructeur de coordonée
     * @param ligne numéro de ligne
     * @param colonne numéro d ecolonne
     */
    public Coordonnee(int ligne,int colonne)
    {
        this.ligne=ligne;
        this.colonne=colonne;
    }
    
    /**
     * 
     * @param coordonnee
     * @return 
     */
    public Coordonnee getCoordonnee(Coordonnee coordonnee)
    {
        return coordonnee;
    }
            
    
    /**
     * return le numéro de la ligne
     * @return ligne
     */
    public int GetLigne()
    {
        return this.ligne;
    }
    
    /**
     * return le numéro de la colonne
     * @return colonne
     */
     public int GetColonne()
    {
        return this.colonne;
    }

     /**
      * 
      * @return 
      */
    @Override
    public int hashCode() 
    {
        int hash = 3;
        hash = 59 * hash + this.ligne;
        hash = 59 * hash + this.colonne;
        return hash;
    }
    
    /**
     * 
     * @param obj objet
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordonnee other = (Coordonnee) obj;
        if (this.ligne != other.ligne) {
            return false;
        }
        if (this.colonne != other.colonne) {
            return false;
        }
        return true;
    }
    
    /**
     * Opérateur qui Return les coordonnées de la case en réalisant le mouvement
     * @param mouvement mouvement qui est effectué.
     * @return  Coordonné de la case voisine. 
     */
    public Coordonnee getVoisin(TypeMouvement mouvement)
    {
        Coordonnee Resultat = null;
        
      switch (mouvement) 
      {
          
          case TOP : Resultat = new Coordonnee(ligne-1, colonne);
          break;
          
          case BOTTOM : Resultat = new Coordonnee(ligne+1,colonne);
          break;
      
          case RIGHT : Resultat = new Coordonnee(ligne, colonne+1);
          break;
          
          case LEFT : Resultat = new Coordonnee(ligne, colonne-1);
          break;
      }
           return Resultat;
    }
    
    /**
     * Opérateur qui test et renvoie le type de mouvement effectué.
     * @param destination coordonnee de la destination du déplacement
     * @return Type de mouvement.
     */
    public TypeMouvement getMouvementPourAller(Coordonnee destination)
    {
        TypeMouvement Resultat = null;
        
        if(destination.ligne+1 ==  this.ligne)
        {
            Resultat = TypeMouvement.TOP;
        }
        else 
        if (destination.colonne+1 == this.colonne)
        {
           Resultat = TypeMouvement.LEFT;
        }
        else if(destination.colonne == this.colonne+1)
        {
            Resultat = TypeMouvement.RIGHT;
        }
        
        else if (destination.ligne ==  this.ligne+1)
        {
           Resultat = TypeMouvement.BOTTOM;
        }
        /*return default*/
        else Resultat = null;
        
        return Resultat;
    }
    
    /**
     * Opérateur qui renvoie les mouvement du joueur en String.
     * @return Chaine de caractère(mouvement du joueur).
     */
    @Override
    public String toString()
    {
       String Resultat = "";
       
       Resultat = "{ X :"+String.valueOf(ligne)+", Y: "+String.valueOf(colonne)+"} \n";
       return Resultat;
    }
}
