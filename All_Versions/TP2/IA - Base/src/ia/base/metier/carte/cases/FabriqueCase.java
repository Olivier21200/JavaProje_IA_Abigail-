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
public class FabriqueCase 
{
    public static Case creer(Coordonee coordonnee, Character lettre)
    {
          Case Resultat = null;
         switch(lettre)
        {
            case 'H': Resultat= new CaseEau(coordonnee);
                  
            case 'E': Resultat= new CaseHerbe(coordonnee);
            
            case 'T': Resultat = new CaseTerre(coordonnee);           
        }
         return Resultat;
}    }
