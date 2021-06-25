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
import java.util.Collection;
import java.util.Collections;
import static java.util.Collections.reverse;

/**
 * Classe qui gère le parcour en largeur de la map.
 * @author Olivier
 * @version 1.0
 */
public class ParcoursLargeur extends AlgorithmeCalculDistance
{
    /**
     * Constructeur du parcours ne largeur de la carte
     * @param carte Carte a parcourir.
     */
    public ParcoursLargeur(Carte carte) 
    {
        super(carte);
    }
    
    /**
     * Opérateur qui calcule la distance depuis une case avec un parcour en largeur.
     * @param depart case de départ.
     */ 
     @Override
    public void calculerDistancesDepuis(Case depart)
    {
        //Remise à zéro
        //initialiser une variable ”aTraiter” de type ArrayList<Case>
        ArrayList<Case>aTraiter = new ArrayList<>();
        //réinitialiser la HashMap distances
        this.reinitialisationDistance();
        
        //Initialisation
        //mettre ”depart” dans la liste ”aTraiter”
        aTraiter.add(depart);
        
        //mettre ”depart” à distance 0 dans ”distances”
        this.setDistance(depart,0);
        
        //Calcul
        //tant que ”aTraiter” n est pas vide
        while(!aTraiter.isEmpty())
        {
            //”caseEnCours” <− tête de la liste ”aTraiter” (élément enposition 0)
            //on enlève la tête de la liste ”aTraiter”
            Case CaseEnCours = aTraiter.get(0);
            aTraiter.remove(0);
            
            //pour tout voisin ”v” de ”caseEnCours”
            for(Case v : CaseEnCours.getVoisins())
            {
                 //si aucune distance n a déjà été calculée pour ”v”
                if(this.getDistance(v) == null)
                {   //si ”v” est accessible
                    if (v.estAccessible())
                    {   //mettre ”v” à une distance 1 de plus quecelle de ”caseEnCours”
                        //ajouter ”v” à la liste ”aTraiter”
                        this.setDistance(v, this.getDistance(CaseEnCours)+1);
                        aTraiter.add(v);
                    }
                }
             }
        }
    }

    /**
     * Opérateur qui return la séquence de mouvements à réaliser pour passer d’une case à une autre
     * @param arrivee Caese arrivee.
     * @return liste des mouvement a effectué
     */
    @Override
    public ArrayList<TypeMouvement> getChemin(Case arrivee) 
    {
        //Initialisatio
        ArrayList<TypeMouvement> resultat = new ArrayList<>();
        Case caseEnCours = arrivee;
   
        //Calcul
        //Si distance de ”caseEnCours” est non null
        if (getDistance(caseEnCours) != null)
        {   //Tant que distance de ”caseEnCours” > 0
            while(this.getDistance(caseEnCours) > 0)
            {
                
                for(Case casePrecedente : caseEnCours.getVoisins())
                {
                  if (getDistance(casePrecedente) != null && getDistance(casePrecedente)== getDistance(caseEnCours)-1)
                    {
                        resultat.add(casePrecedente.getMouvementPourAller(caseEnCours));
                        //On met ce mouvement dans la liste ”resultat”.
                        caseEnCours = casePrecedente;
                    }
                  
                  
                }
              
            }  
    }
        Collections.reverse(resultat);
     return resultat;
   }
}

