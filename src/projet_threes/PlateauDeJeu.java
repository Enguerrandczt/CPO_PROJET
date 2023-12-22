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


public void Générer_Un_Deux_Trois(int Ligne, int Colonne, int value) {

    matriceTuiles[Ligne][Colonne].setValue(value);
}
    
 public void Générer_Opposé_Mouvement(String direction) {
    Random random = new Random();
    int value = random.nextInt(3) + 1; // Génère aléatoirement 1, 2 ou 3

    int row, col;

    switch (direction) {
        case "bas":
            row = 0;
            col = random.nextInt(TaillePlateau);
            if (matriceTuiles[row][col].getValue() == 0) {
                matriceTuiles[row][col].setValue(value);
            }
            break;
        case "haut":
            row = TaillePlateau - 1;
            col = random.nextInt(TaillePlateau);
            if (matriceTuiles[row][col].getValue() == 0) {
                matriceTuiles[row][col].setValue(value);
            }
            break;
        case "droite":
            row = random.nextInt(TaillePlateau);
            col = 0;
            if (matriceTuiles[row][col].getValue() == 0) {
                matriceTuiles[row][col].setValue(value);
            }
            break;
        case "gauche":
            row = random.nextInt(TaillePlateau);
            col = TaillePlateau - 1;
            if (matriceTuiles[row][col].getValue() == 0) {
                matriceTuiles[row][col].setValue(value);
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
                
                if (matriceTuiles[x - 1][y].getValue() == matriceTuiles[x][y].getValue() && matriceTuiles[x - 1][y].getValue() !=2 && matriceTuiles[x][y].getValue() !=2 && matriceTuiles[x - 1][y].getValue() !=1 && matriceTuiles[x - 1][y].getValue() !=1) {
                    matriceTuiles[x][y].setValue(2 * matriceTuiles[x - 1][y].getValue());
                    matriceTuiles[x - 1][y].setValue(0);
                    
                } else { 
                    
                if ( (matriceTuiles[x - 1][y].getValue() == 1 && matriceTuiles[x][y].getValue() == 2) || (matriceTuiles[x - 1][y].getValue() == 2 && matriceTuiles[x][y].getValue() == 1) ) {
                    matriceTuiles[x][y].setValue(3);
                    matriceTuiles[x - 1][y].setValue(0);
     
            }
        }
    }
    }
    }
    }

    public void décaler_Ligne_Haut() {
    for (int y = 0; y < TaillePlateau; y++) {
        for (int x = 0; x<TaillePlateau-1; x++) {
            if (matriceTuiles[x][y].getValue() == 0) {
                // Si la case est vide, déplacer la case supérieure vers le bas
                if (matriceTuiles[x+1][y].getValue() != 0) {
                    matriceTuiles[x][y].setValue(matriceTuiles[x+1][y].getValue());
                    matriceTuiles[x+1][y].setValue(0);
                }
            } else {
                // Si la case contient une tuile, essayer de fusionner avec la case supérieure
                if (matriceTuiles[x+1][y].getValue() == matriceTuiles[x][y].getValue() && matriceTuiles[x + 1][y].getValue() !=2 && matriceTuiles[x][y].getValue() !=2 && matriceTuiles[x + 1][y].getValue() !=1 && matriceTuiles[x + 1][y].getValue() !=1) {
                    matriceTuiles[x][y].setValue(2 * matriceTuiles[x+1][y].getValue());
                    matriceTuiles[x+1][y].setValue(0);
                    
                } else {
                    
                 if (matriceTuiles[x+1][y].getValue() == 1 & matriceTuiles[x][y].getValue() == 2 || matriceTuiles[x+1][y].getValue() == 2 & matriceTuiles[x][y].getValue() == 1 ) {
                    matriceTuiles[x][y].setValue(3);
                    matriceTuiles[x+1][y].setValue(0);
                }
            }
        }
    }
}
    }
    
public void décaler_Colonne_Droite() {
    for (int y = 0; y < TaillePlateau; y++) {
        for (int x = TaillePlateau - 1; x >= 0; x--) {
            if (matriceTuiles[y][x].getValue() == 0) {
                if (x > 0 && matriceTuiles[y][x-1].getValue() != 0) {
                    matriceTuiles[y][x].setValue(matriceTuiles[y][x-1].getValue());
                    matriceTuiles[y][x-1].setValue(0);
                }
            } else {
                if (x > 0 && matriceTuiles[y][x-1].getValue() == matriceTuiles[y][x].getValue() &&
                        matriceTuiles[y][x-1].getValue() != 2 && matriceTuiles[y][x].getValue() != 2 &&
                        matriceTuiles[y][x-1].getValue() != 1 && matriceTuiles[y][x].getValue() != 1) {
                    matriceTuiles[y][x].setValue(2 * matriceTuiles[y][x-1].getValue());
                    matriceTuiles[y][x-1].setValue(0);
                } else if (x > 0 && (matriceTuiles[y][x-1].getValue() == 1 && matriceTuiles[y][x].getValue() == 2 ||
                        matriceTuiles[y][x-1].getValue() == 2 && matriceTuiles[y][x].getValue() == 1)) {
                    matriceTuiles[y][x].setValue(3);
                    matriceTuiles[y][x-1].setValue(0);
                }
            }
        }
    }
}

    public void décaler_Colonne_Gauche() {
    for (int y = 0; y < TaillePlateau; y++) {
        for (int x = 0; x<TaillePlateau-1 ; x++) {
            if (matriceTuiles[y][x].getValue() == 0) {
                // Si la case est vide, déplacer la case supérieure vers le bas
                if (matriceTuiles[y][x+1].getValue() != 0) {
                    matriceTuiles[y][x].setValue(matriceTuiles[y][x+1].getValue());
                    matriceTuiles[y][x+1].setValue(0);
                }
            } else {
                // Si la case contient une tuile, essayer de fusionner avec la case supérieure
                if (matriceTuiles[y][x+1].getValue() == matriceTuiles[y][x].getValue() && matriceTuiles[y][x+1].getValue() !=2 && matriceTuiles[y][x].getValue() !=2 && matriceTuiles[y][x+1].getValue() !=1 && matriceTuiles[y][x+1].getValue() !=1) {
                    matriceTuiles[y][x].setValue(2 * matriceTuiles[y][x+1].getValue());
                    matriceTuiles[y][x+1].setValue(0);
                    
                } else {
                    
                if (matriceTuiles[y][x+1].getValue() == 1 & matriceTuiles[y][x].getValue() == 2 || matriceTuiles[y][x+1].getValue() == 2 & matriceTuiles[y][x].getValue() == 1 ) {
                    matriceTuiles[y][x].setValue(3);
                    matriceTuiles[y][x+1].setValue(0);
                }
            }
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

public boolean estIdentique(PlateauDeJeu autrePlateau) {
    for (int x = 0; x < TaillePlateau; x++) {
        for (int y = 0; y < TaillePlateau; y++) {
            if (matriceTuiles[x][y].getValue() != autrePlateau.matriceTuiles[x][y].getValue()) {
                return false; 
            }
        }
    }
    return true; 
}

public boolean estBloque() {
    for (int i = 0; i < TaillePlateau; i++) {
        Tuile[][] copieMatrice = new Tuile[TaillePlateau][TaillePlateau];
        for (int x = 0; x < TaillePlateau; x++) {
            for (int y = 0; y < TaillePlateau; y++) {
                copieMatrice[x][y] = new Tuile(); 
                copieMatrice[x][y].setValue(matriceTuiles[x][y].getValue()); 
            }
        }

        PlateauDeJeu copiePlateau = new PlateauDeJeu(TaillePlateau);
        copiePlateau.matriceTuiles = copieMatrice;
        copiePlateau.TaillePlateau = TaillePlateau;

        switch (i) {
            case 0:
                copiePlateau.décaler_Ligne_Bas();
                break;
            case 1:
                copiePlateau.décaler_Ligne_Haut();
                break;
            case 2:
                copiePlateau.décaler_Colonne_Droite();
                break;
            case 3:
                copiePlateau.décaler_Colonne_Gauche();
                break;
        }

        if (!copiePlateau.estIdentique(this)) {
            return false;
        }
    }

    return true;
}
}