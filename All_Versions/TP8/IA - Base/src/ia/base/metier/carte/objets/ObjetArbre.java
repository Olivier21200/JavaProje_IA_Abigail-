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
    public TypeObjet getType() 
    {
      return TypeObjet.ARBRE;
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
    /**
     *Opérateur qui return le type de loot et leur nombre
     * @return loot de l'harbre.
     */
    @Override
    public HashMap<TypeRessource, Integer> getLoot() 
    {
      HashMap<TypeRessource, Integer> Loot = new HashMap<TypeRessource, Integer>();
      Loot.put(TypeRessource.BOIS, 12);
     
      return Loot;
        
    }
    
}
