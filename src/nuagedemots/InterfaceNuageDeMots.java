/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuagedemots;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.random;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jacka
 */
public class InterfaceNuageDeMots extends javax.swing.JFrame {
    
    Nuage nuageDeMots;
    boolean test = true;
    Corpus c;
    ArrayList<Point> listePointsSpirale; 
    
    public InterfaceNuageDeMots() {
        c = new Corpus("Seconde Guerre Mondiale.txt");
        nuageDeMots = new Nuage(c,1100,900);
        listePointsSpirale = nuageDeMots.listePointsSpirale(550, 450, 450, 15);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        variableFreqMin = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        choixCouleur = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        selectedMin = new javax.swing.JSpinner();
        selectedMax = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        choixAffichage = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Lancer Nuage");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Fréquence Min");

        choixCouleur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Noir", "Bleu", "Vert", "Rouge", "Aleatoire" }));
        choixCouleur.setSelectedIndex(1);
        choixCouleur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choixCouleurActionPerformed(evt);
            }
        });

        jLabel2.setText("Couleur");

        selectedMin.setValue(15);

        selectedMax.setToolTipText("");
        selectedMax.setName(""); // NOI18N
        selectedMax.setValue(70);

        jLabel3.setText("Taille Min");

        jLabel4.setText("Taille Max");

        jLabel5.setText("Affichage");

        choixAffichage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Aleatoire" }));
        choixAffichage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choixAffichageActionPerformed(evt);
            }
        });

        jTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mot", "Fréquence"
            }
        ));
        jScrollPane4.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(variableFreqMin, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(choixCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(choixAffichage, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(selectedMax, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(selectedMin, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(variableFreqMin, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectedMin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectedMax, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(choixCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(choixAffichage, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        ajouterMotsJTable();
        
        if(choixCouleur.getSelectedIndex() == 0){
            nuageDeMots.changerTailleMotsEtCouleur((int) selectedMin.getValue(), (int) selectedMax.getValue(), "NOIR");
        }
        else if(choixCouleur.getSelectedIndex() == 1){
            nuageDeMots.changerTailleMotsEtCouleur((int) selectedMin.getValue(), (int) selectedMax.getValue(), "BLEU");
        }
        else if(choixCouleur.getSelectedIndex() == 2){
            nuageDeMots.changerTailleMotsEtCouleur((int) selectedMin.getValue(), (int) selectedMax.getValue(), "VERT");
        }
        else if(choixCouleur.getSelectedIndex() == 3){
            nuageDeMots.changerTailleMotsEtCouleur((int) selectedMin.getValue(), (int) selectedMax.getValue(), "ROUGE");
        } else 
            nuageDeMots.changerTailleMotsAvecCouleursAleatoire((int) selectedMin.getValue(), (int) selectedMax.getValue());
        
        nuageDeMots.getG2D().clearRect(0,0,1100,900);
        nuageDeMots.setFreqMin((int) variableFreqMin.getValue());
        
        if (choixAffichage.getSelectedIndex() == 0)
            nuageDeMots.afficherCorpus(listePointsSpirale);
        else if(choixAffichage.getSelectedIndex() == 1)
            nuageDeMots.afficherCorpusAleatoirement(listePointsSpirale);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void choixCouleurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choixCouleurActionPerformed
                // TODO add your handling code here:
    }//GEN-LAST:event_choixCouleurActionPerformed

    private void choixAffichageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choixAffichageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_choixAffichageActionPerformed

    public void ajouterMotsJTable(){                                            //Fonction qui gère le JTable (tableau mots et fréquences)
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        ArrayList<Mot> listeMots = c.getListeMot();
        Object colonne[] = new Object[2];
        for (int i = 0; i<listeMots.size(); i++){
            colonne[0] = listeMots.get(i).getMot();
            colonne[1] = listeMots.get(i).getFrequence();
            model.addRow(colonne);
        }
    }
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
            java.util.logging.Logger.getLogger(InterfaceNuageDeMots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceNuageDeMots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceNuageDeMots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceNuageDeMots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceNuageDeMots().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox choixAffichage;
    private javax.swing.JComboBox choixCouleur;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner selectedMax;
    private javax.swing.JSpinner selectedMin;
    private javax.swing.JSpinner variableFreqMin;
    // End of variables declaration//GEN-END:variables
}
