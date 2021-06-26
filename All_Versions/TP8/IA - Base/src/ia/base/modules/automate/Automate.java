/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.modules.automate;

import ia.base.metier.actions.Action;
import ia.base.modules.Module_Decision;
import ia.base.modules.Module_Memoire;
import java.util.ArrayList;
import ia.base.modules.automate.etats.EtatInitial;
/*
 * Classe qui représente un automate.
 * @author Olivier Sirugue
 * @version 1.0
 */
public class Automate 
{
    private Etat etatcourant;
    private Module_Decision ModuleDecision;
    private ArrayList<Action> listeDesActionARealiser;

    public Automate(Module_Decision ModuleDecision) 
    {
        this.etatcourant = new EtatInitial(this);
        this.ModuleDecision = ModuleDecision;
        this.listeDesActionARealiser =  new ArrayList<Action>();
    }

    /**
     * Opérateur qui return le module décision.
     * @return   Module décision.
     */
    public Module_Decision getModuleDecision() 
    {
        return this.ModuleDecision;
    }

    /**
     * Opérateur qui return le module mémoire.
     * @return  Module memoire.
     */
    public Module_Memoire getModuleMemoire() 
    {
        return this.getModuleDecision().getIA().getModuleMemoire();
    }
  

    /**
     * Opérateur qui return la liste des actions à realiser.
     * @return Liste des actions.
     */
    public ArrayList<Action> getListeDesActionARealiser() 
    {
        return this.listeDesActionARealiser;
    }

    /**
     * Opérateur qui fais evoluer l'action de l'automate.
     * @return Nouvelle action automate.
     */
    public Action evoluer()
    {
        Action prochaineAction = null;

        while(prochaineAction == null)
        {
             etatcourant = etatcourant.transition();
             System.out.println(etatcourant);
            prochaineAction = etatcourant.action();
        }
        return prochaineAction;
    }
    
    
}
