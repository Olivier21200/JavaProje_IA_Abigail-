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
 *
 * @author os586357
 */
public class Automate 
{
    private Etat etatcourant;
    
    private Module_Decision ModuleDecision;
    private Module_Memoire ModuleMemoire;
    private ArrayList<Action> listeDesActionARealiser;

    public Automate(Module_Decision ModuleDecision) 
    {
        this.etatcourant = new EtatInitial(this);
        this.ModuleDecision = ModuleDecision;
        this.ModuleMemoire = null;
        this.listeDesActionARealiser =  new ArrayList<Action>();
    }

    public Module_Decision getModuleDecision() 
    {
        return this.ModuleDecision;
    }

    public Module_Memoire getModuleMemoire() 
    {
        return this.getModuleDecision().getIA().getModuleMemoire();
    }
  

    public ArrayList<Action> getListeDesActionARealiser() 
    {
        return this.listeDesActionARealiser;
    }

    public Action evoluer()
    {
        Action prochaineAction = null;

        while(prochaineAction == null)
        {
            etatcourant = etatcourant.transition();
            prochaineAction = etatcourant.action();
        }
        return prochaineAction;
    }
    
    
}
