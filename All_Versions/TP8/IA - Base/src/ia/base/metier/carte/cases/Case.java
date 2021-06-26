/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte.cases;

import ia.base.metier.TypeMouvement;
import ia.base.metier.carte.Coordonnee;
import ia.base.metier.carte.objets.Objet;
import java.util.ArrayList;

/**
 * Classe de gestion des case de la carte.
 * @author Olivier Sirugue
 * @version 1.0
 */
public abstract class Case 
{
    private Coordonnee coordonnee;
    private Objet objet;
    private ArrayList<Case> voisins;
    
    /**
     * Constructeur d'une case
     * @param coordonnee coordonne de la case
     */
    public Case(Coordonnee coordonnee)
    {
        this.coordonnee=coordonnee;
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
        return this.coordonnee;
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
     */
    public abstract TypeCase getType();
    
    /**
     * Opérateur qui return si une case est accessible.
     * @return true si la case est accessible.
     */
    public abstract boolean estAccessible();
    
    /**
     * Opérateur qui déterminant le mouvement à faire
     * pour passer d’une case à une autre.
     * @param arrivee Case a arriver.
     * @return type de mouvement.
     */
   public TypeMouvement getMouvementPourAller(Case arrivee)
    {
        return this.coordonnee.getMouvementPourAller(arrivee.coordonnee);
    }

}


