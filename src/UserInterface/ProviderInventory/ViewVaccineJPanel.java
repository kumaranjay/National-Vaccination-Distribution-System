/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ProviderInventory;

import Business.Vaccine.Vaccine;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Danisha
 */
public class ViewVaccineJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewVaccineJPanel
     */
    private JPanel userProcessContainer;
    private Vaccine vaccine;
    public ViewVaccineJPanel(JPanel userProcessContainer, Vaccine vaccine) {
        initComponents();
        this.userProcessContainer= userProcessContainer;
        this.vaccine= vaccine;
        nameJTextField.setText(vaccine.getVaccineName());
        contentsJTextField.setText(vaccine.getContents());
        sideeffectsJTextField.setText(vaccine.getSideeffects());
        diseasesJTextField.setText(vaccine.getDiseasesCured());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        diseasesJTextField = new javax.swing.JTextField();
        sideeffectsJTextField = new javax.swing.JTextField();
        contentsJTextField = new javax.swing.JTextField();
        nameJTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        diseasesJTextField.setEditable(false);
        diseasesJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        diseasesJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diseasesJTextFieldActionPerformed(evt);
            }
        });
        add(diseasesJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, 355, 86));

        sideeffectsJTextField.setEditable(false);
        sideeffectsJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sideeffectsJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sideeffectsJTextFieldActionPerformed(evt);
            }
        });
        add(sideeffectsJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 355, 77));

        contentsJTextField.setEditable(false);
        contentsJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        contentsJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentsJTextFieldActionPerformed(evt);
            }
        });
        add(contentsJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 355, 82));

        nameJTextField.setEditable(false);
        nameJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJTextFieldActionPerformed(evt);
            }
        });
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 355, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Side-effects");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Contents");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Diseases cured");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Vaccine Name");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("View Vaccine");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, -1, -1));

        backButton.setBackground(new java.awt.Color(255, 204, 204));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 98, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void diseasesJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diseasesJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diseasesJTextFieldActionPerformed

    private void sideeffectsJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sideeffectsJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sideeffectsJTextFieldActionPerformed

    private void contentsJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentsJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contentsJTextFieldActionPerformed

    private void nameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameJTextFieldActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout= (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextField contentsJTextField;
    private javax.swing.JTextField diseasesJTextField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTextField sideeffectsJTextField;
    // End of variables declaration//GEN-END:variables
}
