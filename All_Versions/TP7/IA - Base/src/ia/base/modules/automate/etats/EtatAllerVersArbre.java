/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.modules.automate.etats;

import ia.base.metier.actions.Action;
import ia.base.metier.actions.FabriqueAction;
import ia.base.metier.actions.TypeActionRecolte;
import ia.base.metier.algorithmes.Dijkstra;
import ia.base.metier.carte.Carte;
import ia.base.metier.carte.cases.Case;
import ia.base.metier.carte.objets.TypeRessource;
import ia.base.modules.automate.Automate;
import ia.base.modules.automate.Etat;
import java.util.ArrayList;

/**
 *
 * @author Olivier
 */
public class EtatAllerVersArbre extends Etat
{
    private boolean arbreTrouve;
    public EtatAllerVersArbre(Automate automate) 
    {
        super(automate);
        this.arbreTrouve=false;
    }

    @Override
    public Etat transition() 
    {
        Etat TestEtatSuivant = null;
        if(arbreTrouve==false)
        {
            TestEtatSuivant = new EtatAllerDormir(this.getAutomate());   
        }
        else
        {
           TestEtatSuivant = new EtatCheckAction(this.getAutomate());
        }
        return TestEtatSuivant;
    }

    @Override
    public Action action() 
    {
      Carte carte = this.getAutomate().getModuleMemoire().getCarte();
      Dijkstra Algodijkstra = new Dijkstra(carte);
      Algodijkstra.calculerDistancesDepuis(this.getAutomate().getModuleMemoire().getCaseJoueur());
      Case CaseAvecAbreLaPlusProche = null;
      int DistanceMinimale = -1;
      ArrayList<Case> Listecases = new ArrayList<>(carte.getCases());
      
      
      for(int i = 0; i< Listecases.size(); i++)
      {
          Case c = Listecases.get(i);
          if(c.getObjet() != null && c.getObjet().getType() == TypeRessource.ARBRE)
          {
              if(CaseAvecAbreLaPlusProche  == null || Algodijkstra.getDistance(c) < DistanceMinimale)
              {
                 CaseAvecAbreLaPlusProche  = c;
                 DistanceMinimale = Algodijkstra.getDistance(c);
              }
          }
      }
 
      if(CaseAvecAbreLaPlusProche  != null)
      {
            this.seDeplacerEn(CaseAvecAbreLaPlusProche .GetCordonnee());
            if(!this.getAutomate().getListeDesActionARealiser().isEmpty())
            {
                Action action = this.getAutomate().getListeDesActionARealiser().get(this.getAutomate().getListeDesActionARealiser().size() - 1);
                this.getAutomate().getListeDesActionARealiser().remove(this.getAutomate().getListeDesActionARealiser().size() - 1);
                this.getAutomate().getListeDesActionARealiser().add(FabriqueAction.creerActionRecolte(TypeActionRecolte.COUPERARBRE, action.getDirection()));
                this.getAutomate().getListeDesActionARealiser().add(FabriqueAction.creerActionRecolte(TypeActionRecolte.COUPERARBRE, action.getDirection()));
                
            }
              arbreTrouve = true;
        }
      return null;
    }
    
}


  