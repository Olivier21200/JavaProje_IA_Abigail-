/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte.objets;

import ia.base.metier.carte.cases.Case;

/**
 * Classe qui représente un arbre
 * @author os586357
 * @version 1.0
 */
public class ObjetArbre extends Objet
{
   /**
   * Constructeur
   * @param position position de l'objet
   */  
    public ObjetArbre(Case position) 
    {
        super(position);
    }

    /**
     * Return le type de la case
     * @return typeCase
     */
    @Override
    public TypeRessource getType() 
    {
      return TypeRessource.ARBRE;
    }

    /**
     * Opérateur qui return si l'objet est bloquant.
     * @return true si l'objet est un arbre.
     */
    @Override
    public boolean estBloquant() 
    {
        boolean Resultat =false;
        return Resultat;
    }
    
    /**
     * Opérateur qui renvoie si un objet est récoltable
     * @return true si arbre
     */
    @Override
    public boolean estRecoltable()
    {
        return true;
    }
    
    /**
     * Opérateur qui return le coup de la récolte d'un objet.
     * @return Coup de la récolte d'un arbre.
     */
    public int coutRecolte()
    {
        return 2;
    }
    
}
