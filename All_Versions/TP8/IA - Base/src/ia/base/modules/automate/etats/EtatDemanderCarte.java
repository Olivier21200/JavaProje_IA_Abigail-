/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.modules.automate.etats;

import ia.base.metier.actions.Action;
import ia.base.metier.actions.FabriqueAction;
import ia.base.metier.actions.TypeDemande;
import ia.base.modules.automate.Automate;
import ia.base.modules.automate.Etat;

/**
 *
 * @author Olivier
 */
public class EtatDemanderCarte extends Etat 
{
    /**
     * Constructeur de l'état avec l'automate
     * @param automate Automate.
     */
    public EtatDemanderCarte(Automate automate) 
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
        EtatCheckCarte EtatDemandeCarteToCheckCarte = new EtatCheckCarte(this.getAutomate());
        return EtatDemandeCarteToCheckCarte;
    }

    /**
     *Opérateur qui return l'action réaliser par l'etat
     * @return Action réalisé. 
     */
    @Override
    public Action action() 
    {
        return FabriqueAction.creerDemande(TypeDemande.CARTE);
    }
    
}
