/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.modules.automate.etats;

import ia.base.metier.actions.Action;
import ia.base.metier.actions.FabriqueAction;
import ia.base.metier.actions.TypeAction;
import ia.base.metier.actions.TypeActionRecolte;
import ia.base.metier.carte.Coordonnee;
import ia.base.metier.carte.cases.Case;
import ia.base.metier.carte.objets.TypeRessource;
import ia.base.modules.automate.Automate;
import ia.base.modules.automate.Etat;

/**
 *
 * @author Olivier
 */
public class EtatRealiserAction extends ia.base.modules.automate.Etat
{

    public EtatRealiserAction(Automate automate) 
    {
        super(automate);
    }

    @Override
    public Etat transition() 
    {
        EtatCheckAction EtatRealiserActionToCheckAction = new EtatCheckAction(this.getAutomate());
        return EtatRealiserActionToCheckAction;
    }

    @Override
    public Action action() 
    {
       Action action = this.getAutomate().getListeDesActionARealiser().get(0);
        if (action.getType() == TypeAction.MOUVEMENT)
        {
            Coordonnee coordonneeDestination = this.getAutomate().getModuleMemoire().getJoueur().getCoordonnee().getVoisin(action.getDirection());
            Case caseDestination =this.getAutomate().getModuleMemoire().getCarte().getCase(coordonneeDestination);
            
            if(caseDestination.getObjet() != null && caseDestination.getObjet().getType()== TypeRessource.ARBRE)
            {
                this.getAutomate().getListeDesActionARealiser().add(0,FabriqueAction.creerActionRecolte(TypeActionRecolte.COUPERARBRE, action.getDirection()));
                this.getAutomate().getListeDesActionARealiser().add(0,FabriqueAction.creerActionRecolte(TypeActionRecolte.COUPERARBRE, action.getDirection()));
                
            }
        }
        action = this.getAutomate().getListeDesActionARealiser().get(0);
        this.getAutomate().getListeDesActionARealiser().remove(0);
        return action;
    }
    
}
