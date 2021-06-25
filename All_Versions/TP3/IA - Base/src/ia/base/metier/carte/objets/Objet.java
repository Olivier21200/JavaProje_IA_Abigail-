/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte.objets;

import ia.base.metier.carte.cases.Case;


/**
 *
 * @author os586357
 * @version 1.0
 */
public abstract class Objet 
{
    private Case position;
    
    /**
     * Constructeur d'une objet
     * @param position possition e l'objet
     */
    public Objet (Case position)
    {
        this.position=position;
    }
    
    /**
     * Return la position de la case
     * @return position
     */
    public Case GetPosition()
    {
        return this.position;
    }
    
    /**
     * Opréateur qui return le type de la ressource.
     * @return type de lA Ressource 
     */
    public abstract TypeRessource getType();
    
    /**
     * Opérateur qui return si un objet est accessible.
     * @return false si l'objet accessible
     */
    public abstract boolean estBloquant();
            
    
    
}
