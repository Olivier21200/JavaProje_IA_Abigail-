package ia.base.modules;

import ia.base.IA;

/**
 * Classe abstraite des différents modules de l'IA
 * @author Matthieu
 */
public abstract class Module 
{
    private IA ia;
    
    /**
     * Constructeur de module avec comme paramètre notre IA.
     * @param ia IA Game.
     */
    public Module(IA ia) 
    {
        this.ia = ia;
    }
    
    /**
     * Opérateur  qui return l'ia.
     * @return IA.
     */
    public IA getIA() 
    {
        return this.ia;
    }
    
}
