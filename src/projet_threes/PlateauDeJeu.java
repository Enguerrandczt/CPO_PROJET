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
    int TaillePlateau;
    
    
    public PlateauDeJeu(int TaillePlateau) {
        this.TaillePlateau = TaillePlateau;
        matriceTuiles = new Tuile[TaillePlateau][TaillePlateau];
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
    
    public void Générer_Un_Deux() {
        Random nbAlea = new Random();
        Random random = new Random();
        int randomNumber = random.nextInt(2); // Donne soit 0 soit 1
        int result = (randomNumber == 0) ? 0 : 3;

        if (matriceTuiles[nbAlea.nextInt(4)][result].getValue() == 0) {
            matriceTuiles[nbAlea.nextInt(4)][result].activerTuile();
        }
        if (matriceTuiles[result][nbAlea.nextInt(4)].getValue() == 0) {
            matriceTuiles[result][nbAlea.nextInt(4)].activerTuile();
        }
    }
   
    public void décaler_Ligne_Bas() {
        for (int x = 0; x <TaillePlateau - 1; x++) {
            for (int y = 0; y <TaillePlateau; y++) {
                int a = matriceTuiles[x][y].getValue();
                int b = matriceTuiles[x+1][y].getValue();
                int c = matriceTuiles[x][y].TuileVide();
                int d = matriceTuiles[x+1][y].TuileVide();

                if (a == b) {
                    if (a != 2 && b != 1){
                        matriceTuiles[x][y].setValue(0);
                        matriceTuiles[x+1][y].setValue(2 * a);
                    } 
                } else if (a == 1 && b == 2 || a == 2 && b == 1) {
                    matriceTuiles[x][y].setValue(0);
                    matriceTuiles[x+1][y].setValue(3);
                }else if (a != d){
                    matriceTuiles[x][y].setValue(0);
                    matriceTuiles[x+1][y].setValue(a);
                }
            }
        }
    }
    
@Override
public String toString() {
    String PlateauDeJeu = "";
    PlateauDeJeu += "   | ";

    for (int j = 0; j < TaillePlateau; j++) {
        PlateauDeJeu = PlateauDeJeu + "" + j + " | ";
    }
    PlateauDeJeu = PlateauDeJeu + "\n";
    for (int j= 0; j <(TaillePlateau+1); j++) {
        PlateauDeJeu +="----";
}
    PlateauDeJeu = PlateauDeJeu + "\n";

    for (int i=0; i<TaillePlateau; i++) {
        PlateauDeJeu += " " + i + " | ";
        for (int j=0; j <TaillePlateau; j++) {
            PlateauDeJeu+= "" + matriceTuiles[i][j] + " | ";
        }
        PlateauDeJeu = PlateauDeJeu + "\n";

        for (int j=0; j<(TaillePlateau+1); j++) {
            PlateauDeJeu+= "----";
        }
        PlateauDeJeu += "\n";
    }
    return PlateauDeJeu;
    }
}


