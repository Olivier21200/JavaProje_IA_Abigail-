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
public class ActionArroser extends Action 
{

    @Override
    public String getMessage() 
    {
        String Resultat="WATER|";
       return Resultat;
    }

    @Override
    public TypeAction getType() 
    {
           TypeAction Resultat = TypeAction.ARROSER;
        
        return Resultat;
    }

    @Override
    public TypeMouvement getDirection() 
    {
        return null;
    }

    @Override
    public TypeRessource getTypeRessource() 
    {
        return null;
    }
    
}
