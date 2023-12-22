/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_threes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author Evan1204
 */
public class Tuiles_Graphique extends JButton {

    Tuile TuileAssociee;
    int largeur;
    int longueur;

    public Tuiles_Graphique(Tuile TuileAssociee, int largeur, int longueur) {
        this.TuileAssociee = TuileAssociee;
        this.largeur = largeur;
        this.longueur = longueur;

        
        setBorder(null);
        
        // Créez une bordure personnalisée avec une couleur gris foncé
        Border bordureGrisFonce = BorderFactory.createLineBorder(Color.darkGray);

        // Appliquez cette bordure à votre bouton
        setBorder(bordureGrisFonce);
        
        // Ajoutez du code pour changer la police ici
        Font policeGrandeGras = getFont().deriveFont(Font.BOLD, 35); // Exemple : style gras, taille 24
       
        // Appliquez cette police au bouton
        setFont(policeGrandeGras);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        int w = this.getWidth();
        int h = this.getHeight();

        int valeur = TuileAssociee.getValue();
        Color couleur;

        // Détermine la couleur en fonction de la valeur de la tuile
        switch (valeur) {
            case 1:
                couleur = Color.decode("#FFC0CB");
                break;
            case 2:
                couleur = Color.decode("#ADD8E6");
                break;
            case 0:
                couleur = Color.gray;
                break;
            default:
                couleur = Color.white;
                break;
        }

        // Définit la couleur pour le remplissage du rectangle
        g.setColor(couleur.darker());
        g.fillRect(2, 2, w - 2, h - 2);

        // Convertit la valeur en texte
        String valeurText = String.valueOf(valeur);

        // Définit la couleur pour le texte (blanc pour les couleurs sombres, noir pour les couleurs claires)
        Color textColor = (couleur.equals(Color.black) || couleur.equals(Color.gray)) ? Color.white : Color.black;
        g.setColor(textColor);

        // Dessine la valeur au centre du rectangle
        int xText = w / 2 - g.getFontMetrics().stringWidth(valeurText) / 2;
        int yText = h / 2 + g.getFontMetrics().getAscent() / 2;
        g.drawString(valeurText, xText, yText);
    }
}
