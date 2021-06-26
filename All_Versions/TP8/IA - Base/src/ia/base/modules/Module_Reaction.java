package ia.base.modules;

import ia.base.IA;

/**
 * Module en charge de la réaction de l'IA à un message du serveur
 * @author Matthieu
 */
public class Module_Reaction extends Module {

    /**
     * Constructeur
     * @param ia l'IA dont ce module fait partie
     */
    public Module_Reaction(IA ia) 
    {
        super(ia);
    }
    
  /**
    * Méthode principale de réaction à un message reçu
    * @param messageEnvoye dernier message envoyé par l'IA
    * @param messageRecu dermier message reçu par l'IA
   */
    public void reagirAuMessageRecu(String messageEnvoye, String messageRecu) 
    {
        switch(messageEnvoye) 
        {
            case "MAP": reactionCarte(messageRecu); 
               break;
            case "END" : this.getIA().arretDiscussion();
                break;
            case "STORE" : reactionMagasin(messageRecu);
                break;
        }
    }
    
    /**
    * Réaction à la réception de la carte
    * @param messageRecu la chaine de caractère représentant la carte
    */
    private void reactionCarte(String messageRecu) 
    {
        this.getIA().getModuleMemoire().genererCarte(messageRecu) ;
    }
    
    private void reactionMagasin(String messageRecu)
    {
       
        String[] Resultat = messageRecu.split("\\|");
        this.getIA().getModuleMemoire().genererStockMagasin(Integer.parseInt(Resultat [0]), Integer.parseInt(Resultat [1]));
    }

}
