/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DistributorFinance;

import Business.CDCSystem;
import Business.Enterprise.DistributorEnterprise;
import Business.Enterprise.Enterprise;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FinanceRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danisha
 */
public class ManageReceivingDistributorJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageReceivingDistributorJPanel
     */
    private JPanel userProcessContainer;
    private CDCSystem system;
    private Enterprise enterprise;
    private UserAccount account;
    private Order order;
    public ManageReceivingDistributorJPanel(JPanel userProcessContainer, CDCSystem system, Enterprise enterprise, UserAccount account) {
        initComponents();
        this.userProcessContainer= userProcessContainer;
        this.system= system;
        this.enterprise= enterprise;
        this.account= account;
        populateRequests();
    }

    public void populateRequests() {
        DefaultTableModel dtm = (DefaultTableModel) requestJTable.getModel();
        dtm.setRowCount(0);

        for (Organization org : system.getNationalDistributor().getOrganizationDirectory().getOrganizationList()) {
            if (org.getName().equals(Organization.Type.Finance.getValue())) {
                for (WorkRequest request : org.getWorkQueue().getWorkRequestList()) {
                    FinanceRequest financeRequest = (FinanceRequest) request;
                    if (financeRequest.getFinanceType().equals("d to p")) {
                        Object row[] = new Object[4];
                        row[0] = financeRequest;
                        row[1] = financeRequest.getStatus();
                        row[2] = financeRequest.getRequestDate();
                        row[3] = financeRequest.getSender();
                        dtm.addRow(row);
                    }
                }
            }
        }
    }

    public void populateOrder(Order order) {
        DefaultTableModel dtm = (DefaultTableModel) orderTable.getModel();
        dtm.setRowCount(0);
        for (OrderItem orderItem : order.getOrderItemList()) {
            Object row[] = new Object[2];
            row[0] = orderItem.getVaccine().getVaccineName();
            row[1] = orderItem.getQuantity();
            dtm.addRow(row);
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

        viewOrderButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        paymentModeTextField = new javax.swing.JTextField();
        acceptPaymentButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        totalAmountTextField = new javax.swing.JTextField();
        paidDateTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        requestJTable = new javax.swing.JTable();
        billingDateTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewOrderButton.setBackground(new java.awt.Color(255, 204, 204));
        viewOrderButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewOrderButton.setText("View Details");
        viewOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderButtonActionPerformed(evt);
            }
        });
        add(viewOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 124, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Billing Date");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 240, -1, -1));

        backButton.setBackground(new java.awt.Color(255, 204, 204));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 492, 100, -1));

        paymentModeTextField.setEditable(false);
        paymentModeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentModeTextFieldActionPerformed(evt);
            }
        });
        add(paymentModeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 330, 141, 31));

        acceptPaymentButton.setBackground(new java.awt.Color(255, 204, 204));
        acceptPaymentButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        acceptPaymentButton.setText("Accept Payment");
        acceptPaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptPaymentButtonActionPerformed(evt);
            }
        });
        add(acceptPaymentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 430, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Paid Date");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Payment Mode");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 340, -1, -1));

        totalAmountTextField.setEditable(false);
        totalAmountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAmountTextFieldActionPerformed(evt);
            }
        });
        add(totalAmountTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 180, 141, 31));

        paidDateTextField.setEditable(false);
        paidDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidDateTextFieldActionPerformed(evt);
            }
        });
        add(paidDateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 280, 141, 31));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Total Amount");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 190, -1, -1));

        requestJTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        requestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Id", "Status", "Request Date", "Sender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(requestJTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 680, 130));

        billingDateTextField.setEditable(false);
        billingDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billingDateTextFieldActionPerformed(evt);
            }
        });
        add(billingDateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 230, 141, 31));

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(orderTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 471, 135));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Manage Incoming Payments");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("View Request");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 130, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void viewOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestJTable.getSelectedRow();
        if (selectedRow >= 0) {
            FinanceRequest finance = (FinanceRequest) requestJTable.getValueAt(selectedRow, 0);
            order = finance.getOrder();
            populateOrder(order);
            totalAmountTextField.setText(String.valueOf(finance.getTotalAmount()));
            billingDateTextField.setText(String.valueOf(finance.getBillingDate()));
            paidDateTextField.setText(String.valueOf(finance.getPaidDate()));
            paymentModeTextField.setText(finance.getPaymentMode());

        } else if (selectedRow > 1) {
            JOptionPane.showMessageDialog(null, "Please select only one row");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
    }//GEN-LAST:event_viewOrderButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void paymentModeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentModeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentModeTextFieldActionPerformed

    private void acceptPaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptPaymentButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestJTable.getSelectedRow();
        if (selectedRow >= 0) {
            WorkRequest selectedOrder = (WorkRequest) requestJTable.getValueAt(selectedRow, 0);
            if(selectedOrder.getStatus().equals("Payment Received by Distributor")){
                JOptionPane.showMessageDialog(null,"Order already processed");
                return;
            }
            FinanceRequest finance = (FinanceRequest) selectedOrder;
            DistributorEnterprise pe = (DistributorEnterprise) enterprise;
            pe.setDistTreasure(pe.getDistTreasure() + finance.getTotalAmount());
            finance.setStatus("Payment Received by Distributor");
            JOptionPane.showMessageDialog(null, "Payment Accepted Successfully");
            populateRequests();
        }else if (selectedRow > 1) {
            JOptionPane.showMessageDialog(null, "Please select only one row");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
        populateRequests();
        totalAmountTextField.setText(null);
        billingDateTextField.setText(null);
        paidDateTextField.setText(null);
        paymentModeTextField.setText(null);
    }//GEN-LAST:event_acceptPaymentButtonActionPerformed

    private void totalAmountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAmountTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAmountTextFieldActionPerformed

    private void paidDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paidDateTextFieldActionPerformed

    private void billingDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billingDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_billingDateTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptPaymentButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField billingDateTextField;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable orderTable;
    private javax.swing.JTextField paidDateTextField;
    private javax.swing.JTextField paymentModeTextField;
    private javax.swing.JTable requestJTable;
    private javax.swing.JTextField totalAmountTextField;
    private javax.swing.JButton viewOrderButton;
    // End of variables declaration//GEN-END:variables
}
