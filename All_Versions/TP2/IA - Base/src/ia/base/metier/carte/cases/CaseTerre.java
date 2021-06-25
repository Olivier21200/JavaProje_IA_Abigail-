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
 * @version 1.0
 */
public class CaseTerre extends Case
{

    public CaseTerre(Coordonee cordonne) 
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
        return TypeCase.TERRE;
    }
    
    
    
}
