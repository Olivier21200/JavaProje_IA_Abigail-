/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.base.metier.carte;

import ia.base.metier.TypeMouvement;
import ia.base.metier.carte.cases.Case;
import ia.base.metier.carte.cases.FabriqueCase;
import ia.base.metier.carte.cases.TypeCase;
import ia.base.metier.carte.objets.FabriqueObjet;
import java.util.HashMap;

/**
 * Classe qui représente la carte.
 * @author os586357
 * @version 1.0
 */
public class Carte  
{
    private int taille;
    private HashMap<Coordonnee,Case> cases;
    private Coordonnee CoordonneeDepart;
    
   public Carte(String messageRecu) 
   {
        this.cases = new HashMap<>();
        this.taille = (int) Math.sqrt(messageRecu.length());
        for (int i = 0; i < this.taille; i++) 
        {
            for (int j = 0; j < this.taille; j++) 
            {
                this.ajouterCase(new Coordonnee(i, j), messageRecu.charAt(j + this.taille * i));
            }
        }
        
        //Teste afficher dans la console les voisins de cases de coordonnées (0,0), (3,3) et (6,4). 
               /* System.out.println("Voisin de la case 0,0");
                
                for (int x=0; x<this.cases.get(new Coordonnee(0,0)).getVoisin().size();i++)) 
                {
                       System.out.println("--> voisin "+i);
                       System.out.println(this.cases.get(new Coordonnee(0,0).getVoisin().get(i).getCoordonné().toString()));
                }*/
        
        //Gestions des voisins
        //boucle pour la carte en ordonnée
        for(int i=0; i<this.taille; i++) 
        {
            //boucle pour la carte en abscisse 
            for(int j=0; j<this.taille; j++) 
            {
                Coordonnee cooCase = new Coordonnee(i,j);
                //boucle pour tout les mouvement
                for(TypeMouvement mouvement : TypeMouvement.values()) 
                {
                    Coordonnee cooVoisin = cooCase.getVoisin(mouvement) ;
                    //Test et ajout les voisins d'une case si elle en a.
                    if(this.cases.get(cooVoisin) != null) 
                    {
                        this.cases.get(cooCase).ajouterVoisin(this.cases.get(cooVoisin));
                    }
                }
            }
        }
        
        //Initialisation 
        Coordonnee AffichageObjetEscalier=null;
        
        //On récupe les coordonne de départ du joueur.
        AffichageObjetEscalier  = this.CoordonneeDepart;
        
       
        //On ajoute des escaliers avec comme coordonnée les cases voisines boottom, right et left du lieu de spawn
        Coordonnee c = this.CoordonneeDepart.getVoisin(TypeMouvement.BOTTOM);
        this.cases.get(c).setObjet(FabriqueObjet.creer( this.cases.get(c), 'S'));
        
        Coordonnee cr = c.getVoisin(TypeMouvement.RIGHT);
        this.cases.get(cr).setObjet(FabriqueObjet.creer( this.cases.get(cr), 'S'));

        Coordonnee cl = c.getVoisin(TypeMouvement.LEFT);
        this.cases.get(cl).setObjet(FabriqueObjet.creer( this.cases.get(cl), 'S'));

        this.afficheConsole();
   }
        
    
   private void ajouterCase(Coordonnee coordonnee, Character lettre) 
   {
        if (lettre == 'D') 
        {
            this.CoordonneeDepart = coordonnee;
        }
        Case cse = FabriqueCase.creer(coordonnee, lettre);
        cases.put(coordonnee, cse);
    }
    
      /**
      * Opérateur qui affiche sur la console la carte généré.
      */
      public void afficheConsole() 
      {
        for (int i = 0; i < this.taille; i++) 
        {
            for (int j = 0; j < this.taille; j++) 
            {
                String affichage = "E";
                Case caseEnCours = this.cases.get(new Coordonnee(i, j));
                if (caseEnCours.getType() == TypeCase.HERBE) {
                    if (caseEnCours.getObjet() == null) {
                        affichage = "H";
                    } else {
                        switch (caseEnCours.getObjet().getType()) 
                        {
                            case ARBRE:
                                affichage = "A";
                                break;
                            case MAISON:
                                affichage = "M";
                                break;
                            case ESCALIER:
                                affichage = "S";
                                break;
                            case DEPART:
                                affichage = "D";
                                break;
                        }
                    }
                } else if (caseEnCours.getType() == TypeCase.TERRE) 
                {
                    affichage = "T";
                }
                System.out.print(affichage);
            }
            System.out.println("");
        }
    }

      /**
       * Opérateur qui return les coordonnées de départ.
       * @return Coordonne ded départ
       */
    public Coordonnee getCDepart() 
    {
        return this.CoordonneeDepart;
    }
    
    /**
     * Opérateur qui retourn la case avec comme 
     * paramètre les coordonnées
     * @param coordonnee coordonnes d'une case
     * @return Case des coordonnées
     */
    public Case getCase(Coordonnee coordonnee)
    {
        return  this.cases.get(coordonnee);
    }
}




  