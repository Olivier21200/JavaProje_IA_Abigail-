/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte.cases;

import ia.base.metier.carte.Coordonee;

/**
 *
 * @author os586357
 */
public class CaseHerbe extends Case
{
    
    public CaseHerbe(Coordonee cordonne) 
    {
        super(cordonne);
    }
    
    /**
     * return le type de lace
     * @return typeCase 
     */
    @Override
    public TypeCase getType() 
    {
        return TypeCase.HERBE;
    }
}
