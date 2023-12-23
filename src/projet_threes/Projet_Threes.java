/*
  _______ _                        
 |__   __| |                       
    | |  | |__  _ __ ___  ___  ___ 
    | |  | '_ \| '__/ _ \/ _ \/ __|
    | |  | | | | | |  __/  __/\__ \
    |_|  |_| |_|_|  \___|\___||___/
                                  
    CROUZET Enguerrand
    LEONARDI Lucas
    ROGIER Evan
    23/12/2023  
    TDC
 */
package projet_threes;

/**
 *
 * @author engue
 */
public class Projet_Threes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PartieThrees Partie1 = new PartieThrees(4);
        Partie1.LancerPartie();
        MusiqueMaestro audio = new MusiqueMaestro();
        audio.play("C:\\Users\\engue\\OneDrive\\Documents\\CPO_PROJET\\Projet_Threesaudio\\Jack Zankowski - Happy Wheels (Main theme).mp3");

    }
}
