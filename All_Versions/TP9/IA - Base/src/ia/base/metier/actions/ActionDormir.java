/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.actions;

import ia.base.metier.TypeMouvement;
import ia.base.metier.carte.ressources.TypeRessource;

/**
 * Classe de gestion de l'action dormir.
 * @author Olivier Sirugue
 * @version 1.0
 */
public class ActionDormir extends Action
{

    /**
     * Opérateur qui return le message de l'action.
     * @return Message action.
     */
    @Override
    public String getMessage() 
    {
        String Resultat=null;
        Resultat="SLEEP";
        
        return Resultat;
    }

    /**
     * Opérateur qui return le type de l'action
     * @return 
     */
    @Override
    public TypeAction getType() 
    {
       return TypeAction.ACTIONSTATIQUE; 
    }

    /**
     * Opérateur qui return la direction de l'action.
     * @return null pas de déplacement pour cette action.
     */
    @Override
    public TypeMouvement getDirection() 
    {
        return null;
    }
    
     /**
     * Fonction permettant de récupérer le type de ressource
     * @return le type de ressource
     */
    @Override
    public TypeRessource getTypeRessource() 
    {
       return null;
    }
    
}
