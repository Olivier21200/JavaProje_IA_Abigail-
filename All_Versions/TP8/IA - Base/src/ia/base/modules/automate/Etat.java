/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.modules.automate;

import ia.base.metier.TypeMouvement;
import ia.base.metier.actions.Action;
import ia.base.metier.actions.FabriqueAction;
import ia.base.metier.algorithmes.AlgorithmeCalculDistance;
import ia.base.metier.algorithmes.Dijkstra;
import ia.base.metier.carte.Carte;
import ia.base.metier.carte.Coordonnee;
import ia.base.metier.carte.cases.Case;
import java.util.List;

/*
 * Classe qui représente un etat de l'automate.
 * @author Olivier Sirugue
 * @version 1.0
 */
public abstract class Etat 
{
    private Automate automate;

    /**
     * Constructeur de l'automate
     * @param automate Automate.
     */
    public Etat(Automate automate) 
    {
        this.automate = automate;
    }
    
    /*Opérateur qui return la transition de l'état*/
    public abstract Etat transition();
    
    /*Opérateur qui return l'action réaliser par l'etat*/
    public abstract Action action();
    
    /**
     * Opérateur qui return l'automate.
     * @return Automate.
     */
    protected Automate getAutomate()
    {
        return this.automate;
    }
    
    /**
     * Opérateur qui permet de ce déplacer à des coordonnees.
     * @param coordonnee Coordonnee de destination.
     */
    protected void seDeplacerEn(Coordonnee coordonnee)
    {
         System.out.println("--- Je veux aller en "+coordonnee+" ---");
        //On récupère la carte
        Carte carte = this.getAutomate().getModuleMemoire().getCarte();
        //On crée l'algo
        AlgorithmeCalculDistance algo = new Dijkstra(carte);
        //On récupère la case du joueur
        Case caseJoueur = this.getAutomate().getModuleMemoire().getCaseJoueur();
        //On lance les calculs de distance
        algo.calculerDistancesDepuis(caseJoueur);
        //On détermine la case de destination
        Case destination = carte.getCase(coordonnee);
        //On calcule le chemin
        List<TypeMouvement> listeMouvement = algo.getChemin(destination);
        //On crée les actions
        for(TypeMouvement typeMouvement : listeMouvement) 
        {
            this.getAutomate().getListeDesActionARealiser().add(FabriqueAction.creerMouvement(typeMouvement));
        }
    }
}
