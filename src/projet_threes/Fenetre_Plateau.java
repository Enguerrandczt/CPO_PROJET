/*
Fenêtre_de_Jeu est une interface graphique pour afficher le plateau de jeu de Threes.
 */
package projet_threes;

import java.awt.GridLayout;
import java.util.Random;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Evan1204
 */
public class Fenetre_Plateau extends javax.swing.JFrame {

    PlateauDeJeu plateau;
    private int compteurTouches = 0;
    int x;
    int y;
    private int taillePlateau;
    private PlateauDeJeu plateauPrecedent;
    private boolean grilleNABougeApres4Touches = false;

    /**
     * Creates new form Fenetre_Plateau
     */
    public Fenetre_Plateau() {
        initComponents();

        JLabel backgroundLabel = new JLabel();
        String imagePath = "musique\\FOND.png";
        backgroundLabel.setIcon(new ImageIcon(imagePath));
        getContentPane().add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Rien.setLayout(new GridLayout(1, 1));
        getContentPane().add(Rien, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 720, 1, 1));

        MusiqueMaestro player = new MusiqueMaestro();
        String filePath = "musique\\La-7ème-cible-_La_-Thème.wav";
        player.play(filePath);
        player.setVolume(0.1f);
        this.taillePlateau = 4;
        getContentPane().add(Panel_plateau, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 226, 368, 336));
        this.pack();
        this.revalidate();
        this.plateau = new PlateauDeJeu(taillePlateau);
        initialiserPartie();
        Panel_plateau.setLayout(new GridLayout(taillePlateau, taillePlateau));
        for (int x = 0; x < taillePlateau; x++) {
            for (int y = 0; y < taillePlateau; y++) {
                Tuiles_Graphique La_Tuile = new Tuiles_Graphique(plateau.matriceTuiles[x][y], 36, 36);
                Panel_plateau.add(La_Tuile);
            }
        }
        plateauPrecedent = new PlateauDeJeu(taillePlateau);
        addKeyListener(new KeyAdapter() {
            boolean[] touchesPressees = new boolean[4];

            @Override
            public void keyPressed(KeyEvent e) {
                PlateauDeJeu plateauCopie = copierPlateau(plateau);

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_DOWN:
                        plateau.décaler_Ligne_Bas();
                        plateau.Générer_Opposé_Mouvement("bas");
                        break;
                    case KeyEvent.VK_UP:
                        plateau.décaler_Ligne_Haut();
                        plateau.Générer_Opposé_Mouvement("haut");
                        break;
                    case KeyEvent.VK_RIGHT:
                        plateau.décaler_Colonne_Droite();
                        plateau.Générer_Opposé_Mouvement("droite");
                        break;
                    case KeyEvent.VK_LEFT:
                        plateau.décaler_Colonne_Gauche();
                        plateau.Générer_Opposé_Mouvement("gauche");
                        break;
                }

                PlateauDeJeu plateauApresMouvement = copierPlateau(plateau);
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    touchesPressees[0] = true;
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    touchesPressees[1] = true;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    touchesPressees[2] = true;
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    touchesPressees[3] = true;
                }

                // Vérification des mouvements après les quatre touches spécifiques
                if (toutesTouchesPressees(touchesPressees)) {
                    if (grilleNAPasChange(plateauCopie, plateauApresMouvement)) {
                        Terminus nouvelleFenetre2 = new Terminus();
                        nouvelleFenetre2.setVisible(true);
                        player.stop();
                    }
                    // Réinitialisation
                    touchesPressees = new boolean[4];
                }

                plateauPrecedent = copierPlateau(plateau); // Mise à jour du plateau précédent
                repaint();
            }
        });
        setFocusable(true);

    }

    /**
     * prend un tableau de booléens représentant les touches et renvoie true si
     * toutes les touches sont pressées, sinon false.
     */
    private boolean toutesTouchesPressees(boolean[] touches) {
        for (boolean touchePressee : touches) {
            if (!touchePressee) {
                return false;
            }
        }
        return true;
    }

    /**
     * grilleNAPasChange utilise la méthode estIdentique de la classe
     * PlateauDeJeu pour comparer si les deux plateaux sont identiques, et
     * renvoie true si les plateaux sont identiques, indiquant qu'aucun
     * changement n'a eu lieu.
     */
    private boolean grilleNAPasChange(PlateauDeJeu avant, PlateauDeJeu apres) {
        return avant.estIdentique(apres);
    }

    /**
     * initialiserPartie initialise une nouvelle partie du jeu en utilisant un
     * objet Random pour générer les positions aléatoires des 1 et des 2 sur le
     * plateau.
     */
    public void initialiserPartie() {
        Random random = new Random();
        plateau.Générer_Un_Deux_Trois(random.nextInt(3), random.nextInt(3), 1);
        plateau.Générer_Un_Deux_Trois(random.nextInt(3), random.nextInt(3), 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_plateau = new javax.swing.JPanel();
        Rien = new javax.swing.JPanel();
        Game_rules = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_plateau.setBackground(new java.awt.Color(255, 255, 255));
        Panel_plateau.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Panel_plateau, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 240));
        getContentPane().add(Rien, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, -1, -1));

        Game_rules.setText("jButton1");
        Game_rules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Game_rulesActionPerformed(evt);
            }
        });
        getContentPane().add(Game_rules, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Game_rulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Game_rulesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Game_rulesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Plateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Plateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Plateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Plateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fenetre_Plateau().setVisible(true);

            }
        });
    }

    private PlateauDeJeu copierPlateau(PlateauDeJeu plateauOriginal) {
        PlateauDeJeu copiePlateau = new PlateauDeJeu(taillePlateau);
        for (int x = 0; x < taillePlateau; x++) {
            for (int y = 0; y < taillePlateau; y++) {
                copiePlateau.matriceTuiles[x][y].setValue(plateauOriginal.matriceTuiles[x][y].getValue());
            }
        }
        return copiePlateau;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Game_rules;
    private javax.swing.JPanel Panel_plateau;
    private javax.swing.JPanel Rien;
    // End of variables declaration//GEN-END:variables
}
