/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.modules.automate.etats;

import ia.base.metier.actions.Action;
import ia.base.metier.actions.FabriqueAction;
import ia.base.metier.algorithmes.Dijkstra;
import ia.base.metier.carte.Carte;
import ia.base.metier.carte.Coordonnee;
import ia.base.metier.carte.ressources.TypeRessource;
import ia.base.modules.automate.Automate;
import ia.base.modules.automate.Etat;

/**
 *
 * @author Olivier
 */
public class EtatAcheter extends Etat
{
    private boolean vaAcheter;
    
    /**
     * Constructeur de l'état avec l'automate
     * @param automate Automate.
     */
    public EtatAcheter(Automate automate) 
    {
        super(automate);
        this.vaAcheter=false;
    }

    /**
     * Opérateur qui return la transition de l'état
     * @return EtatSuivant.
     */
    @Override
    public Etat transition() 
    {
        Etat EtatSuivant = null;
        if(this.getAutomate().getModuleMemoire().hasStockMagasin()==false)
        {
            EtatSuivant = new EtatDemandeMagasin(this.getAutomate());
        }
        else if(vaAcheter==true)
            {
                EtatSuivant = new EtatCheckAction(this.getAutomate());
            }
            else
            {
                EtatSuivant = new EtatAllerDormir(this.getAutomate());  
            }
        
        return EtatSuivant;
           
    }

    /**
     *Opérateur qui return l'action réaliser par l'etat
     * @return Action réalisé. 
     */
    @Override
    public Action action() 
    {
       if(this.getAutomate().getModuleMemoire().hasStockMagasin())
        {
            if(this.getAutomate().getModuleMemoire().getQuantiteRessource(TypeRessource.GOLD) >=20 && this.getAutomate().getModuleMemoire().getStockMagasin(TypeRessource.PARSNIPSEED)>=1)
            {
            Carte carte = this.getAutomate().getModuleMemoire().getCarte();
            Dijkstra Algodijkstra = new Dijkstra(carte);
            
            Algodijkstra.calculerDistancesDepuis(this.getAutomate().getModuleMemoire().getCaseJoueur());
            
            Coordonnee CaseMagasinproche=null;
                int distance = -1;
                for (Coordonnee c : this.getAutomate().getModuleMemoire().getCarte().getCoordonneesMagasin()) 
                {
                    if (CaseMagasinproche == null || Algodijkstra.getDistance(this.getAutomate().getModuleMemoire().getCarte().getCase(c)) < distance) 
                    {
                        CaseMagasinproche = c; distance = Algodijkstra.getDistance(this.getAutomate().getModuleMemoire().getCarte().getCase(c)); 
                    } 
                }
                
                this.vaAcheter=true;
                this.seDeplacerEn(CaseMagasinproche);
                this.getAutomate().getListeDesActionARealiser().add(FabriqueAction.creerActionAcheter(TypeRessource.PARSNIPSEED));
            }
        }
        return null;
    }
     
    
}
