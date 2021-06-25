/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.actions;

import ia.base.metier.TypeMouvement;

/**
 * Classe de gestion des différantes action.
 * @author Olivier
 * @version 1.0
 */
public abstract class Action 
{
    public abstract String getMessage() ;
    public abstract TypeAction getType();
    public abstract TypeMouvement getDirection();
}

