/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_threes;

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
        plateau.Générer_Un_Deux();
    }
    
    public void LancerPartie() {
        initialiserPartie();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue sur THREEEEEES !\n");
        System.out.println(plateau);
        plateau.décaler_Ligne_Bas();
        System.out.println(plateau);
//        while (plateau.cellulesToutesEteintes() == false) {
//            System.out.println("A toi de jouer ! que veux-tu modifier :\n1) Une Ligne ?\n2) Une Colonne ?\n3) Une diagonale Descendante ?\n4) Une Diagonale Montante ?");
//            int A_modifier = sc.nextInt();
//            if (A_modifier == 1) {
//                System.out.println("Quelle ligne veux-tu modifier ?");
//                int ligneL = sc.nextInt();
//                grille.activerLigneDeCellules(ligneL);
//                System.out.println(grille);
//                nbCoups++;
//            }else if (A_modifier == 2) {
//                System.out.println("Quelle colonne veux-tu modifier ?");
//                int colonneC = sc.nextInt();
//                grille.activerColonneDeCellules(colonneC);
//                System.out.println(grille);
//                nbCoups++;
//            }else if (A_modifier == 3) {
//                grille.activerDiagonaleDescendante();
//                System.out.println(grille);
//                nbCoups++;
//            }else{
//                grille.activerDiagonaleMontante();
//                System.out.println(grille);
//                nbCoups++;
//            }
//        }
//    }
//}
    }
    }

