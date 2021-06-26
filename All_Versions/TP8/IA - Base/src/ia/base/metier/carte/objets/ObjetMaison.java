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
 * Classe qui représente une maison.
 * @author os586357
 * @version 1.0
 */
public class ObjetMaison extends Objet
{
   /**
   * Constructeur
   * @param position position de l'objet
   */  
     public ObjetMaison(Case position) 
    {
        super(position);
    }

    /**
     * Return le type de la case
     * @return typeCase
     */
    @Override
    public TypeObjet getType() 
    {
      return TypeObjet.MAISON;
    }
    
    /**
     * Opérateur qui return si l'objet est bloquant.
     * @return true si l'objet est une maison.
     */
    @Override
    public boolean estBloquant() 
    {
        boolean Resultat =true;
        return Resultat;
    }
    
     /**
     *Opérateur qui return le type de loot et leur nombre
     * @return loot de la maison.
     */
    @Override
    public HashMap<TypeRessource, Integer> getLoot() 
    {
      HashMap<TypeRessource, Integer> Loot =new HashMap<TypeRessource, Integer>();
      
      return Loot;
        
    }
}
