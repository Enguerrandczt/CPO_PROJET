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
    
    public void Génerer_Un_Deux() {
        Random nbAlea = new Random();
        // Générer un index aléatoire pour placer le 1
        int n = nbAlea.nextInt(1);

        if (n==0) {
            matriceTuiles[nbAlea.nextInt(4)][0].activerTuile();
            matriceTuiles[0][nbAlea.nextInt(4)].activerTuile();
        } else if (n==1) {
            matriceTuiles[nbAlea.nextInt(4)][4].activerTuile();
            matriceTuiles[4][nbAlea.nextInt(4)].activerTuile();
        }
    }
    
@Override
public String toString() {
    String PlateauDeJeu = "";
    PlateauDeJeu += "   | ";

    for (int j = 0; j < nbColonne; j++) {
        PlateauDeJeu = PlateauDeJeu + "" + j + " | ";
    }
    PlateauDeJeu = PlateauDeJeu + "\n";
    for (int j= 0; j <(nbColonne+1); j++) {
        PlateauDeJeu +="----";
}
    PlateauDeJeu = PlateauDeJeu + "\n";

    for (int i=0; i<nbLigne; i++) {
        PlateauDeJeu += " " + i + " | ";
        for (int j=0; j <nbColonne; j++) {
            PlateauDeJeu+= "" + matriceTuiles[i][j] + " | ";
        }
        PlateauDeJeu = PlateauDeJeu + "\n";

        for (int j=0; j<(nbColonne+1); j++) {
            PlateauDeJeu+= "----";
        }
        PlateauDeJeu += "\n";
    }
    return PlateauDeJeu;
    }
}
    
