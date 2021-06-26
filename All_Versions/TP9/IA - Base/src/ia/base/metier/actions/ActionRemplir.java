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
public class ActionRemplir extends Action
{
    private TypeMouvement direction;

    public ActionRemplir(TypeMouvement direction) 
    {
        this.direction = direction;
    }
    
    
    @Override
    public String getMessage() 
    {
        return "FILL|"+direction;
    }

    @Override
    public TypeAction getType() 
    {
        return TypeAction.REMPLIR;
    }

    @Override
    public TypeMouvement getDirection() 
    {
        return this.direction;
    }

    @Override
    public TypeRessource getTypeRessource() 
    {
        return TypeRessource.EAU;
    }
    
}
