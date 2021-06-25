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
public class CaseHerbe extends Case
{
    
    public CaseHerbe(Coordonnee cordonne) 
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

    /**
     Opérateur qui return si une case est accessible.
     * @return true si c'est case d’herbe ne contenant pas d’objet bloquant
     */
    @Override
    public boolean estAccessible() 
    {
        boolean Resultat=false;
        
        //Test si pas d'objet dans la case
       if (this.getObjet() == null)
       {
            Resultat=true;
       }
       
       //Test si l'objet est bloquant sur la case
       else if (!this.getObjet().estBloquant())
       {
           Resultat=true;
       }
       
       return Resultat;
    }
}
