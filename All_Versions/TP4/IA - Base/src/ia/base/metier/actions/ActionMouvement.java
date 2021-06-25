/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.actions;

import ia.base.metier.TypeMouvement;

/**
 *
 * @author Olivier
 */
public class ActionMouvement extends Action
{
    private TypeMouvement typeMouvement;

    /**
     * Constructeur d'une actionmouvement.
     * @param typeMouvement type du mouvement.
     */
    public ActionMouvement(TypeMouvement typeMouvement) 
    {
        this.typeMouvement = typeMouvement;
    }
   
    /**
     * Opérateur qui return le mouvement.
     * @return Message.
     */
    @Override
    public String getMessage() 
    {
        String Resultat="";
        Resultat = "MOVE|"+String.valueOf(typeMouvement);
        
       return Resultat;
    }
    
    /**
     * Opérateur quib return le type d'action.
     * @return 
     */
    @Override
    public TypeAction getType() 
    {
        //Variable de sortie
        TypeAction Resultat = TypeAction.MOUVEMENT;
        
        return Resultat;
    }
    
    /**
     * Opérateur qui return le type de mouvement en fonction de la direction.
     * @return type de mouvement.
     */
    @Override
    public TypeMouvement getDirection() 
    {
        return typeMouvement;
    }
}
