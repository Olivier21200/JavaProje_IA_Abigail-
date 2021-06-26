/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte.cases;

import ia.base.metier.carte.Coordonnee;

/**
 * Claesse qui représente une classe eau.
 * @author Olivier Sirugue
 */
public class CaseEau extends Case
{
    /**
     * Constructeur d'une case eau.
     * @param coordonnee Coordonne de cration.
     */
    public CaseEau(Coordonnee coordonnee) 
    {
        super(coordonnee);
    }
    
    /**
     * Opérateur qui return le type de cace.
     * @return typeCase type de la case.
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
