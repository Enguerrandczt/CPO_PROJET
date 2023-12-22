/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projet_threes;

import java.awt.GridLayout;
import java.util.Random;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 *
 * @author Evan1204
 */
public class Fenetre_Plateau extends javax.swing.JFrame {
    PlateauDeJeu plateau;
    int x;
    int y;
    private int taillePlateau;
    /**
     * Creates new form Fenetre_Plateau
     */
    public Fenetre_Plateau() {
        initComponents();
        
        MusiqueMaestro player = new MusiqueMaestro();
        String filePath = "musique\\La-7ème-cible-_La_-Thème.wav"; 
        player.play(filePath);
        this.taillePlateau = 4;
        getContentPane().add(Panel_plateau, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 260, taillePlateau * 100, taillePlateau * 120));
        this.pack();
        this.revalidate();
        this.plateau = new PlateauDeJeu(taillePlateau);
        initialiserPartie();
        Panel_plateau.setLayout(new GridLayout(taillePlateau, taillePlateau));
        for (int x = 0; x < taillePlateau; x++) {
            for (int y = 0; y < taillePlateau; y++) {
                Tuiles_Graphique La_Tuile = new Tuiles_Graphique(plateau.matriceTuiles[x][y], 36, 36);
                Panel_plateau.add(La_Tuile); // ajout au Jpanel PanneauGrille
            }
        }
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    
                    plateau.décaler_Ligne_Bas();
                    plateau.Générer_Opposé_Mouvement("bas");
                    plateau.estBloque();
                    if (plateau.estBloque()==true) {
                    dispose();   
                    }
                   
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    
                    plateau.décaler_Ligne_Haut();
                    plateau.Générer_Opposé_Mouvement("haut");
                   
                    repaint();
                    plateau.estBloque();
                    if (plateau.estBloque()==true) {
                    dispose(); 
                    }
                    repaint();
                    
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    
                    plateau.décaler_Colonne_Droite();
                    plateau.Générer_Opposé_Mouvement("droite");
                    if (plateau.estBloque()==true) {
                    dispose(); 
                    }
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    
                    plateau.décaler_Colonne_Gauche();
                    plateau.Générer_Opposé_Mouvement("gauche");
                    if (plateau.estBloque()==true) {
                    dispose(); 
                    }
                    repaint();
                }
            }
        });
        setFocusable(true);
        
    }

    public void initialiserPartie(){
        Random random = new Random();
        plateau.Générer_Un_Deux_Trois(random.nextInt(3),random.nextInt(3),1);
        plateau.Générer_Un_Deux_Trois(random.nextInt(3),random.nextInt(3),2);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_plateau.setBackground(new java.awt.Color(255, 255, 255));
        Panel_plateau.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Panel_plateau, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_plateau;
    // End of variables declaration//GEN-END:variables
}
