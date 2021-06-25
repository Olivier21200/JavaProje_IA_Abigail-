/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte.cases;

import ia.base.metier.carte.Coordonnee;
import ia.base.metier.carte.objets.FabriqueObjet;

 /* Classe de gestion de la création de case.
 * @author os586357
 * @version 1.0
 */
public class FabriqueCase 
{
    public static Case creer(Coordonnee coordonnee, Character lettre)
    {
          Case Resultat = null;
         switch(lettre)
        {
            case 'A': Resultat= new CaseHerbe(coordonnee);
            
            case 'H': Resultat= new CaseEau(coordonnee);
            
            case 'D': Resultat= new CaseEau(coordonnee);
           
            case 'M': Resultat= new CaseEau(coordonnee);
            
            case 'S': Resultat= new CaseEau(coordonnee);
                  
            case 'E': Resultat= new CaseEau(coordonnee);
            
            case 'T': Resultat = new CaseTerre(coordonnee);           
        }
         Resultat.setObjet(FabriqueObjet.creer(Resultat, lettre));
         return Resultat;
}    }



    
        


