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
public class EtatInitial extends Etat
{
    /**
     * Constructeur de l'état avec l'automate
     * @param automate Automate.
     */
    public EtatInitial(Automate automate) 
    {
        super(automate);
    }

     /**
     * Opérateur qui return la transition de l'état
     * @return EtatSuivant.
     */
    @Override
    public Etat transition() 
    {
        EtatCheckCarte EtatIninialtToCheckCarte = new EtatCheckCarte(this.getAutomate());
        return EtatIninialtToCheckCarte;
    }

    @Override
    public Action action()
    {
       return null;
    }
    
}
