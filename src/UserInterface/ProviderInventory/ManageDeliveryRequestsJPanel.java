/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ProviderInventory;

import Business.CDCSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ProviderEnterprise;
import Business.Inventory.Inventory;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.InventoryOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danisha
 */
public class ManageDeliveryRequestsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageDeliveryRequestsJPanel
     */
    private JPanel userProcessContainer;
    private CDCSystem system;
    private UserAccount account;
    private Enterprise enterprise;
    private InventoryOrganization inventoryOrg;
    private Order order;
    private OrderRequest selectedOrder;
    private boolean checkInFlag = false;
    private boolean sameRequest = false;

    public ManageDeliveryRequestsJPanel(JPanel userProcessContainer, CDCSystem system, Enterprise enterprise, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.account = account;
        this.enterprise = enterprise;
        populateRequests();
        populateInventory();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        requestJTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        viewOrderButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        checkButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        vaccineJTable = new javax.swing.JTable();
        forwardProviderButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        requestJTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        requestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Status", "Request Date", "Sender"
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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 930, 150));

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(orderTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 471, 135));

        viewOrderButton.setBackground(new java.awt.Color(255, 204, 204));
        viewOrderButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewOrderButton.setText("View Order");
        viewOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderButtonActionPerformed(evt);
            }
        });
        add(viewOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 124, -1));

        backButton.setBackground(new java.awt.Color(255, 204, 204));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 670, 98, -1));

        checkButton.setBackground(new java.awt.Color(255, 204, 204));
        checkButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkButton.setText("Add to Inventory");
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });
        add(checkButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 650, -1, -1));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 571, 136));

        forwardProviderButton.setBackground(new java.awt.Color(255, 204, 204));
        forwardProviderButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        forwardProviderButton.setText("Forward to Provider");
        forwardProviderButton.setEnabled(false);
        forwardProviderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardProviderButtonActionPerformed(evt);
            }
        });
        add(forwardProviderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 650, 195, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Manage Delivery Requests");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, -1, -1));

        jLabel3.setText("Inventory:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, -1, -1));

        jLabel2.setText("Order Details:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, -1, -1));

        jLabel1.setText("Request Table:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    public void populateRequests() {
        DefaultTableModel dtm = (DefaultTableModel) requestJTable.getModel();
        dtm.setRowCount(0);
        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (org.getName().equals(Organization.Type.Inventory.getValue())) {
                for (WorkRequest request : org.getWorkQueue().getWorkRequestList()) {
                    if (request.getRequestType().equals("Order")) {
                        OrderRequest orderRequest = (OrderRequest) request;
                        if (orderRequest.getOrderType().equals("Delivery")) {
                            Object row[] = new Object[4];
                            row[0] = orderRequest;
                            row[1] = orderRequest.getStatus();
                            row[2] = orderRequest.getRequestDate();
                            row[3] = orderRequest.getSender();
                            dtm.addRow(row);
                        }
                    }
                }
            }
        }
    }

    public void populateInventory() {
        DefaultTableModel dtm = (DefaultTableModel) vaccineJTable.getModel();
        dtm.setRowCount(0);
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization.getName().equals(Organization.Type.Inventory.getValue())) {
                inventoryOrg = (InventoryOrganization) organization;
                for (Inventory inventory : inventoryOrg.getInventoryDirectory().getInventoryList()) {
                    Object row[] = new Object[3];
                    row[0] = inventory.getVaccine().getVaccineId();
                    row[1] = inventory.getVaccine();
                    row[2] = inventory.getQuantity();
                    dtm.addRow(row);
                }
            }
        }
    }

    public void checkAutoOrderFlag(){
        for (Inventory inventory : inventoryOrg.getInventoryDirectory().getInventoryList()) {
                    if(inventory.getQuantity()<5){
                        inventory.setAutoOrder(true);
                    }
                    else{
                        inventory.setAutoOrder(false);
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

    private void viewOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestJTable.getSelectedRow();
        if (selectedRow >= 0) {
            OrderRequest selectedOrder = (OrderRequest) requestJTable.getValueAt(selectedRow, 0);
            order = selectedOrder.getOrder();
            populateOrder(order);

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

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestJTable.getSelectedRow();
        float totalAmount = 0;
        if (selectedRow >= 0) {
            OrderRequest orderRequest = (OrderRequest) requestJTable.getValueAt(selectedRow, 0);
            order = orderRequest.getOrder();
            boolean inventoryEmpty = true;
            for (OrderItem oi : order.getOrderItemList()) {
                for (Inventory i : inventoryOrg.getInventoryDirectory().getInventoryList()) {

                    if (oi.getVaccine() == i.getVaccine()) {
                        inventoryEmpty = false;
                        i.setQuantity(i.getQuantity() + oi.getQuantity());
                        i.setCostPrice(oi.getSalesPrice());
                    }
                }
                if (inventoryEmpty) {
                    Inventory newInventory = new Inventory();
                    newInventory.setVaccine(oi.getVaccine());
                    newInventory.setCostPrice(oi.getSalesPrice());
                    newInventory.setQuantity(oi.getQuantity());
                    inventoryOrg.getInventoryDirectory().getInventoryList().add(newInventory);
                    populateInventory();
                }
                totalAmount += oi.getSalesPrice() * oi.getQuantity();
            }
            checkAutoOrderFlag();
            populateInventory();

            forwardProviderButton.setEnabled(true);
            sameRequest = true;
            account.getWorkQueue().getWorkRequestList().remove(orderRequest);
            JOptionPane.showMessageDialog(null, "Items added to inventory");


        } else {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
        populateInventory();
    }//GEN-LAST:event_checkButtonActionPerformed

    private void forwardProviderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardProviderButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestJTable.getSelectedRow();
        if (selectedRow >= 0) {
            if (sameRequest) {
                OrderRequest orderRequest = (OrderRequest) requestJTable.getValueAt(selectedRow, 0);
                if(orderRequest.getStatus().equals("Sent from Inventory")){
                JOptionPane.showMessageDialog(null, "Order already processed");
                return;
            }
                order = orderRequest.getOrder();
                orderRequest.setStatus("Sent from Inventory");
                orderRequest.setOrderType("Delivery");
                WorkRequest request = orderRequest;

                Order tempOrder = new Order();
                boolean orderFlag = false;
                int quantityDiff = 0;
                ArrayList<Inventory> deleteInventory = new ArrayList<>();

                for (Inventory inventory : inventoryOrg.getInventoryDirectory().getInventoryList()) {
                    for (OrderItem orderItem : order.getOrderItemList()) {
                        if (inventory.getVaccine() == orderItem.getVaccine()) {
                            if (inventory.getQuantity() >= orderItem.getQuantity()) {
                                if (inventory.getQuantity() == orderItem.getQuantity()) {
                                    deleteInventory.add(inventory);
                                } else {
                                    inventory.setQuantity(inventory.getQuantity() - orderItem.getQuantity());

                                }
                                tempOrder.addOrder(inventory.getVaccine(), orderItem.getQuantity(), inventory.getCostPrice());
                                orderFlag = true;
                            } else if (inventory.getQuantity() < orderItem.getQuantity()) {
                                quantityDiff = orderItem.getQuantity() - inventory.getQuantity();
                                deleteInventory.add(inventory);
                                tempOrder.addOrder(inventory.getVaccine(), inventory.getQuantity(), inventory.getCostPrice());
                                orderItem.setQuantity(quantityDiff);

                            }
                        }
                    }
                }
                for (Inventory inventory : deleteInventory) {
                    inventoryOrg.getInventoryDirectory().getInventoryList().remove(inventory);
                }

                JOptionPane.showMessageDialog(null, "Order Forwarded to provider");
            } else {
                JOptionPane.showMessageDialog(null, "Please add the order to inventory first");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
        populateInventory();
        checkAutoOrderFlag();
        populateRequests();
    }//GEN-LAST:event_forwardProviderButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton checkButton;
    private javax.swing.JButton forwardProviderButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable orderTable;
    private javax.swing.JTable requestJTable;
    private javax.swing.JTable vaccineJTable;
    private javax.swing.JButton viewOrderButton;
    // End of variables declaration//GEN-END:variables
}