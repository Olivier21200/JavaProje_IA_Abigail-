/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte.objets;

import ia.base.metier.carte.cases.Case;

/**
 * Classe qui représente un escalier.
 * @author os586357
 * @version 1.0
 */
public class ObjetEscalier extends Objet
{
  /**
   * Constructeur
   * @param position position de l'objet
   */  
  public ObjetEscalier(Case position) 
  {
        super(position);
  }

    /**
     * Opérateur qui return le type de la case
     * @return typeCase
     */
    @Override
    public TypeRessource getType() 
    {
      return TypeRessource.ESCALIER;
    }  
    
    /**
     * Opérateur qui return si l'objet est bloquant.
     * @return false si l'objet est un escalier.
     */
    @Override
    public boolean estBloquant() 
    {
        boolean Resultat =false;
        return Resultat;
    }
}
