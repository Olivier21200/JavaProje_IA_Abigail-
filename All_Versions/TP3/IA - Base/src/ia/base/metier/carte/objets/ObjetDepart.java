/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte.objets;

import ia.base.metier.carte.cases.Case;

/**
 * Classe qui représente la sposition de départ.
 * @author os586357
 * @version 1.0
 */
public class ObjetDepart extends Objet
{
  
  /**
   * Constructeur
   * @param position position de l'objet
   */  
  public ObjetDepart(Case position) 
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
      return TypeRessource.DEPART;
    }
    
    /**
     * Opérateur qui return si l'objet est bloquant.
     * @return false si l'objet le lieu de départ.
     */
    @Override
    public boolean estBloquant() 
    {
        boolean Resultat =false;
        return Resultat;
    }
}
