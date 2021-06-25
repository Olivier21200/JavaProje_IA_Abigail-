/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte.cases;

import ia.base.metier.carte.Coordonnee;
import ia.base.metier.carte.objets.FabriqueObjet;

 /* Classe de gestion de la création de case.
 * @author Olivier Sirugue
 * @version 1.0
 */
public class FabriqueCase 
{
    /**
     * Opérateur qui fabrique des case.
     * @param coordonnee Coordonne de fabrication.
     * @param lettre Lettre(type de case).
     * @return Case créer.
     */
    public static Case creer(Coordonnee coordonnee, Character lettre)
    {
          Case Resultat = null;
         switch(lettre)
        {
            case 'A': Resultat= new CaseHerbe(coordonnee);
            break;
            
            case 'H': Resultat= new CaseHerbe(coordonnee);
            break;
            
            case 'D': Resultat= new CaseHerbe(coordonnee);
            break;
            
            case 'M': Resultat= new CaseHerbe(coordonnee);
            break;
            
            case 'S': Resultat= new CaseHerbe(coordonnee);
            break;
            
            case 'E': Resultat= new CaseEau(coordonnee);
            break;
            
            case 'T': Resultat = new CaseTerre(coordonnee);           
        }
         Resultat.setObjet(FabriqueObjet.creer(Resultat, lettre));
         return Resultat;
}    }
  
    
  