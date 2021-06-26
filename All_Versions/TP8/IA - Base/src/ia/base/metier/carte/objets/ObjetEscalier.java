/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte.objets;

import ia.base.metier.carte.cases.Case;
import ia.base.metier.carte.ressources.TypeRessource;
import java.util.HashMap;

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
    public TypeObjet getType() 
    {
      return TypeObjet.ESCALIER;
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

    /**
     *Opérateur qui return le type de loot et leur nombre
     * @return loot de l'escalier.
     */
    @Override
    public HashMap<TypeRessource, Integer> getLoot() 
    {
      HashMap<TypeRessource, Integer> Loot =new HashMap<TypeRessource, Integer>();
   
      return Loot;
        
    }
}
