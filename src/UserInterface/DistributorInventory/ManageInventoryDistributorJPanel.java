/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DistributorInventory;

import Business.CDCSystem;
import Business.Enterprise.Enterprise;
import Business.Inventory.Inventory;
import Business.Organization.InventoryOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;
import UserInterface.ProviderInventory.ViewVaccineJPanel;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danisha
 */
public class ManageInventoryDistributorJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageInventoryDistributor
     */
    private JPanel userProcessContainer;
    private CDCSystem system;
    private UserAccount account;
    private Enterprise enterprise;
    private InventoryOrganization inventoryOrg;

    public ManageInventoryDistributorJPanel(JPanel userProcessContainer, CDCSystem system, Enterprise enterprise, UserAccount account) {
        initComponents();
        this.userProcessContainer= userProcessContainer;
        this.system= system;
        this.account= account;
        this.enterprise= enterprise;
        populate();
        populateCombo();
    }
public void populate() {
        DefaultTableModel dtm = (DefaultTableModel) vaccineJTable.getModel();
        dtm.setRowCount(0);
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization.getName().equals(Organization.Type.Inventory.getValue())) {
                inventoryOrg = (InventoryOrganization) organization;
                for (Inventory inventory : inventoryOrg.getInventoryDirectory().getInventoryList()) {
                    Object row[] = new Object[3];
                    row[0] = inventory;
                    row[1] = inventory.getVaccine();
                    row[2] = inventory.getQuantity();
                    dtm.addRow(row);
                }
            }
        }

    }

    public void populateCombo() {
        vaccineComboBox.removeAllItems();
        for (Vaccine vaccine : system.getVaccineDirectory().getVaccineList()) {
            vaccineComboBox.addItem(vaccine);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        unitPriceJTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vaccineJTable = new javax.swing.JTable();
        viewButton = new javax.swing.JButton();
        vaccineComboBox = new javax.swing.JComboBox();
        quantityJTextField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        unitPriceJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        unitPriceJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitPriceJTextFieldActionPerformed(evt);
            }
        });
        add(unitPriceJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 490, 203, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Add Vaccine");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 89, 25));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Unit Price");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 480, 89, 25));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Quantity");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, 89, 25));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Vaccine Name");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 105, 25));

        vaccineJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Id", "Name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vaccineJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 670, 151));

        viewButton.setBackground(new java.awt.Color(255, 204, 204));
        viewButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewButton.setText("View Vaccine");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });
        add(viewButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, -1, -1));

        add(vaccineComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, 203, -1));

        quantityJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        quantityJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityJTextFieldActionPerformed(evt);
            }
        });
        add(quantityJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 430, 203, -1));

        backButton.setBackground(new java.awt.Color(255, 204, 204));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 610, -1, -1));

        submitButton.setBackground(new java.awt.Color(255, 204, 204));
        submitButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 560, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Manage Inventory");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void unitPriceJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitPriceJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitPriceJTextFieldActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = vaccineJTable.getSelectedRow();
        if (selectedRow >= 0) {
            Inventory inventory = (Inventory) vaccineJTable.getValueAt(selectedRow, 0);
            Vaccine vaccine = inventory.getVaccine();
            ViewVaccineJPanel viewVaccine = new ViewVaccineJPanel(userProcessContainer, vaccine);
            userProcessContainer.add("ViewVaccineJPanel", viewVaccine);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else if (selectedRow > 1) {
            JOptionPane.showMessageDialog(null, "Please select only one row");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
        populate();
    }//GEN-LAST:event_viewButtonActionPerformed

    private void quantityJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityJTextFieldActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
         try {
            Vaccine vaccine = (Vaccine) vaccineComboBox.getSelectedItem();
            String quan = quantityJTextField.getText();
            String cost = unitPriceJTextField.getText();

            if (!(quan.isEmpty()) && !(cost.isEmpty())) {
                int quantity = Integer.parseInt(quantityJTextField.getText());
                float costPrice = Float.parseFloat(unitPriceJTextField.getText());
                Inventory inventory = new Inventory();
                inventory.setVaccine(vaccine);
                inventory.setQuantity(quantity);
                inventory.setCostPrice(costPrice);
                boolean presentInventory = false;
                for (Inventory inv : inventoryOrg.getInventoryDirectory().getInventoryList()) {
                    if (inv.getVaccine() == inventory.getVaccine()) {
                        inv.setQuantity(inv.getQuantity() + inventory.getQuantity());
                        presentInventory = true;
                    }
                }
                if (!presentInventory) {
                    inventoryOrg.getInventoryDirectory().getInventoryList().add(inventory);
                }
                JOptionPane.showMessageDialog(null, "Details submitted");
                populate();
            }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Enter appropriaite Details");
                        return;
                    }
    }//GEN-LAST:event_submitButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField quantityJTextField;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField unitPriceJTextField;
    private javax.swing.JComboBox vaccineComboBox;
    private javax.swing.JTable vaccineJTable;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
}
