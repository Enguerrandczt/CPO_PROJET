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
    public int value;

    public Tuile() {
       this.value=0;
    }
    
    public int getValue() {
        return value;
    }
    public void setValue(int Value) {
        value = Value;
    }
    public int TuileVide() {
        return 0;
    }
    
@Override  
public String toString() {
    if (value == 1) {
        return "1";
    } else if (value == 2) {
        return "2";
    }
    return String.valueOf(value); // Retourner la valeur pour toute autre situation
}

public int activerTuile() {
    Random nbAlea = new Random();
    int n = nbAlea.nextInt(101);
    if (n >= 50) {
          value = 1;
      }if (n < 50){
          value = 2;
        }
        return value;
    }
}