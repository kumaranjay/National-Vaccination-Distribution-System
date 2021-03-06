/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DistributorAdmin;

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
public class DistributorAdminWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form DistributorAdminWorkArea
     */
    private JPanel userProcessContainer;
    private CDCSystem system;
    private DB4OUtil db4oUtil;
    private UserAccount account;
    private Enterprise enterprise;
    public DistributorAdminWorkArea(JPanel userProcessContainer, CDCSystem system, DB4OUtil db4oUtil, UserAccount account, Enterprise enterprise) {
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

        updatePersonalInfoButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        manageOrderRequestButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        updatePersonalInfoButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updatePersonalInfoButton.setText("Update Personal Info");
        updatePersonalInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePersonalInfoButtonActionPerformed(evt);
            }
        });
        add(updatePersonalInfoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 245, -1));

        logoutButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 245, -1));

        manageOrderRequestButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manageOrderRequestButton.setText("Manage Order Requests");
        manageOrderRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrderRequestButtonActionPerformed(evt);
            }
        });
        add(manageOrderRequestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 245, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Distributor Admin Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 269, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void updatePersonalInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePersonalInfoButtonActionPerformed
        // TODO add your handling code here:
        UpdatePersonalInfoJPanel updatePersonalInfoJPanel = new UpdatePersonalInfoJPanel(userProcessContainer, system, account);
        userProcessContainer.add("updatePersonalInfoJPanel", updatePersonalInfoJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_updatePersonalInfoButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        db4oUtil.storeSystem(system);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_logoutButtonActionPerformed

    private void manageOrderRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrderRequestButtonActionPerformed
        // TODO add your handling code here:
        ManageOrdersDistributorJPanel manageOrdersDistributor = new ManageOrdersDistributorJPanel(userProcessContainer, system, account, enterprise);
        userProcessContainer.add("ManageOrdersJPanel", manageOrdersDistributor);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrderRequestButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton manageOrderRequestButton;
    private javax.swing.JButton updatePersonalInfoButton;
    // End of variables declaration//GEN-END:variables
}
