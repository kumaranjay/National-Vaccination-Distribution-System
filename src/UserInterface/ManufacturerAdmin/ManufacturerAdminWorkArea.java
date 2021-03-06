/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ManufacturerAdmin;

import Business.CDCSystem;
import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import UserInterface.ProviderAdmin.UpdatePersonalInfoJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Danisha
 */
public class ManufacturerAdminWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form ManufacturerAdminWorkArea
     */
    private JPanel userProcessContainer;
    private CDCSystem system;
    private DB4OUtil db4oUtil;
    private UserAccount account;
    private Enterprise enterprise;
    public ManufacturerAdminWorkArea(JPanel userProcessContainer, CDCSystem system, DB4OUtil db4oUtil, UserAccount account, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer= userProcessContainer;
        this.system= system;
        this.db4oUtil= db4oUtil;
        this.account= account;
        this.enterprise= enterprise;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ViewManufVaccinesJButton = new javax.swing.JButton();
        managePersonsButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        updatePersonalInfoButton2 = new javax.swing.JButton();
        manageIssueButton = new javax.swing.JButton();
        manageVaccineOrdersButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Manufacturer Admin Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 309, 40));

        ViewManufVaccinesJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ViewManufVaccinesJButton.setText("View Manufactured Vaccines");
        ViewManufVaccinesJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewManufVaccinesJButtonActionPerformed(evt);
            }
        });
        add(ViewManufVaccinesJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 245, -1));

        managePersonsButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        managePersonsButton.setText("Manage Persons");
        managePersonsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePersonsButtonActionPerformed(evt);
            }
        });
        add(managePersonsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 245, -1));

        logoutButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 245, -1));

        updatePersonalInfoButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updatePersonalInfoButton2.setText("Update Personal Info");
        updatePersonalInfoButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePersonalInfoButton2ActionPerformed(evt);
            }
        });
        add(updatePersonalInfoButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 245, -1));

        manageIssueButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manageIssueButton.setText("Manage Issue Reports");
        manageIssueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageIssueButtonActionPerformed(evt);
            }
        });
        add(manageIssueButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 245, -1));

        manageVaccineOrdersButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manageVaccineOrdersButton.setText("Manage Vaccine Orders");
        manageVaccineOrdersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageVaccineOrdersButtonActionPerformed(evt);
            }
        });
        add(manageVaccineOrdersButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 245, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void ViewManufVaccinesJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewManufVaccinesJButtonActionPerformed
        // TODO add your handling code here:
        ViewManufacturedVaccinesJPanel viewVaccinesManuf = new ViewManufacturedVaccinesJPanel(userProcessContainer, system, enterprise, account);
        userProcessContainer.add("ViewManufacturedVaccinesJPanel", viewVaccinesManuf);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_ViewManufVaccinesJButtonActionPerformed

    private void managePersonsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePersonsButtonActionPerformed
        // TODO add your handling code here:

        ManagePersonsManufacturerJPanel managePersonsManuf = new ManagePersonsManufacturerJPanel(userProcessContainer, system, enterprise, account);
        userProcessContainer.add("ManagePersonsManufacturerJPanel", managePersonsManuf);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_managePersonsButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        db4oUtil.storeSystem(system);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void updatePersonalInfoButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePersonalInfoButton2ActionPerformed
        // TODO add your handling code here:
        UpdatePersonalInfoJPanel updatePersonalInfoJPanel = new UpdatePersonalInfoJPanel(userProcessContainer, system, account);
        userProcessContainer.add("updatePersonalInfoJPanel", updatePersonalInfoJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_updatePersonalInfoButton2ActionPerformed

    private void manageIssueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageIssueButtonActionPerformed
        // TODO add your handling code here:
        ManageIssueJPanel manageIssue = new ManageIssueJPanel(userProcessContainer, system, enterprise, account);
        userProcessContainer.add("ManageIssueJPanel", manageIssue);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageIssueButtonActionPerformed

    private void manageVaccineOrdersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageVaccineOrdersButtonActionPerformed
        // TODO add your handling code here:
        ManageVaccineOrdersManufJPanel manageOrdersManuf = new ManageVaccineOrdersManufJPanel(userProcessContainer, system, enterprise, account);
        userProcessContainer.add("ManageVaccineOrdersManufJPanel", manageOrdersManuf);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageVaccineOrdersButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ViewManufVaccinesJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton manageIssueButton;
    private javax.swing.JButton managePersonsButton;
    private javax.swing.JButton manageVaccineOrdersButton;
    private javax.swing.JButton updatePersonalInfoButton2;
    // End of variables declaration//GEN-END:variables
}
