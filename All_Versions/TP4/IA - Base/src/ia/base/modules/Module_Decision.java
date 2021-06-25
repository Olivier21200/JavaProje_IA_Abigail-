package ia.base.modules;

import ia.base.IA;

/**
 * Module en charge de la prise de décision
 * @author Matthieu
 */
public class Module_Decision extends Module {

    /**
     * Constructeur
     * @param ia l'IA dont ce module fait partie
     */
    public Module_Decision(IA ia) 
    {
        super(ia);
    }

    /**
     * Méthode principale de prise de décision
     * @param messageRecu dernier message reçu par l'IUA
     * @return le message à envoyer au serveur
     */
    public String determinerNouvelleAction(String messageRecu) {
        
        String StringSend = "";
        /* Random MouvementAlléatoire = new Random();
        
         switch(MouvementAlléatoire.nextInt(4))
            {
            case 0:
                 messageAEnvoyer = "MOVE | RIGHT";
             break;
             
             case 1:
                 messageAEnvoyer = "MOVE|BOTTOM";
             break;
        
            case 2:
                 messageAEnvoyer = "MOVE|LEFT";
             break;
        
            case 3:
                messageAEnvoyer = "MOVE|TOP";
             break;
         }*/
        
       
       if (this.getIA().getModuleMemoire().hasCarte() == true)
       {
           StringSend= "END";
           
       }
       else{
           StringSend = "MAP";
       }
       return StringSend;
        
    }
}
