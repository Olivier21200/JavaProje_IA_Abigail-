/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.actions;

import ia.base.metier.TypeMouvement;
import ia.base.metier.carte.ressources.TypeRessource;
/**
 * Classe de gestion de l'action couper un arbre.
 * @author Olivier Sirugue
 * @version 1.0
 */
public class ActionCouperArbre extends Action
{
     private TypeMouvement TypeMouvement;
    
    public ActionCouperArbre(TypeMouvement mouvement)
    {
        this.TypeMouvement = mouvement;
    }
    
    /**
     * Opérateur qui return lemessage de la demande
     * @return Message.
     */
    @Override
    public String getMessage() 
    {
        String Resultat="";
        Resultat =  "HARVEST|" + this.TypeMouvement;
        
       return Resultat;
    }
    
     /**
     * Opérateur qui return le type de mouvement en fonction de la direction.
     * @return type de mouvement.
     */
    @Override
    public TypeAction getType() 
    {
        TypeAction Resultat = TypeAction.RECOLTE;
        
        return Resultat;
    }

    @Override
    public TypeMouvement getDirection() 
    {
        return this.TypeMouvement;
    }
    
     /**
     * Opérateur qui permet de récupérer le type de ressource
     * @return le type de ressource
     */
    @Override
    public TypeRessource getTypeRessource() 
    {
       return TypeRessource.BOIS;
    }
    
    
    
}
