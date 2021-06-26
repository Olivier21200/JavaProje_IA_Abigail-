/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.modules.automate.etats;

import ia.base.metier.actions.Action;
import ia.base.metier.actions.FabriqueAction;
import ia.base.metier.actions.TypeActionStatique;
import ia.base.modules.automate.Automate;
import ia.base.modules.automate.Etat;

/**
 *
 * @author Olivier
 */
public class EtatAllerDormir extends  Etat
{
    /**
     * Constructeur de l'état avec l'automate
     * @param automate Automate.
     */
    public EtatAllerDormir(Automate automate) 
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
       EtatCheckAction EtatAllerDormirToCheckAction = new EtatCheckAction(this.getAutomate());
       return EtatAllerDormirToCheckAction;
    }

    /**
     *Opérateur qui return l'action réaliser par l'etat
     * @return Action réalisé. 
     */
    @Override
    public Action action() 
    {
        this.seDeplacerEn(getAutomate().getModuleMemoire().getCarte().getCDepart());
        this.getAutomate().getListeDesActionARealiser().add(FabriqueAction.creerActionStatique(TypeActionStatique.DORMIR));
        return null;
    }
    
}
