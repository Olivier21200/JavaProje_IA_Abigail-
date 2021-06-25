/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte;

import ia.base.metier.TypeMouvement;

/**
 * Classe de gestion de coordonnée
 * @author Olivier Sirugue
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
     * Opérateur que return les coordonnee.
     * @param coordonnee Coordonnee qui va etre return.
     * @return Coordonnee.
     */
    public Coordonnee getCoordonnee(Coordonnee coordonnee)
    {
        return coordonnee;
    }
            
    
    /**
     * Opérateur qui return le numéro de la ligne
     * @return ligne
     */
    public int GetLigne()
    {
        return this.ligne;
    }
    
    /**
     * Opérateur qui return le numéro de la colonne
     * @return colonne
     */
     public int GetColonne()
    {
        return this.colonne;
    }

     
    @Override
    public int hashCode() 
    {
        int hash = 3;
        hash = 59 * hash + this.ligne;
        hash = 59 * hash + this.colonne;
        return hash;
    }
    
    /**
     * Opérateur qui test si il exite deux objet Coordonnee avec les meme valeur.
     * @param obj objet a test.
     * @return true si chaque objet est unique.
     */
    @Override
    public boolean equals(Object obj) 
    {
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
          //voisin bas
          case TOP : Resultat = new Coordonnee(ligne-1, colonne);
          break;
          
          //voisin haut
          case BOTTOM : Resultat = new Coordonnee(ligne+1,colonne);
          break;
      
          //voisin droit
          case RIGHT : Resultat = new Coordonnee(ligne, colonne+1);
          break;
          
         //voisin gauche
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
       TypeMouvement ResultatMouvement = null;
        if (destination.ligne == this.ligne+1)
        {
            ResultatMouvement= TypeMouvement.BOTTOM;
        }
        else if(destination.ligne+1 == this.ligne)
        {
             ResultatMouvement= TypeMouvement.TOP;
        }
        else 
        if (destination.colonne+1 == this.colonne)
        {
             ResultatMouvement = TypeMouvement.LEFT;
        }
        else if(destination.colonne == this.colonne+1)
        {
             ResultatMouvement= TypeMouvement.RIGHT;
        }
        //resultat mouvement par default
        else  ResultatMouvement = null;
        
        return  ResultatMouvement;
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
