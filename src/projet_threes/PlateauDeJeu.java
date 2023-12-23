/*
PlateauDeJeu représente le plateau du jeu Threes.
 */
package projet_threes;

import java.util.Random;

/**
 *
 * @author Evan1204
 */
public class PlateauDeJeu {

    public Tuile[][] matriceTuiles;
    int TaillePlateau;

    /**
     * Constructeur Initialise la matrice de tuiles en créant une nouvelle tuile
     * pour chaque emplacement de la matrice.
     *
     * @param TaillePlateau
     */
    public PlateauDeJeu(int TaillePlateau) {
        this.TaillePlateau = TaillePlateau;
        matriceTuiles = new Tuile[TaillePlateau][TaillePlateau];
        for (int x = 0; x < matriceTuiles.length; x++) {
            for (int y = 0; y < matriceTuiles.length; y++) {
                matriceTuiles[x][y] = new Tuile();
            }
        }
    }

    /**
     * désactiverPlateau définit la valeur de chaque tuile dans la matrice à 0
     * en appelant la méthode TuileVide().
     */
    public void désactiverPlateau() {
        for (int x = 0; x < matriceTuiles.length; x++) {
            for (int y = 0; y < matriceTuiles.length; y++) {
                matriceTuiles[x][y].TuileVide();
            }
        }
    }

    /**
     * Générer_Un_Deux_Trois génère une tuile avec une valeur spécifiée (1,2 ou
     * 3) à une position donnée (Ligne, Colonne) sur le plateau.
     *
     * @param Ligne
     * @param Colonne
     * @param value
     */
    public void Générer_Un_Deux_Trois(int Ligne, int Colonne, int value) {
        matriceTuiles[Ligne][Colonne].setValue(value);
    }

    /**
     * Générer_Opposé_Mouvement Génère une tuile avec une valeur aléatoire (1, 2
     * ou 3) dans une position opposée à la direction spécifiée.
     *
     * @param direction
     */
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

    /**
     * décaler_Ligne_Bas déplace les tuiles vers le bas dans chaque colonne de
     * la matrice, fusionne les tuiles adjacentes de même valeur, et si une
     * tuile de valeur 1 et une tuile de valeur 2 se rencontrent, elles les
     * fusionnent pour former une tuile de valeur 3.
     */
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

                    if (matriceTuiles[x - 1][y].getValue() == matriceTuiles[x][y].getValue() && matriceTuiles[x - 1][y].getValue() != 2 && matriceTuiles[x][y].getValue() != 2 && matriceTuiles[x - 1][y].getValue() != 1 && matriceTuiles[x - 1][y].getValue() != 1) {
                        matriceTuiles[x][y].setValue(2 * matriceTuiles[x - 1][y].getValue());
                        matriceTuiles[x - 1][y].setValue(0);

                    } else {

                        if ((matriceTuiles[x - 1][y].getValue() == 1 && matriceTuiles[x][y].getValue() == 2) || (matriceTuiles[x - 1][y].getValue() == 2 && matriceTuiles[x][y].getValue() == 1)) {
                            matriceTuiles[x][y].setValue(3);
                            matriceTuiles[x - 1][y].setValue(0);

                        }
                    }
                }
            }
        }
    }

    /**
     * décaler_Ligne_Haut Déplace les tuiles vers le bas dans chaque colonne de
     * la matrice, fusionne les tuiles adjacentes de même valeur, et sii une
     * tuile de valeur 1 et une tuile de valeur 2 se rencontrent, elles
     * fusionnent pour former une tuile de valeur 3.
     */
    public void décaler_Ligne_Haut() {
        for (int y = 0; y < TaillePlateau; y++) {
            for (int x = 0; x < TaillePlateau - 1; x++) {
                if (matriceTuiles[x][y].getValue() == 0) {
                    // Si la case est vide, déplacer la case supérieure vers le bas
                    if (matriceTuiles[x + 1][y].getValue() != 0) {
                        matriceTuiles[x][y].setValue(matriceTuiles[x + 1][y].getValue());
                        matriceTuiles[x + 1][y].setValue(0);
                    }
                } else {
                    // Si la case contient une tuile, essayer de fusionner avec la case supérieure
                    if (matriceTuiles[x + 1][y].getValue() == matriceTuiles[x][y].getValue() && matriceTuiles[x + 1][y].getValue() != 2 && matriceTuiles[x][y].getValue() != 2 && matriceTuiles[x + 1][y].getValue() != 1 && matriceTuiles[x + 1][y].getValue() != 1) {
                        matriceTuiles[x][y].setValue(2 * matriceTuiles[x + 1][y].getValue());
                        matriceTuiles[x + 1][y].setValue(0);

                    } else {

                        if (matriceTuiles[x + 1][y].getValue() == 1 & matriceTuiles[x][y].getValue() == 2 || matriceTuiles[x + 1][y].getValue() == 2 & matriceTuiles[x][y].getValue() == 1) {
                            matriceTuiles[x][y].setValue(3);
                            matriceTuiles[x + 1][y].setValue(0);
                        }
                    }
                }
            }
        }
    }

    /**
     * décaler_Colonne_Droite Déplace les tuiles vers la droite dans chaque
     * ligne de la matrice, fusionne les tuiles adjacentes de même valeur, et si
     * une tuile de valeur 1 et une tuile de valeur 2 se rencontrent, elles
     * fusionnent pour former une tuile de valeur 3.
     */
    public void décaler_Colonne_Droite() {
        for (int y = 0; y < TaillePlateau; y++) {
            for (int x = TaillePlateau - 1; x >= 0; x--) {
                if (matriceTuiles[y][x].getValue() == 0) {
                    if (x > 0 && matriceTuiles[y][x - 1].getValue() != 0) {
                        matriceTuiles[y][x].setValue(matriceTuiles[y][x - 1].getValue());
                        matriceTuiles[y][x - 1].setValue(0);
                    }
                } else {
                    if (x > 0 && matriceTuiles[y][x - 1].getValue() == matriceTuiles[y][x].getValue()
                            && matriceTuiles[y][x - 1].getValue() != 2 && matriceTuiles[y][x].getValue() != 2
                            && matriceTuiles[y][x - 1].getValue() != 1 && matriceTuiles[y][x].getValue() != 1) {
                        matriceTuiles[y][x].setValue(2 * matriceTuiles[y][x - 1].getValue());
                        matriceTuiles[y][x - 1].setValue(0);
                    } else if (x > 0 && (matriceTuiles[y][x - 1].getValue() == 1 && matriceTuiles[y][x].getValue() == 2
                            || matriceTuiles[y][x - 1].getValue() == 2 && matriceTuiles[y][x].getValue() == 1)) {
                        matriceTuiles[y][x].setValue(3);
                        matriceTuiles[y][x - 1].setValue(0);
                    }
                }
            }
        }
    }

    /**
     * écaler_Colonne_Gauche Déplace les tuiles vers la gauche dans chaque ligne
     * de la matrice, fusionne les tuiles adjacentes de même valeur, et si une
     * tuile de valeur 1 et une tuile de valeur 2 se rencontrent, elles
     * fusionnent pour former une tuile de valeur 3.
     */
    public void décaler_Colonne_Gauche() {
        for (int y = 0; y < TaillePlateau; y++) {
            for (int x = 0; x < TaillePlateau - 1; x++) {
                if (matriceTuiles[y][x].getValue() == 0) {
                    // Si la case est vide, déplacer la case supérieure vers le bas
                    if (matriceTuiles[y][x + 1].getValue() != 0) {
                        matriceTuiles[y][x].setValue(matriceTuiles[y][x + 1].getValue());
                        matriceTuiles[y][x + 1].setValue(0);
                    }
                } else {
                    // Si la case contient une tuile, essayer de fusionner avec la case supérieure
                    if (matriceTuiles[y][x + 1].getValue() == matriceTuiles[y][x].getValue() && matriceTuiles[y][x + 1].getValue() != 2 && matriceTuiles[y][x].getValue() != 2 && matriceTuiles[y][x + 1].getValue() != 1 && matriceTuiles[y][x + 1].getValue() != 1) {
                        matriceTuiles[y][x].setValue(2 * matriceTuiles[y][x + 1].getValue());
                        matriceTuiles[y][x + 1].setValue(0);

                    } else {

                        if (matriceTuiles[y][x + 1].getValue() == 1 & matriceTuiles[y][x].getValue() == 2 || matriceTuiles[y][x + 1].getValue() == 2 & matriceTuiles[y][x].getValue() == 1) {
                            matriceTuiles[y][x].setValue(3);
                            matriceTuiles[y][x + 1].setValue(0);
                        }
                    }
                }
            }
        }
    }

    /**
     * toString()génère une représentation textuelle du plateau de jeu, en
     * affichant les valeurs des tuiles dans la matrice.
     *
     * @return
     */
    @Override
    public String toString() {
        String PlateauDeJeu = "";
        PlateauDeJeu += "   | ";

        for (int j = 0; j < TaillePlateau; j++) {
            PlateauDeJeu = PlateauDeJeu + "" + j + " | ";
        }
        PlateauDeJeu = PlateauDeJeu + "\n";
        for (int j = 0; j < (TaillePlateau + 1); j++) {
            PlateauDeJeu += "----";
        }
        PlateauDeJeu = PlateauDeJeu + "\n";

        for (int i = 0; i < TaillePlateau; i++) {
            PlateauDeJeu += " " + i + " | ";
            for (int j = 0; j < TaillePlateau; j++) {
                PlateauDeJeu += "" + matriceTuiles[i][j] + " | ";
            }
            PlateauDeJeu = PlateauDeJeu + "\n";

            for (int j = 0; j < (TaillePlateau + 1); j++) {
                PlateauDeJeu += "----";
            }
            PlateauDeJeu += "\n";
        }
        return PlateauDeJeu;
    }

    /**
     * estIdentique Compare les valeurs de chaque tuile du plateau actuel avec
     * celles d'un autre plateau fourni en paramètre, et etourne true si les
     * plateaux sont identiques, sinon false.
     *
     * @param autrePlateau
     * @return
     */
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

    /**
     * estBloque Vérifie si le plateau de jeu est bloqué, c'est-à-dire s'il
     * n'est pas possible d'effectuer de nouveaux mouvements.
     *
     * @return
     */
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
