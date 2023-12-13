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
    public void Générer_Un_Deux_Trois(String direction) {
    Random random = new Random();
    int value = random.nextInt(3) + 1; // Génère aléatoirement 1, 2 ou 3

    switch (direction) {
        case "haut":
            if (matriceTuiles[0][random.nextInt(TaillePlateau)].getValue() == 0) {
                matriceTuiles[0][random.nextInt(TaillePlateau)].setValue(value);
            }
            break;
        case "bas":
            if (matriceTuiles[TaillePlateau - 1][random.nextInt(TaillePlateau)].getValue() == 0) {
                matriceTuiles[TaillePlateau - 1][random.nextInt(TaillePlateau)].setValue(value);
            }
            break;
        case "gauche":
            if (matriceTuiles[random.nextInt(TaillePlateau)][0].getValue() == 0) {
                matriceTuiles[random.nextInt(TaillePlateau)][0].setValue(value);
            }
            break;
        case "droite":
            if (matriceTuiles[random.nextInt(TaillePlateau)][TaillePlateau - 1].getValue() == 0) {
                matriceTuiles[random.nextInt(TaillePlateau)][TaillePlateau - 1].setValue(value);
            }
            break;
        default:
            System.out.println("Direction invalide.");
            break;
    }
}

   
    public void décaler_Ligne_Bas() {
    for (int y = 0; y < TaillePlateau; y++) {
        for (int x = TaillePlateau - 1; x > 0; x--) {
            if (matriceTuiles[x][y].getValue() == 0) {
                // Si la case est vide, déplacer la case supérieure vers le bas
                if (matriceTuiles[x - 1][y].getValue() != 0) {
                    matriceTuiles[x][y].setValue(matriceTuiles[x - 1][y].getValue());
                    matriceTuiles[x - 1][y].setValue(0);
                }
            } else {
                // Si la case contient une tuile, essayer de fusionner avec la case supérieure
                if (matriceTuiles[x - 1][y].getValue() == matriceTuiles[x][y].getValue()) {
                    matriceTuiles[x][y].setValue(2 * matriceTuiles[x - 1][y].getValue());
                    matriceTuiles[x - 1][y].setValue(0);
                }
            }
        }
    }
    Générer_Un_Deux_Trois("haut");
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