/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte.objets;

import ia.base.metier.carte.cases.Case;

/**
 * Classe de gestion de fabrication d'objet.
 * @author os586357
 * @version 1.0
 */
public class FabriqueObjet 
{
    public static Objet creer(Case position, Character lettre)
    {
         Objet Resultat =null;
         switch(lettre)
        {
            case 'M': Resultat= new ObjetMaison(position);
            break;
                  
            case 'D': Resultat= new ObjetDepart(position);
            break;
            
            case 'A': Resultat= new ObjetArbre(position);
            break;
            
            case 'S': Resultat= new ObjetEscalier(position);
            break;     
        }  
         return Resultat;
        
    }
}


    