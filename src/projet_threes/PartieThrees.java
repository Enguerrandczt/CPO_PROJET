/*
PartieThrees permet de lancer le jeu Threes dans la console
 */
package projet_threes;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Evan1204
 */
public class PartieThrees {

    PlateauDeJeu plateau;
    int nbCoups;

    /**
     * Constructeur Prend la taille du plateau en paramètre et initialise le
     * plateau de jeu avec cette taille.
     *
     * @param taillePlateau
     */
    public PartieThrees(int taillePlateau) {
        plateau = new PlateauDeJeu(taillePlateau);
        this.nbCoups = nbCoups;
    }

    /**
     * initialiserPartie Initialise une nouvelle partie en générant deux tuiles
     * sur le plateau avec les valeurs 1 et 2 à des positions aléatoires.
     */
    public void initialiserPartie() {
        Random random = new Random();
        plateau.Générer_Un_Deux_Trois(random.nextInt(3), random.nextInt(3), 1);
        plateau.Générer_Un_Deux_Trois(random.nextInt(3), random.nextInt(3), 2);
    }

    /**
     * LancerPartie affiche un message de bienvenue, initialise une nouvelle
     * partie en appelant la méthode initialiserPartie(), et affiche l'état
     * initial du plateau de jeu.
     */
    public void LancerPartie() {
        System.out.println("Bienvenue sur THREEEEEES !\n");
        initialiserPartie();
        System.out.println(plateau);

    }
}
