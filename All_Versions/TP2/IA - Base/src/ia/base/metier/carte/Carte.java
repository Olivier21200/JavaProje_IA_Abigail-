/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte;





import ia.base.metier.carte.cases.Case;
import ia.base.metier.carte.cases.FabriqueCase;
import static ia.base.metier.carte.cases.TypeCase.HERBE;
import static ia.base.metier.carte.cases.TypeCase.TERRE;
import static ia.base.metier.carte.objets.TypeRessource.ARBRE;
import static ia.base.metier.carte.objets.TypeRessource.DEPART;
import static ia.base.metier.carte.objets.TypeRessource.ESCALIER;
import static ia.base.metier.carte.objets.TypeRessource.MAISON;
import java.util.HashMap;

/**
 *
 * @author os586357
 * @version 1.0
 */
public class Carte extends Coordonee
{
    private int taille;
    private HashMap<Coordonee,Case> cases;
    
   public Carte(String messageRecu) 
   {
    this.cases = new HashMap<>() ;
    this.taille = (int) Math.sqrt(messageRecu.length()) ;
    for(int i=0 ;i<this.taille ;i++) {
    for(int j=0 ;j<this.taille ;j++) {
    this.ajouterCase(new Coordonee(i,j), messageRecu.charAt
    (j+this.taille*i)) ;
}
}
}
    
    
    private void ajouterCase(Coordonee coordonnee, Character lettre)
    {
        cases.put(coordonnee, FabriqueCase.creer(coordonnee,lettre));
    }
    
   public void afficheConsole() {
    for(int i=0 ;i<this.taille ;i++) {
    for(int j=0 ;j<this.taille ;j++) {
    String affichage = "E" ;
    Case caseEnCours = this.cases.get(new Coordonee(i,j)) ;
    if(caseEnCours.getType() == HERBE) {
    if(caseEnCours.getObjet() == null) {
    affichage = "H" ;
    }
    else {
    switch(caseEnCours.getObjet().getType()) {
    case ARBRE : affichage = "A" ; break ;
    case MAISON : affichage = "M" ; break ;
    case ESCALIER : affichage = "S" ; break ;
    case DEPART : affichage = "D" ; break ;
    }
}
}
else if(caseEnCours.getType() == TERRE) {
affichage = "T" ;
}
System.out.print(affichage) ;
}
System.out.println("") ;
}
}
}




  