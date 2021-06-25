/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte;

/**
 * Classe qui représente des coordonnée
 * @author os586357
 * @version 1.0
 */
public class Coordonee 
{
    private int ligne;
    private int  colonne;
    
    /**
     * Constructeur de coordonée
     * @param ligne numéro de ligne
     * @param colonne numéro d ecolonne
     */
    public Coordonee(int ligne,int colonne)
    {
        this.ligne=ligne;
        this.colonne=colonne;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.ligne;
        hash = 37 * hash + this.colonne;
        return hash;
    }

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
        final Coordonee other = (Coordonee) obj;
        if (this.ligne != other.ligne) {
            return false;
        }
        if (this.colonne != other.colonne) {
            return false;
        }
        return true;
    }

   
     
}
