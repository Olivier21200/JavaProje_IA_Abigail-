/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte.cases;

import ia.base.metier.carte.Coordonnee;
import ia.base.metier.carte.objets.Objet;
import java.util.ArrayList;

/**
 *
 * @author os586357
 */
public abstract class Case 
{
    private Coordonnee coordonee;
    private Objet objet;
    private ArrayList<Case> voisins;
    
    /**
     * Constructeur d'une case
     * @param cordonne coordonne de la case
     */
    public Case(Coordonnee cordonne)
    {
        this.coordonee=coordonee;
        this.objet=objet;
        this.voisins = new ArrayList<Case>();
    }
    
    /**
     * Opérateur affecte un objet.
     * @param obj Objet.
     */
     public void setObjet(Objet obj)
    {
        this.objet = obj;
    }
    
 
    /**
     * return les coordonnes
     * @return cordonne
     */
    public Coordonnee GetCordonnee()
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

    /**
     * Oprérateur qui retur la liste de voisins.
     * @return liste voisins.
     */
    public ArrayList<Case> getVoisins() 
    {
        return voisins;
    }
    
    /**
     * Opérateur case qui ajoute  la cace donnée 
     * en paramètre à la liste des voisin.
     * @param voisin voisin à ajouter..
     */
    public void ajouterVoisin(Case voisin)
    {
        voisins.add(voisin);
    }
    
    /**
     * Opréateur qui return le type de la ressource.
     * @return type de la case
     * @return 
     */
    public abstract TypeCase getType();
    
    /**
     * Opérateur qui return si une case est accessible.
     * @return true si la case est accessible.
     */
    public abstract boolean estAccessible();
}

    
   
