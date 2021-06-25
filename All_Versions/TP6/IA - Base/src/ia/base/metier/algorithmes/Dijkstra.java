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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Classe qui représente l'algorithme de dijkstra
 * @author Olivier
 * @version 1.0
 */
public class Dijkstra extends AlgorithmeCalculDistance 
{
    
    private HashMap<Case, Boolean> estVisite;
    private HashMap<Case, Case> predecesseur;
    private int infini;
    
    /**
     * Constructeur de l'algo Dijkstra
     * @param carte 
     */
    public Dijkstra(Carte carte) 
    {
        super(carte);
        estVisite = new HashMap<>();
        predecesseur = new HashMap<>();
        this.infini = 1 + (16*carte.getTaille()*carte.getTaille());     
    }

      private int coutMouvementvers(Case destination)
    {
        if(destination.estAccessible() == false) 
        {
            return this.infini;
        }
        if(destination.getObjet() != null && destination.getObjet().estRecoltable() == true)
        {
            return destination.getObjet().coutRecolte() + 1;
        }
        else
        {
          return 1;
       }
    }
    
    /**
     * Opérateur qui initialiser l'algorithme de dijkstra
     * @param depart Cassé de départ.
     */
    private void initialisation(Case depart)
    {
        List<Case> list = new ArrayList<>(super.getCarte().getCases());
        for(int i = 0 ; i < list.size(); i++)
        {
            Case casetemp = list.get(i);
            estVisite.put(casetemp, Boolean.FALSE);
            predecesseur.put(casetemp, null);
            setDistance(casetemp, infini);
        }
        this.setDistance(depart, 0);
    }
    
    /**
     * Opérateur qui
     * @param a
     * @param b 
     */
    private void relachement(Case a, Case b)
    {
        if(getDistance(b) > getDistance(a) + coutMouvementvers(b))
        {
            setDistance(b, getDistance(a) + coutMouvementvers(b));
            predecesseur.put(b, a);
        }
    }
    
    /**
     * Opérateur qui return la case avec la plus petite distance déja calculée
     * @return Case.
     */
    private Case getCaseLaPlusProche()
    {
        int distanceMin = this.infini;
        Case res = null;
        List<Case> list = new ArrayList<>(super.getCarte().getCases());
        
        for(int i = 0; i < list.size(); i++)
        {
            Case c = list.get(i);
            if(!estVisite.get(c) && getDistance(c) < distanceMin)
            {
                distanceMin = getDistance(c);
                res = c;
            }
        }
        return res;
    }                 
    
    /**
     * Opérateur qui calcule la distance depuis une case avec un parcour en largeur.
     * @param depart case de départ.
     */ 
    @Override
    public void calculerDistancesDepuis(Case depart) 
    {
        initialisation(depart);
        Case caseLaPlusProche = getCaseLaPlusProche();
        while(caseLaPlusProche != null)
        {
            estVisite.put(caseLaPlusProche, Boolean.TRUE);
            ArrayList<Case> voisins = caseLaPlusProche.getVoisins();
            for(int i = 0; i < voisins.size(); i++)
            {
                relachement(caseLaPlusProche, voisins.get(i));
            }
            caseLaPlusProche = getCaseLaPlusProche();
        }
    }

    /**
     * Opérateur qui détermine le plus court chemin.
     * @param arrivee case d'Objetif de déplacement.
     * @return 
     */
    @Override
    public ArrayList<TypeMouvement> getChemin(Case arrivee) 
    {
        Case caseEnCour = arrivee;
        ArrayList<TypeMouvement> res = new ArrayList<>();
        
        if(this.getDistance(caseEnCour) != null)
        {
            while(this.getDistance(caseEnCour) > 0 )
            {
                Case casePrecedente = this.predecesseur.get(caseEnCour);
                res.add(casePrecedente.getMouvementPourAller(caseEnCour));
                caseEnCour = casePrecedente;
            }
        }
        Collections.reverse(res);
        return res;
    }
    
    
}
