/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte.cases;

import ia.base.metier.carte.Coordonee;
import ia.base.metier.carte.objets.Objet;

/**
 *
 * @author os586357
 */
public abstract class Case 
{
    private Coordonee coordonee;
    private Objet objet;
    
    /**
     * Constructeur d'une case
     * @param cordonne coordonne de la case
     */
    public Case(Coordonee cordonne)
    {
        this.coordonee=coordonee;
        this.objet=objet;
    }
    
 
    /**
     * return les coordonnes
     * @return cordonne
     */
    public Coordonee GetCordonnee()
    {
        return this.coordonee;
    }
    
    /**
     * Return l'objet
     * @return objet 
     */
    public Objet getObjet()
    {
        return this.objet;
    }
    
    /**
     * Modificateur d'objet
     * @param objet objet
     */
    public void SetObjet(Objet objet)
    {
        this.objet=objet;
    }
    
    public abstract TypeCase getType();
}
