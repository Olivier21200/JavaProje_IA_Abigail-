/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.actions;

import ia.base.metier.TypeMouvement;
import ia.base.metier.carte.ressources.TypeRessource;

/**
 *
 * @author os586357
 */
public class ActionPlanter extends Action
{
    private TypeRessource TypeGraine;

    
    public ActionPlanter(TypeRessource TypeGraine) 
    {
        this.TypeGraine = TypeGraine;
    }
    
    
    @Override
    public String getMessage() 
    {
       return "PLANT|"+TypeGraine;
    }

    @Override
    public TypeAction getType() 
    {
        return TypeAction.PLANTER;
    }

    @Override
    public TypeMouvement getDirection() 
    {
        return null;
    }

    @Override
    public TypeRessource getTypeRessource() 
    {
       return this.TypeGraine;
    }
    
}
