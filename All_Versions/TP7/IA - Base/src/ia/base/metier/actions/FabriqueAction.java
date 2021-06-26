/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.actions;

import ia.base.metier.TypeMouvement;

/**
 * Classe de gestions de la fabrication des actions.
 * @author Olivier Sirugue
 * @version 1.0
 */
public class FabriqueAction 
{
  /**
   * Opérateur de gestion de fabrication du type d'action 
   * en fonction du mouvement
   * @param mouvement Mouvement.
   * @return Action.
   */  
  public static Action creerMouvement(TypeMouvement mouvement)
    {
        //Variable de sortie.
       Action ActionMouvement = null;
       
        switch(mouvement)
        {       
            case LEFT : ActionMouvement = new ActionMouvement(TypeMouvement.LEFT);
            break;
                
            case RIGHT :ActionMouvement = new ActionMouvement(TypeMouvement.RIGHT);
            break;
            
            case BOTTOM : ActionMouvement = new ActionMouvement(TypeMouvement.BOTTOM);
            break;
                
            case TOP : ActionMouvement = new ActionMouvement(TypeMouvement.TOP);
            break;
        }
         return ActionMouvement;   
    }
    
    /**
     * Opérateur qui crer une demande en fonction du message
     * @param demande Demande.
     * @return Action créer.
     */
    public static Action creerDemande(TypeDemande demande)
    {
        //Variable de sortie
        Action DemandeAction = null;
        
        switch(demande)
        {
            case CARTE : DemandeAction= new ActionDemande("MAP");
            break;
        }
        
        return DemandeAction;
    }
    
    /**
     * Opérateur de creation d'action statique
     * @param type Action statique.
     * @return L'action créer.
     */
    public static Action creerActionStatique(TypeActionStatique type)
    {
        //Variable de sortie
        Action ActionStatique = null;
        
        switch(type)
        {
            case DORMIR: ActionStatique = new ActionDormir();
            break;
        }
        
        return ActionStatique;
    }
    
    /**
     * Opérateurqui créer une action de recolte en fonction de ça  direction et de son type.
     * @param type Type de l'action de recolte.
     * @param direction directtion du lieu de l'action
     * @return Creation de l'action de recolte.
     */
    public static Action creerActionRecolte(TypeActionRecolte type, TypeMouvement direction)
    {
        //Variable de sortie
        Action ActionRecolte = null;
        
      switch(type)
      {
            case COUPERARBRE: ActionRecolte = new ActionCouperArbre(direction);
                break;
                
            default: ActionRecolte =null;
                 break;
      }
      return ActionRecolte;
    }
}