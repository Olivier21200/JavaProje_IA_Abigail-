/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.actions;

import ia.base.metier.TypeMouvement;
import ia.base.metier.carte.ressources.TypeRessource;

/**
 * Classe de gestion des demande de mouvement.
 * @author Olivier Sirugue
 * @version 1.0
 */
public class ActionDemande extends Action
{

    private String message;

    /**
     * Constructeur d'une demande.
     * @param message message de la delmande.
     */
    public ActionDemande(String message) 
    {
        this.message = message;
    }
    
    /**
     * Opérateur qui return lemessage de la demande
     * @return Message.
     */
    @Override
    public String getMessage() 
    {
       return message;
    }

    /**
     * Opérateur quib return le type d'action.
     * @return 
     */
    @Override
    public TypeAction getType() 
    {
        //Variable de sortie
        TypeAction Resultat = TypeAction.DEMANDE;
        
        return Resultat;
        
    }

     /**
     * Opérateur qui return le type de mouvement en fonction de la direction.
     * @return type de mouvement.
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
