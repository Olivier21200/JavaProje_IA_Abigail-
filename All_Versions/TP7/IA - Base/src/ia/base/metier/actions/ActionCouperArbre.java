/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.actions;

import ia.base.metier.TypeMouvement;
/**
 * Classe de gestion de l'action couper un arbre.
 * @author os586357
 * @version 1.0
 */
public class ActionCouperArbre extends Action
{
     private TypeMouvement TypeMouvement;
    
    public ActionCouperArbre(TypeMouvement mouvement)
    {
        this.TypeMouvement = mouvement;
    }
    
    @Override
    public String getMessage() 
    {
        String Resultat="";
        Resultat =  "HARVEST|" + this.TypeMouvement;
        
       return Resultat;
    }
    
    @Override
    public TypeAction getType() 
    {
        TypeAction Resultat = TypeAction.RECOLTE;
        
        return Resultat;
    }

    @Override
    public TypeMouvement getDirection() 
    {
        return this.TypeMouvement;
    }
    
    
    
}
