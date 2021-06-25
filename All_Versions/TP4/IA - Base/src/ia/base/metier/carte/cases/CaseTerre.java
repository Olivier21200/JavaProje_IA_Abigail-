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
 * @version 1.0
 */
public class CaseTerre extends Case
{

    public CaseTerre(Coordonnee cordonne) 
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
    
    /**
     * Opérateur qui return si une case est accessible.
     * @return true si la case est de l'eau.
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
