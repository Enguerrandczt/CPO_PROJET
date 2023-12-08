/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_threes;

import java.util.Random;

/**
 *
 * @author Evan1204
 */
public class PlateauDeJeu {
    public Tuile [][] matriceTuiles;
    int nbLigne;
    int nbColonne;
    
    
    public PlateauDeJeu(int nbLigne, int nbColonne) {
        this.nbLigne = nbLigne;
        this.nbColonne = nbColonne;
        matriceTuiles = new Tuile[nbLigne][nbColonne];
        for (int x=0 ; x<matriceTuiles.length; x++){
            for (int y=0 ; y<matriceTuiles.length; y++){
                matriceTuiles[x][y] = new Tuile(); 
            }
        }
    }
    
    public void désactiverPlateau(){
        for (int x=0 ; x<matriceTuiles.length; x++){
            for (int y=0 ; y<matriceTuiles.length; y++){
            matriceTuiles[x][y].TuileVide(); 
            }
        }
    }
    
    public void créerColonne1(){
        Random nbAlea = new Random();

        // Générer un index aléatoire pour placer le 1
        int index1 = nbAlea.nextInt(nbColonne);

        // Placer le 1 dans la colonne
        for (int x = 0; x < nbLigne; x++) {
            for (int y = 0; y < nbColonne; y++) {
                if (y == index1) {
                    matriceTuiles[x][y].activerTuile();
                } else {
                    matriceTuiles[x][y].TuileVide();
                }
            }
        }
    }
    
    public void créerColonne2(){
        
    }
    
    
    //déplacer vertical droit
    
    //déplacer vertical gauche
    
    //déplacer horizontal haut
    
    //déplacer horizontal bas
    
    
}
