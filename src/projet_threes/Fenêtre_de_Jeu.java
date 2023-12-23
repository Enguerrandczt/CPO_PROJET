/*
Fenêtre de jeu est utilisée pour créer une fenêtre de jeu pour Threes
 */
package projet_threes;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Evan1204
 */
public class Fenêtre_de_Jeu extends javax.swing.JFrame {
    private MusiqueMaestro player;

    /**
     * Creates new form Fenêtre_de_Jeu
     */
    public Fenêtre_de_Jeu() {
        initComponents();
        
        JLabel backgroundLabel = new JLabel();
        String imagePath = "musique\\acceuil.png";
        backgroundLabel.setIcon(new ImageIcon(imagePath));
        getContentPane().add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Rien.setLayout(new GridLayout(1, 1));
        getContentPane().add(Rien, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 720, 1, 1));

        player = new MusiqueMaestro();
        String filePath = "musique\\Jack-Zankowski-Happy-Wheels-_Main-theme_.wav";
        player.play(filePath);
        player.setVolume(0.02f);
        
        
        

        //Affiche un bouton facile vers la grille facile
//        Jouer.setLayout(new GridLayout(1, 1));
//        getContentPane().add(Jouer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 80, 40));
//        this.pack();
//        this.revalidate();
//
        JButton bouton_Jouer = new JButton("Play");
        ActionListener ecouteurClick1 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Fenetre_Plateau nouvelleFenetre = new Fenetre_Plateau();
                nouvelleFenetre.setVisible(true);
                player.stop(); //
                dispose();
            }
        };
        bouton_Jouer.addActionListener(ecouteurClick1);
        
    }

    /**
     * * This method is called from within the constructor to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        DEm = new javax.swing.JButton();
        Rien = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        DEm.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout RienLayout = new javax.swing.GroupLayout(Rien);
        Rien.setLayout(RienLayout);
        RienLayout.setHorizontalGroup(
            RienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );
        RienLayout.setVerticalGroup(
            RienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
        );

        getContentPane().add(Rien, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, -1));

        jButton1.setText("Play");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, -1, -1));

        jButton2.setText("Règles du jeu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 420, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        Fenetre_Plateau nouvelleFenetre = new Fenetre_Plateau();
                nouvelleFenetre.setVisible(true);
                player.stop(); //
                dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     Fenetre_Rules nouvelleFenetre = new Fenetre_Rules();
                nouvelleFenetre.setVisible(true);
                player.stop(); //
                dispose();   // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fenêtre_de_Jeu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DEm;
    private javax.swing.JPanel Rien;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
