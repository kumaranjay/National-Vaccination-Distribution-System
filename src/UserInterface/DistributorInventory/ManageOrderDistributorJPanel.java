/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DistributorInventory;

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
import Business.Vaccine.Vaccine;
import Business.WorkQueue.FinanceRequest;
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
public class ManageOrderDistributorJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageOrderDistributorJPanel
     */
    private JPanel userProcessContainer;
    private CDCSystem system;
    private UserAccount account;
    private Enterprise enterprise;
    private InventoryOrganization inventoryOrg;
    private Order order;
    private OrderRequest selectedOrder;
    private boolean checkInFlag = false;
    private Organization distributorOrganization;

    public ManageOrderDistributorJPanel(JPanel userProcessContainer, CDCSystem system, Enterprise enterprise, UserAccount account) {
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
            if (inventory.getQuantity() < 5) {
                belowThreshold = true;
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
            orderRequestDist.setRequestType("Order");
            orderRequestDist.setSenderEnterprise(enterprise);
            orderRequestDist.setSender(account);
            orderRequestDist.setRequestID(WorkRequest.count++);
            orderRequestDist.setStatus("Sent to Manufacturer");
            Date date = new Date();
            orderRequestDist.setRequestDate(date);
            WorkRequest requestDist = orderRequestDist;
            Network root = system.getNetwork();
            for (Network network : root.getNetworkList()) {
                if (network.getName().equals(enterprise.getLocation())) {
                    for (Enterprise enterprise1 : network.getEnterpriseDirectory().getEnterpriseList()) {
                        if (enterprise1.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Manufacturer.getValue())) {
                            for (Organization org : enterprise1.getOrganizationDirectory().getOrganizationList()) {
                                if (org.getName().equals(Organization.Type.Admin.getValue())) {
                                    org.getWorkQueue().getWorkRequestList().add(requestDist);
                                }
                            }
                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Automated Request Made");
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        requestJTable = new javax.swing.JTable();
        checkButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vaccineJTable = new javax.swing.JTable();
        viewOrderButton = new javax.swing.JButton();
        backButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Request Table:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

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

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 525, 135));

        jLabel2.setText("Order Details:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, -1, -1));

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 810, 140));

        checkButton.setBackground(new java.awt.Color(255, 204, 204));
        checkButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkButton.setText("Check in Inventory and Forward Request");
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });
        add(checkButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 640, 354, -1));

        jLabel3.setText("Inventory Details:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, -1, -1));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 646, 130));

        viewOrderButton.setBackground(new java.awt.Color(255, 204, 204));
        viewOrderButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewOrderButton.setText("View Order");
        viewOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderButtonActionPerformed(evt);
            }
        });
        add(viewOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 124, -1));

        backButton1.setBackground(new java.awt.Color(255, 204, 204));
        backButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backButton1.setText("<< Back");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });
        add(backButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 670, 98, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Manage Order Requests");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed

        int selectedRow = requestJTable.getSelectedRow();
        int quantityDiff = 0;
        boolean partialdelivery = false;

        if (selectedRow >= 0) {
            selectedOrder = (OrderRequest) requestJTable.getValueAt(selectedRow, 0);
            if(selectedOrder.getStatus().equals("Pending from Manufacturer")){
                JOptionPane.showMessageDialog(null,"Order already processed");
                return;
            }
            order = selectedOrder.getOrder();
            populateOrder(order);
            Order tempOrder = new Order();
            tempOrder.setOrderId(Order.count++);
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
                            //placeVaccineOrder(quantityDiff, selectedOrder);
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
                delivery.setOrder(tempOrder);
                delivery.setRequestID(WorkRequest.count++);
                delivery.setRequestType("Order");
                delivery.setOrderType("Delivery");
                delivery.setStatus("Delivered from Distributor Inventory to the Provider Inventory");
                delivery.setSender(account);
                delivery.setSenderEnterprise(enterprise);
                delivery.setRequestDate(selectedOrder.getRequestDate());
                Date date = new Date();
                delivery.setResolveDate(date);
                WorkRequest request = delivery;
                float totalAmount = 0;
                for (OrderItem oi : tempOrder.getOrderItemList()) {
                    totalAmount += oi.getSalesPrice() * oi.getQuantity();
                }
                FinanceRequest financeReq = new FinanceRequest();
                financeReq.setOrder(tempOrder);
                financeReq.setTotalAmount(totalAmount);
                Date date2 = new Date();
                financeReq.setBillingDate(date2);
                financeReq.setRequestID(WorkRequest.count++);
                financeReq.setSender(account);
                financeReq.setRequestType("Finance");
                financeReq.setSenderEnterprise(enterprise);
                financeReq.setRequestDate(date2);
                financeReq.setFinanceType("d to p");
                financeReq.setStatus("Sent to Provider Finance Org for payment");
                WorkRequest finRequest = financeReq;
                Network root = system.getNetwork();
                for (Network stateNetwork : root.getNetworkList()) {
                    if (stateNetwork.getName().equals(enterprise.getLocation())) {
                        for (Network cityNetwork : stateNetwork.getNetworkList()) {
                            ProviderEnterprise pe = (ProviderEnterprise) selectedOrder.getSenderEnterprise();
                            if (cityNetwork.getName().equals(pe.getCity())) {
                                for (Enterprise enterprise1 : cityNetwork.getEnterpriseDirectory().getEnterpriseList()) {
                                    if (enterprise1.getEnterpriseName().equals(selectedOrder.getSenderEnterprise().getEnterpriseName())) {
                                        for (Organization org : enterprise1.getOrganizationDirectory().getOrganizationList()) {
                                            if (org.getName().equals(Organization.Type.Inventory.getValue())) {
                                                org.getWorkQueue().getWorkRequestList().add(delivery);
                                            }
                                            if (org.getName().equals(Organization.Type.Admin.getValue())) {
                                                org.getWorkQueue().getWorkRequestList().add(delivery);
                                            }
                                            if (org.getName().equals(Organization.Type.Finance.getValue())) {
                                                org.getWorkQueue().getWorkRequestList().add(finRequest);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                for (Organization org : system.getNationalDistributor().getOrganizationDirectory().getOrganizationList()) {
                    if (org.getName().equals(Organization.Type.Finance.getValue())) {
                        org.getWorkQueue().getWorkRequestList().add(finRequest);
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
                    
                    selectedOrder.setStatus("Pending from Manufacturer");
                    selectedOrder.setSender(account);
                    selectedOrder.setRequestType("Order");
                    selectedOrder.setOrderType("Order");

                    WorkRequest request2 = selectedOrder;

                    for (Network network : root.getNetworkList()) {
                        if (network.getName().equals(enterprise.getLocation())) {
                            for (Enterprise enterprise1 : network.getEnterpriseDirectory().getEnterpriseList()) {
                                if (enterprise1.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Manufacturer.getValue())) {
                                    for (Organization org : enterprise1.getOrganizationDirectory().getOrganizationList()) {
                                        if (org.getName().equals(Organization.Type.Admin.getValue())) {
                                            org.getWorkQueue().getWorkRequestList().add(request2);
                                        }
                                    }
                                }
                            }
                        }
                    }

                    account.getWorkQueue().getWorkRequestList().add(request2);
                } else {
                    WorkRequest request2 = selectedOrder;
                    distributorOrganization.getWorkQueue().getWorkRequestList().remove(request2);
                }
                account.getWorkQueue().getWorkRequestList().add(request);
                if (!partialdelivery) {
                    JOptionPane.showMessageDialog(null, "Checked in inventory and delivery done accordingly");
                } else {
                    JOptionPane.showMessageDialog(null, "Few vaccines are delivered from inventory.");

                }
            } else {
                selectedOrder.setStatus("Sent to order org");
                selectedOrder.setSender(account);
                selectedOrder.setRequestType("Order");
                WorkRequest request2 = selectedOrder;
                Network root = system.getNetwork();
                for (Network network : root.getNetworkList()) {
                    if (network.getName().equals(enterprise.getLocation())) {
                        for (Enterprise enterprise1 : network.getEnterpriseDirectory().getEnterpriseList()) {
                            if (enterprise1.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Manufacturer.getValue())) {
                                for (Organization org : enterprise1.getOrganizationDirectory().getOrganizationList()) {
                                    if (org.getName().equals(Organization.Type.Admin.getValue())) {
                                        org.getWorkQueue().getWorkRequestList().add(request2);
                                    }
                                }
                            }
                        }
                    }
                }
                account.getWorkQueue().getWorkRequestList().add(request2);
                JOptionPane.showMessageDialog(null, "Not found in invenotry");
            }

            checkInFlag = true;
            populateRequests();
            populateInventory();
            populateOrder(order);
        } else if (selectedRow > 1) {
            JOptionPane.showMessageDialog(null, "Please select only one row");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
    }//GEN-LAST:event_checkButtonActionPerformed

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

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton1;
    private javax.swing.JButton checkButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable orderTable;
    private javax.swing.JTable requestJTable;
    private javax.swing.JTable vaccineJTable;
    private javax.swing.JButton viewOrderButton;
    // End of variables declaration//GEN-END:variables
}
