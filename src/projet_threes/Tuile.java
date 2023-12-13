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
import java.util.Random;

public class Tuile {
    private int value;

    public Tuile() {
        this.value = 0;
    }

    public void activerTuile() {
        Random nbAlea = new Random();
        int n = nbAlea.nextInt(101);
        if (n >= 50) {
            value = 1;
        } else {
            value = 2;
        }
    }

    public void setValue(int value) {
        this.value = value;
    }

    // Retourne true si la tuile est vide, sinon false
    public int TuileVide() {
        return 0;
    }

    public int getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return (""+value);
    }   
}
//1 2 3 6 12 24 48 96 192 384 768  1536 3072