/*
La classe Tuile permet de représenter une tuile dans Threes où chaque 
tuile a une valeur qui peut être initialement 0, 1, ou 2.
 */
package projet_threes;

import java.util.Random;

/**
 *
 * @author Evan1204
 */
import java.util.Random;

public class Tuile {

    public int value;

    /**
     * Constructeur Initialise la valeur de la tuile à 0 lors de la création
     * d'une nouvelle instance.
     */
    public Tuile() {
        this.value = 0;
    }

    /**
     * getValue retourne la valeur actuelle de la tuile.
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * setValue modifie la valeur de la tuile en fonction de la valeur passée en
     * paramètre.
     *
     * @param Value
     */
    public void setValue(int Value) {
        value = Value;
    }

    /**
     * TuileVide Retourne 0.
     *
     * @return
     */
    public int TuileVide() {
        return 0;
    }

    /**
     * toString renvoie une représentation textuelle de la tuile (Si la valeur
     * est 1, elle renvoie "1", si la valeur est 2, elle renvoie "2", sinon,
     * elle renvoie la valeur sous forme de chaîne).
     *
     * @return
     */
    @Override
    public String toString() {
        if (value == 1) {
            return "1";
        } else if (value == 2) {
            return "2";
        }
        return String.valueOf(value); // Retourner la valeur pour toute autre situation
    }

    /**
     * Génère aléatoirement une valeur pour la tuile (1 ou 2).
     *
     * @return
     */
    public int activerTuile() {
        Random nbAlea = new Random();
        int n = nbAlea.nextInt(101);
        if (n >= 50) {
            value = 1;
        }
        if (n < 50) {
            value = 2;
        }
        return value;
    }
}
