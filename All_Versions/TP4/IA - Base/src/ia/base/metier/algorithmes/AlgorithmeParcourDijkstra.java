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
 *
 * @author Olivier
 */
public class AlgorithmeParcourDijkstra extends AlgorithmeCalculDistance
{
     private HashMap<Case, Boolean> estVisite = new HashMap<>();
     private HashMap<Case, Case> predecesseur = new HashMap<>();
     private int infini;
    
    public AlgorithmeParcourDijkstra(Carte carte) 
    {
        super(carte);
        this.infini = 1 + (carte.getTaille() * carte.getTaille() * 16);
    }

     private int coutMouvementvers(Case destination)
    {
        if(destination.estAccessible() == false) return infini;
        //if(destination.getObjet() != null && destination.getObjet().estRecoltable() == true) return destination.getObjet().coutRecolte() + 1;
        return 1;
    }
     
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
    
    private void relachement(Case a, Case b)
    {
        if(getDistance(b) > getDistance(a) + coutMouvementvers(b))
        {
            setDistance(b, getDistance(a) + coutMouvementvers(b));
            predecesseur.put(b, a);
        }
    }
    
    
    
    private Case getCaseLaPlusProche()
    {
        int distanceMin = this.infini;
        Case res = null;
        List<Case> list = new ArrayList<>(super.getCarte().getCases());
        
        for(int i = 0; i < list.size(); i++){
            Case c = list.get(i);
            if(estVisite.get(c) == false && getDistance(c) < distanceMin){
                distanceMin = getDistance(c);
                res = c;
            }
        }
        return res;
    } 
    
    @Override
    public void calculerDistancesDepuis(Case depart) {
        initialisation(depart);
        Case caseLaPlusProche = getCaseLaPlusProche();
        while(caseLaPlusProche != null){
            estVisite.put(caseLaPlusProche, Boolean.TRUE);
            ArrayList<Case> voisins = caseLaPlusProche.getVoisins();
            for(int i = 0; i < voisins.size(); i++){
                relachement(caseLaPlusProche, voisins.get(i));
            }
            caseLaPlusProche = getCaseLaPlusProche();
        }
    }

    @Override
    public ArrayList<TypeMouvement> getChemin(Case arrivee) {
        Case caseEnCour = arrivee;
        ArrayList<TypeMouvement> res = new ArrayList<>();
        
        if(this.getDistance(caseEnCour) != null){
            while(this.getDistance(caseEnCour) > 0 ){
                Case casePrecedente = this.predecesseur.get(caseEnCour);
                res.add(casePrecedente.getMouvementPourAller(caseEnCour));
                caseEnCour = casePrecedente;
            }
        }
        Collections.reverse(res);
        return res;
    }
    
}
