/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte.cases;
import ia.base.metier.carte.Coordonnee;

/**
 * Claesse qui représente une classe Herbe.
 * @author Olivier Sirugue
 */
public class CaseHerbe extends Case
{
    /**
     * Constructeur d'une caseHerbe.
     * @param coordonnee Coordonne de création.
     */
    public CaseHerbe(Coordonnee coordonnee) 
    {
        super(coordonnee);
    }
    
    /**
     * Opérateur qui return le type de cace
     * @return typeCase Type de la case.
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
