/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projet_threes;

import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 *
 * @author Evan1204
 */
public class Fenêtre_de_Jeu extends javax.swing.JFrame {
    PlateauDeJeu Tuile;
    PlateauDeJeu plateau; // Instance du plateau de jeu
    

    /**
     * Creates new form Fenêtre_de_Jeu
     */
    public Fenêtre_de_Jeu() {
        initComponents();
        int nbLignes = 4;
        int nbColonnes = 4;

        // Initialisation du plateau directement ici
        plateau = new PlateauDeJeu(nbLignes, nbColonnes);
        plateau.Génerer_Un_Deux();

        afficherPlateau();
    }
    private void afficherPlateau() {
        PanneauGrille.setLayout(new BorderLayout());

// Ajoutez votre composant en spécifiant la région à laquelle vous voulez l'attacher
getContentPane().add(PanneauGrille, BorderLayout.CENTER); // ou une autre région : NORTH, SOUTH, EAST, WEST

    PanneauGrille.setLayout(new GridLayout(plateau.nbLigne, plateau.nbColonne));
    
    for (int i = 0; i < plateau.nbLigne; i++) {
        for (int j = 0; j < plateau.nbColonne; j++) {
            Tuile tuile = plateau.matriceTuiles[i][j];
            CaseGraphique caseGraphique = new CaseGraphique(tuile, 36, 36);
            caseGraphique.setText(tuile.toString());
            
            PanneauGrille.add(caseGraphique);
        }
    }
    
    // Assurez-vous que cette ligne est toujours présente pour afficher le panneau
    getContentPane().add(PanneauGrille);
    
    this.pack();
    this.revalidate();
}





    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauGrille = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 500));
        setPreferredSize(new java.awt.Dimension(600, 440));

        PanneauGrille.setBackground(new java.awt.Color(153, 255, 153));
        PanneauGrille.setMaximumSize(new java.awt.Dimension(400, 600));
        PanneauGrille.setMinimumSize(new java.awt.Dimension(400, 600));
        PanneauGrille.setName(""); // NOI18N
        PanneauGrille.setPreferredSize(new java.awt.Dimension(600, 600));
        PanneauGrille.setRequestFocusEnabled(false);

        javax.swing.GroupLayout PanneauGrilleLayout = new javax.swing.GroupLayout(PanneauGrille);
        PanneauGrille.setLayout(PanneauGrilleLayout);
        PanneauGrilleLayout.setHorizontalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanneauGrilleLayout.setVerticalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauGrille, java.awt.BorderLayout.CENTER);

        jButton1.setText("jButton1");
        getContentPane().add(jButton1, java.awt.BorderLayout.PAGE_START);

        jButton2.setText("jButton2");
        getContentPane().add(jButton2, java.awt.BorderLayout.PAGE_END);

        jButton3.setText("jButton3");
        getContentPane().add(jButton3, java.awt.BorderLayout.LINE_END);

        jButton4.setText("jButton4");
        getContentPane().add(jButton4, java.awt.BorderLayout.LINE_START);

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
            java.util.logging.Logger.getLogger(Fenêtre_de_Jeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fenêtre_de_Jeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fenêtre_de_Jeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fenêtre_de_Jeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fenêtre_de_Jeu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanneauGrille;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    // End of variables declaration//GEN-END:variables
}
