/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier;

import ia.base.metier.carte.Coordonnee;

/**
 * Classe qui modélise le Joueur.
 * @author os586357
 * @version 1.0
 */
public class Joueur 
{
    private Coordonnee coordonnee;
        
    /**
     * Constrcucteur d'un joeur avec comme paramètre ces coordonne.
     * @param coordonnee Coordonne. 
     */
    public Joueur(Coordonnee coordonnee) 
    {
        this.coordonnee = coordonnee;
    }
    
    /**
     * Opérateur qui return les coordonne du Joueur.
     * @return coordonne du Joueur.
     */
    public Coordonnee getCoordonnee() 
    {
        return coordonnee;
    }
    
    /**
     * Opérateur qui permet au Joueur de ce déplacer.
     * @param mouvement mouvement du Joueur.
     */
    public void deplacer (TypeMouvement mouvement)
    {
         this.coordonnee = this.coordonnee.getVoisin(mouvement);     
    }
    
    

    
    
    
    
    
}
