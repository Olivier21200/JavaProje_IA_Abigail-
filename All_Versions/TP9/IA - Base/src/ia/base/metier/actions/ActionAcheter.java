/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.actions;

import ia.base.metier.TypeMouvement;
import ia.base.metier.carte.ressources.TypeRessource;

/*
 * Classe qui représente un l'action acheter.
 * @author Olivier Sirugue
 * @version 1.0
 */
public class ActionAcheter extends Action
{
    private TypeRessource typeRessource;

    /**
     * Opérateur qui return lemessage de la demande
     * @return Message.
     */
    public ActionAcheter(TypeRessource typeRessource) 
    {
        this.typeRessource = typeRessource;
    }
    
    /**
     * Opérateur qui return lemessage de la demande
     * @return Message.
     */
    @Override
    public String getMessage() 
    { 
       String Resultat="BUY|" + typeRessource + "|1";
       return Resultat;
    }
    
     /**
     * Opérateur qui return le type de mouvement en fonction de la direction.
     * @return type de mouvement.
     */
    @Override
    public TypeAction getType() 
    {
       TypeAction Resultat = TypeAction.ACHAT;
        
        return Resultat;
    }

    /**
     * Fonction permettant de renvoyer une direction pour ach
     * @return null
     */
    @Override
    public TypeMouvement getDirection() 
    {
        return null;
    }

    /**
     * Fonction permettant de récupérer le type de ressource
     * @return le type de ressource
     */
    @Override
    public TypeRessource getTypeRessource() 
    {
        return typeRessource;
    }
    
    
    
}
