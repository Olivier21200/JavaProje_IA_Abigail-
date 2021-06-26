/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte.cases;

import ia.base.metier.carte.Coordonnee;

/**
 * Claesse qui représente une classe Terre.
 * @author Olivier Sirugue
 */
public class CaseTerre extends Case
{

    /**
     * Constructeur d'une case terre.
     * @param coordonnee coordonne de création.
     */
    public CaseTerre(Coordonnee coordonnee) 
    {
        super(coordonnee);
    }

    /**
     * Opérateur qui return le type de cace
     * @return typeCase Type de a case.
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
