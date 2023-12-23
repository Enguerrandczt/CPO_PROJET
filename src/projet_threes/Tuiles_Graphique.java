/*
Tuiles_Graphique est utilisée pour représenter graphiquement une tuile dans l'interface
graphique de Threes.
 */
package projet_threes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author Evan1204
 */
public class Tuiles_Graphique extends JButton {

    Tuile TuileAssociee;
    int largeur;
    int longueur;

    /**
     * Constructeur Il prend en paramètre une Tuile, une largeur et une longueur
     * pour initialiser l'objet et configure l'apparence de la tuile (couleur,
     * caractère de texte, bordure).
     *
     * @param TuileAssociee
     * @param largeur
     * @param longueur
     */
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

    /**
     * paintComponent prend en charge le dessin de la tuile en fonction de sa
     * valeur (couleur du fond et la valeur de la tuile). La valeur de la tuile
     * est dessinée au centre de la tuile graphique avec une couleur de texte
     * appropriée.
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        int w = this.getWidth();
        int h = this.getHeight();

        int valeur = TuileAssociee.getValue();
        Color couleur;

        // Détermine la couleur en fonction de la valeur de la tuile
        switch (valeur) {
            case 1:
                couleur = Color.decode("#0000FF");
                break;
            case 2:
                couleur = Color.decode("#FF0000");
                break;
            default:
                couleur = (valeur == 0) ? Color.gray : Color.white;
                break;
        }

        // Définit la couleur pour le remplissage du rectangle
        g.setColor(couleur.darker());
        g.fillRect(2, 2, w - 4, h - 4);

        // Convertit la valeur en texte
        String valeurText = (valeur == 0) ? "" : String.valueOf(valeur);

        // Définit la couleur pour le texte (blanc pour les couleurs sombres, noir pour les couleurs claires)
        Color textColor = (couleur.equals(Color.black) || couleur.equals(Color.gray)) ? Color.white : Color.black;
        g.setColor(textColor);

        // Dessine la valeur au centre du rectangle si la valeur est différente de 0
        if (valeur != 0) {
            int xText = w / 2 - g.getFontMetrics().stringWidth(valeurText) / 2;
            int yText = h / 2 + g.getFontMetrics().getAscent() / 2;
            g.drawString(valeurText, xText, yText);
        }
    }
}
