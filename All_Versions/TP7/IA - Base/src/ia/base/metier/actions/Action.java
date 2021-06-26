/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.actions;

import ia.base.metier.TypeMouvement;

/**
 * Classe de gestion des différantes action.
 * @author Olivier Sirugue
 * @version 1.0
 */
public abstract class Action 
{
    /*Opérateur qui return le message*/
    public abstract String getMessage();
    
    /*Opérateur qui return le type e l'action*/
    public abstract TypeAction getType();
    
    /*Opérateur qui return le type de mouvement*/
    public abstract TypeMouvement getDirection();
}

