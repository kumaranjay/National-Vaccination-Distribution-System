/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ProviderInventory;

import Business.CDCSystem;
import Business.Enterprise.Enterprise;
import Business.Inventory.Inventory;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.InventoryOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danisha
 */
public class ManageOrderInventoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageOrderRequestsJPanel
     */
    private JPanel userProcessContainer;
    private CDCSystem system;
    private UserAccount account;
    private Enterprise enterprise;
    private InventoryOrganization inventoryOrg;
    private Order order;
    private OrderRequest selectedOrder;
    private boolean checkInFlag = false;
    private Organization providerOrganization;
    private Organization org;

    public ManageOrderInventoryJPanel(JPanel userProcessContainer, CDCSystem system, Enterprise enterprise, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.account = account;
        this.enterprise = enterprise;
        populateRequests();
        populateInventory();
    }

    public void populateRequests() {
        DefaultTableModel dtm = (DefaultTableModel) requestJTable.getModel();
        dtm.setRowCount(0);
        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (org.getName().equals(Organization.Type.Inventory.getValue())) {
                this.org=org;
                for (WorkRequest request : org.getWorkQueue().getWorkRequestList()) {
                    if (request.getRequestType().equals("Order")) {
                        OrderRequest orderRequest = (OrderRequest) request;
                        if (orderRequest.getOrderType().equals("Order")) {
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

    public void checkThreshold() {
        Order autoOrder = new Order();
        autoOrder.setOrderId(Order.count++);
        boolean belowThreshold = false;
        for (Inventory inventory : inventoryOrg.getInventoryDirectory().getInventoryList()) {
            if ((inventory.getQuantity() < 5) && inventory.isAutoOrder()) {
                belowThreshold = true;
                inventory.setAutoOrder(false);
                OrderItem orderItem = new OrderItem();
                orderItem.setVaccine(inventory.getVaccine());
                orderItem.setQuantity(5 - inventory.getQuantity());
                orderItem.setSalesPrice(inventory.getCostPrice());
                autoOrder.getOrderItemList().add(orderItem);
            }
        }
        if (belowThreshold) {
            OrderRequest orderRequestDist = new OrderRequest();
            orderRequestDist.setOrder(autoOrder);
            orderRequestDist.setOrderType("Order");
            orderRequestDist.setSender(account);
            orderRequestDist.setSenderEnterprise(enterprise);
            orderRequestDist.setRequestType("Order");
            orderRequestDist.setStatus("Sent to PHD");
            Date date = new Date();
            orderRequestDist.setRequestDate(date);
            WorkRequest requestDist = orderRequestDist;
            Network root = system.getNetwork();
            for (Network network : root.getNetworkList()) {
                if (network.getName().equals(enterprise.getLocation())) {
                    for (Enterprise enterprise1 : network.getEnterpriseDirectory().getEnterpriseList()) {
                        if (enterprise1.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.PHD.getValue())) {
                            for (UserAccount userAccount : enterprise1.getUserAccountDirectory().getUserAccountList()) {
                                userAccount.getWorkQueue().getWorkRequestList().add(requestDist);
                            }
                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Automated order sent to PHD.");

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

        jScrollPane2 = new javax.swing.JScrollPane();
        requestJTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        viewOrderButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        vaccineJTable = new javax.swing.JTable();
        checkButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 900, 140));

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

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 471, 135));

        viewOrderButton.setBackground(new java.awt.Color(255, 204, 204));
        viewOrderButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewOrderButton.setText("View Order");
        viewOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderButtonActionPerformed(evt);
            }
        });
        add(viewOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 124, -1));

        backButton.setBackground(new java.awt.Color(255, 204, 204));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 98, -1));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 571, 136));

        checkButton.setBackground(new java.awt.Color(255, 204, 204));
        checkButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkButton.setText("Check in Inventory and Forward Request");
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });
        add(checkButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 620, 354, -1));

        jLabel1.setText("Request Table:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabel2.setText("Order Details:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        jLabel3.setText("Inventory:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Manage Order Requests");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void viewOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestJTable.getSelectedRow();
        if (selectedRow >= 0) {
            selectedOrder = (OrderRequest) requestJTable.getValueAt(selectedRow, 0);
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

        int selectedRow = requestJTable.getSelectedRow();
        int quantityDiff = 0;
        boolean partialdelivery = false;

        if (selectedRow >= 0) {
            OrderRequest selectedOrder = (OrderRequest) requestJTable.getValueAt(selectedRow, 0);
            if(selectedOrder.getStatus().equals("Pending from order org")){
                JOptionPane.showMessageDialog(null, "Order already processed");
                return;
            }
            order = selectedOrder.getOrder();
            populateOrder(order);
            Order tempOrder = new Order();
            boolean orderFlag = false;
            ArrayList<Inventory> deleteInventory = new ArrayList<>();
            ArrayList<OrderItem> deleteOrderItem = new ArrayList<>();

            for (Inventory inventory : inventoryOrg.getInventoryDirectory().getInventoryList()) {
                for (OrderItem orderItem : order.getOrderItemList()) {
                    if (inventory.getVaccine() == orderItem.getVaccine()) {
                        if (inventory.getQuantity() >= orderItem.getQuantity()) {
                            if (inventory.getQuantity() == orderItem.getQuantity()) {
                                deleteInventory.add(inventory);
                                deleteOrderItem.add(orderItem);
                            } else {
                                inventory.setQuantity(inventory.getQuantity() - orderItem.getQuantity());
                                deleteOrderItem.add(orderItem);
                            }
                            tempOrder.addOrder(inventory.getVaccine(), orderItem.getQuantity(), inventory.getCostPrice());
                            orderFlag = true;
                        } else if (inventory.getQuantity() < orderItem.getQuantity()) {
                            quantityDiff = orderItem.getQuantity() - inventory.getQuantity();
                            deleteInventory.add(inventory);
                            tempOrder.addOrder(inventory.getVaccine(), inventory.getQuantity(), inventory.getCostPrice());
                            orderItem.setQuantity(quantityDiff);
                            partialdelivery = true;
                            orderFlag = true;
                        }
                    }
                }
            }
            for (Inventory inventory : deleteInventory) {
                inventoryOrg.getInventoryDirectory().getInventoryList().remove(inventory);
            }
            for (OrderItem orderItem : deleteOrderItem) {
                order.getOrderItemList().remove(orderItem);
            }
            checkThreshold(); // Checking the inventorys threshold

            if (orderFlag) {

                OrderRequest delivery = new OrderRequest();
                tempOrder.setOrderId(Order.count++);
                delivery.setOrder(tempOrder);
                delivery.setRequestType("Order");
                delivery.setOrderType("Delivery");
                delivery.setStatus("Delivered from Inventory");
                delivery.setSender(account);
                delivery.setRequestDate(selectedOrder.getRequestDate());
                Date date = new Date();
                delivery.setResolveDate(date);
                WorkRequest request = delivery;

                for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (org.getName().equals(Organization.Type.Admin.getValue())) {
                        providerOrganization = org;
                        org.getWorkQueue().getWorkRequestList().add(request);
                    }
                }
                boolean checkOrder = false;
                for (OrderItem oi : order.getOrderItemList()) {
                    for (Vaccine vaccine : system.getVaccineDirectory().getVaccineList()) {
                        if (oi.getVaccine() == vaccine) {
                            checkOrder = true;
                            break;
                        }
                    }
                }
                if (checkOrder) {
                    selectedOrder.setStatus("Pending from order org");
                    selectedOrder.setRequestType("Order");
                    selectedOrder.setOrderType("Order");
                    WorkRequest request2 = selectedOrder;
                    for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (org.getName().equals(Organization.Type.Order.getValue())) {
                            org.getWorkQueue().getWorkRequestList().add(request2);
                        }
                    }

                    account.getWorkQueue().getWorkRequestList().add(request2);
                } else {
                    WorkRequest request2 = selectedOrder;
                    providerOrganization.getWorkQueue().getWorkRequestList().remove(request2);
                    org.getWorkQueue().getWorkRequestList().remove(request2);
                    
                }
                account.getWorkQueue().getWorkRequestList().add(request);
                if (!partialdelivery) {
                    JOptionPane.showMessageDialog(null, "Checked in inventory and delivery done accordingly");
                } else {
                    JOptionPane.showMessageDialog(null, "Few vaccines are delivered from inventory. Request Sent to Order Organization for the rest");

                }
            } else {
                selectedOrder.setStatus("Pending from order org");
                selectedOrder.setSender(account);
                selectedOrder.setRequestType("Order");
                selectedOrder.setOrderType("Order");
                WorkRequest request2 = selectedOrder;
                for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (org.getName().equals(Organization.Type.Order.getValue())) {
                        org.getWorkQueue().getWorkRequestList().add(request2);
                    }
                }

                account.getWorkQueue().getWorkRequestList().add(request2);
                JOptionPane.showMessageDialog(null, "Not found in invenotry. Forwarded to Order organization");
            }

            checkInFlag = true;
            populateInventory();
            populateOrder(order);
        } else if (selectedRow > 1) {
            JOptionPane.showMessageDialog(null, "Please select only one row");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
        populateRequests();
    }//GEN-LAST:event_checkButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton checkButton;
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
