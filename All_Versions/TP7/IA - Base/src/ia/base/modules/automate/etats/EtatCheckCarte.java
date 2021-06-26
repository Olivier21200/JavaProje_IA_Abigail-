/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.modules.automate.etats;

import ia.base.metier.actions.Action;
import ia.base.modules.automate.Automate;
import ia.base.modules.automate.Etat;

/**
 *
 * @author Olivier
 */
public class EtatCheckCarte extends Etat
{

    public EtatCheckCarte(Automate automate) 
    {
        super(automate);
    }

    @Override
    public Etat transition() 
    {
        Etat TestEtatSuivant = null;
        if(this.getAutomate().getModuleMemoire().hasCarte())
        {
            TestEtatSuivant = new EtatCheckAction(this.getAutomate());
        }
        else
        {
            TestEtatSuivant = new EtatDemanderCarte(this.getAutomate());
        }
        return TestEtatSuivant;
    }

    @Override
    public Action action() 
    {
        return null;
    }
    
}
