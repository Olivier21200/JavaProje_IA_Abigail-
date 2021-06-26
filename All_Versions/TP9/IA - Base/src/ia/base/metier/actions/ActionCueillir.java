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
public class ActionCueillir extends Action
{

    @Override
    public String getMessage() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TypeAction getType() 
    {
        return TypeAction.CUEILLIR;
    }

    @Override
    public TypeMouvement getDirection() 
    {
        return null;
    }

    @Override
    public TypeRessource getTypeRessource() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
