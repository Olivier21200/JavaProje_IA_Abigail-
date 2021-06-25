package ia.base.modules;

import ia.base.IA;
import ia.base.metier.carte.Carte;

/**
 * Module en charge de la mémorisation et de la restitution des informations obtenues
 * @author Matthieu
 */
public class Module_Memoire extends Module  {
    
    private Carte carte;
    /**
     * Constructeur
     * @param ia l'IA dont ce module fait partie
     */
    public Module_Memoire(IA ia) {
        super(ia);
    }
    
    public void genererCarte(String messageRecu)
    {
    
    }
    
    /**
     * Opérateur qui test si la carte a été créer
     * @return true si la carte a étét créée 
     */
    public boolean hasCarte()
    {
        boolean Resultat = false;
        if (this.carte != null)
        {
            Resultat=false;
        }
        else Resultat=true;
            
        return Resultat;
    }

}
