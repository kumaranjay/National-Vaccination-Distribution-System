/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CDCSystemAdmin;

import Business.CDCSystem;
import Business.Vaccine.Vaccine;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Danisha
 */
public class ViewVaccineCDCJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewVaccineJPanel
     */
    private JPanel userProcessContainer;
    private CDCSystem system;
    private ManageVaccineJPanel mvjp;
    private Vaccine vaccine;
    public ViewVaccineCDCJPanel(JPanel userProcessContainer, CDCSystem system, ManageVaccineJPanel mvjp, Vaccine vaccine) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.system=system;
        this.mvjp=mvjp;
        this.vaccine=vaccine;
        nameJTextField.setText(vaccine.getVaccineName());
        contentsJTextField.setText(vaccine.getContents());
        diseasesJTextField.setText(vaccine.getDiseasesCured());
        sideeffectsJTextField.setText(vaccine.getSideeffects());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameJTextField = new javax.swing.JTextField();
        contentsJTextField = new javax.swing.JTextField();
        sideeffectsJTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        diseasesJTextField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameJTextField.setEditable(false);
        nameJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJTextFieldActionPerformed(evt);
            }
        });
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 355, -1));

        contentsJTextField.setEditable(false);
        contentsJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        contentsJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentsJTextFieldActionPerformed(evt);
            }
        });
        add(contentsJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 355, 82));

        sideeffectsJTextField.setEditable(false);
        sideeffectsJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sideeffectsJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sideeffectsJTextFieldActionPerformed(evt);
            }
        });
        add(sideeffectsJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, 355, 77));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Diseases cured");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, -1, -1));

        diseasesJTextField.setEditable(false);
        diseasesJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        diseasesJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diseasesJTextFieldActionPerformed(evt);
            }
        });
        add(diseasesJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 490, 355, 86));

        updateButton.setBackground(new java.awt.Color(255, 204, 204));
        updateButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 610, 98, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Side-effects");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("View Vaccine");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Vaccine Name");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Contents");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, -1));

        backButton.setBackground(new java.awt.Color(255, 204, 204));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 670, 98, -1));

        saveButton.setBackground(new java.awt.Color(255, 204, 204));
        saveButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 610, 98, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void nameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameJTextFieldActionPerformed

    private void contentsJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentsJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contentsJTextFieldActionPerformed

    private void sideeffectsJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sideeffectsJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sideeffectsJTextFieldActionPerformed

    private void diseasesJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diseasesJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diseasesJTextFieldActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
       saveButton.setEnabled(true);
       nameJTextField.setEditable(true);
       contentsJTextField.setEditable(true);
       diseasesJTextField.setEditable(true);
       sideeffectsJTextField.setEditable(true);
    }//GEN-LAST:event_updateButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout= (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
       String name= nameJTextField.getText();
       String contents= contentsJTextField.getText();
       String diseasesCured= diseasesJTextField.getText();
       String sideeffects= sideeffectsJTextField.getText();
       
       if(( !(name.isEmpty()) && !(contents.isEmpty()) && !(diseasesCured.isEmpty()) && !(sideeffects.isEmpty())))
       {
           Vaccine vaccine= new Vaccine();
           vaccine.setVaccineName(name);
           vaccine.setContents(contents);
           vaccine.setDiseasesCured(diseasesCured);
           vaccine.setSideeffects(sideeffects);
           
           JOptionPane.showMessageDialog(null, "Details Submitted");
       }
       
       else{
           JOptionPane.showMessageDialog(null, "Please enter all the details");
       }
       nameJTextField.setText(null);
       contentsJTextField.setText(null);
       diseasesJTextField.setText(null);
       sideeffectsJTextField.setText(null);
    }//GEN-LAST:event_saveButtonActionPerformed

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
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField sideeffectsJTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
