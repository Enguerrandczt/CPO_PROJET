/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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
