/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DistributorInventory;

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

public class DistributorInventoryWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form DistributorInventoryWorkArea
     */
    private JPanel userProcessContainer;
    private CDCSystem system;
    private UserAccount account;
    private Enterprise enterprise;
    private DB4OUtil db4oUtil;
    public DistributorInventoryWorkArea(JPanel userProcessContainer, CDCSystem system, UserAccount account, Enterprise enterprise, DB4OUtil db4oUtil) {
        initComponents();
        this.userProcessContainer= userProcessContainer;
        this.system= system;
        this.account= account;
        this.enterprise= enterprise;
        this.db4oUtil= db4oUtil;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        updatePersonalInfoButton2 = new javax.swing.JButton();
        manageInventoryButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        manageDeliveryRequestsButton = new javax.swing.JButton();
        manageOrderRequestsButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        updatePersonalInfoButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updatePersonalInfoButton2.setText("Update Personal Info");
        updatePersonalInfoButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePersonalInfoButton2ActionPerformed(evt);
            }
        });
        add(updatePersonalInfoButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, 245, -1));

        manageInventoryButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manageInventoryButton.setText("Manage Inventory");
        manageInventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageInventoryButtonActionPerformed(evt);
            }
        });
        add(manageInventoryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 245, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Distributor Inventory Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 320, 40));

        logoutButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 245, -1));

        manageDeliveryRequestsButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manageDeliveryRequestsButton.setText("Manage Delivery Requests");
        manageDeliveryRequestsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageDeliveryRequestsButtonActionPerformed(evt);
            }
        });
        add(manageDeliveryRequestsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 245, -1));

        manageOrderRequestsButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manageOrderRequestsButton.setText("Manage Order Requests");
        manageOrderRequestsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrderRequestsButtonActionPerformed(evt);
            }
        });
        add(manageOrderRequestsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 245, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void updatePersonalInfoButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePersonalInfoButton2ActionPerformed
        // TODO add your handling code here:
        UpdatePersonalInfoJPanel updatePersonalInfoJPanel = new UpdatePersonalInfoJPanel(userProcessContainer, system, account);
        userProcessContainer.add("updatePersonalInfoJPanel", updatePersonalInfoJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_updatePersonalInfoButton2ActionPerformed

    private void manageInventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageInventoryButtonActionPerformed
        // TODO add your handling code here:
        ManageInventoryDistributorJPanel manageInventoryDistributor = new ManageInventoryDistributorJPanel(userProcessContainer, system, enterprise, account);
        userProcessContainer.add("ManageInventoryDistributorJPanel", manageInventoryDistributor);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageInventoryButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        db4oUtil.storeSystem(system);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void manageDeliveryRequestsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageDeliveryRequestsButtonActionPerformed
        // TODO add your handling code here:
        ManageDeliveryDistributorJPanel manageDeliveryDistributor = new ManageDeliveryDistributorJPanel(userProcessContainer, system, enterprise, account);
        userProcessContainer.add("ManageDeliveryDistributorJPanel", manageDeliveryDistributor);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageDeliveryRequestsButtonActionPerformed

    private void manageOrderRequestsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrderRequestsButtonActionPerformed
        // TODO add your handling code here:

        ManageOrderDistributorJPanel manageOrdersDistributor = new ManageOrderDistributorJPanel(userProcessContainer, system, enterprise, account);
        userProcessContainer.add("ManageOrdersDistributorJPanel", manageOrdersDistributor);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrderRequestsButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton manageDeliveryRequestsButton;
    private javax.swing.JButton manageInventoryButton;
    private javax.swing.JButton manageOrderRequestsButton;
    private javax.swing.JButton updatePersonalInfoButton2;
    // End of variables declaration//GEN-END:variables
}