/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte.cases;

import ia.base.metier.carte.Coordonnee;

/**
 *
 * @author os586357
 */
public class CaseEau extends Case
{
    
    public CaseEau(Coordonnee cordonne) 
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
        return TypeCase.EAU;
    }

    /**
     * Opérateur qui return si une case est accessible.
     * @return false si la case est de l'eau.
     */
    @Override
    public boolean estAccessible() 
    {
        boolean Resultat=false;
        return Resultat;
    }
    
}
