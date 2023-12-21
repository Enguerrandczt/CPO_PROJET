/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_threes;

import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Evan1204
 */
public class PartieThrees {
    PlateauDeJeu plateau;
    int nbCoups;

    public PartieThrees(int taillePlateau) {
        plateau = new PlateauDeJeu(taillePlateau);
        this.nbCoups = nbCoups;
    }

    public void initialiserPartie(){
        Random random = new Random();
        plateau.Générer_Un_Deux_Trois(random.nextInt(3),random.nextInt(3),1);
        plateau.Générer_Un_Deux_Trois(random.nextInt(3),random.nextInt(3),2);
        
    }

    public void LancerPartie() {
     
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue sur THREEEEEES !\n");
        initialiserPartie();
        System.out.println(plateau);
      
}
}

