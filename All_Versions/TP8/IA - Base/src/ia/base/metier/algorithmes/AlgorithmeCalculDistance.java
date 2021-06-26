/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.algorithmes;

import ia.base.metier.TypeMouvement;
import ia.base.metier.carte.Carte;
import ia.base.metier.carte.cases.Case;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe de l' algo de gestion de la distance.
 * @author Olivier Sirugue
 * @version 1.0
 */
public abstract class AlgorithmeCalculDistance 
{
    private final Carte carte;
    private final HashMap<Case,Integer> distances = new HashMap<>();

    public AlgorithmeCalculDistance(Carte carte) 
    {
        this.carte = carte;
        //this.distances = new HashMap<>();
    }  

    
    
    /**
     * Opérateur qui return la carte.   
     * @return carte
     */
    protected Carte getCarte() 
    {
        return carte;
    }
    
    /**
     * Opérateur qui  insère le couple (position,valeur) dans la HashMap.
     * @param position coordonée de la case.
     * @param valeur valeur de la case.
     */
    protected void setDistance (Case position ,int valeur)
    {
        this.distances.put(position, valeur);
    }
    
    /**
     * Renvoie la valeur stockée dans la HashMap pour la case donnée en paramètre.
     * @param arrivee carse de destination
     * @return distance avant d'arriver a la cade de destination
     */
    public Integer getDistance(Case arrivee)
    {
        Integer Resultat=this.distances.get(arrivee);
        return Resultat;
    }
    
    /**
     * Opérateur qui vide le HashMap
     */
    protected void reinitialisationDistance()
    {
        this.distances.clear();
    }
    
    public abstract void calculerDistancesDepuis(Case depart);
    
    
    /**
     * Opérateur qui return la séquence de mouvements à réaliser pour passer d’une case à une autre
     * @param arrivee Case arrivée.
     * @return liste de mouvement.
     */
    public abstract ArrayList<TypeMouvement> getChemin(Case arrivee);

}
