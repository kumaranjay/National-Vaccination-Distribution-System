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
public class ManageDeliveryDistributorJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageDeliveryDistributorJPanel
     */
    private JPanel userProcessContainer;
    private CDCSystem system;
    private UserAccount account;
    private Enterprise enterprise;
    private Order order;
    private OrderRequest selectedOrder;
    private boolean checkInFlag = false;
    private InventoryOrganization inventoryOrg;
    private boolean sameRequest = false;
    private float totalAmount = 0;

    public ManageDeliveryDistributorJPanel(JPanel userProcessContainer, CDCSystem system, Enterprise enterprise, UserAccount account) {
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
        backButton = new javax.swing.JButton();
        addInventoryButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        viewOrderButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        vaccineJTable = new javax.swing.JTable();
        forwardProviderButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 697, 160));

        backButton.setBackground(new java.awt.Color(255, 204, 204));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 670, 98, -1));

        addInventoryButton.setBackground(new java.awt.Color(255, 204, 204));
        addInventoryButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addInventoryButton.setText("Add to Inventory");
        addInventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInventoryButtonActionPerformed(evt);
            }
        });
        add(addInventoryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 630, -1, -1));

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

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 515, 135));

        viewOrderButton.setBackground(new java.awt.Color(255, 204, 204));
        viewOrderButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewOrderButton.setText("View Order");
        viewOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderButtonActionPerformed(evt);
            }
        });
        add(viewOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 124, -1));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, 697, 136));

        forwardProviderButton.setBackground(new java.awt.Color(255, 204, 204));
        forwardProviderButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        forwardProviderButton.setText("Forward to Provider");
        forwardProviderButton.setEnabled(false);
        forwardProviderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardProviderButtonActionPerformed(evt);
            }
        });
        add(forwardProviderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 630, 195, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Manage Delivery Requests");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, -1, -1));

        jLabel1.setText("Inventory Details:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 530, -1, 20));

        jLabel2.setText("Delivery Requests:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, 20));

        jLabel3.setText("Order Details:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, -1, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void addInventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInventoryButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestJTable.getSelectedRow();

        if (selectedRow >= 0) {
            OrderRequest orderRequest = (OrderRequest) requestJTable.getValueAt(selectedRow, 0);
            if(orderRequest.getStatus().equals("Sent from Distributor to Provider inventory")){
                JOptionPane.showMessageDialog(null,"Order already processed");
                return;
            }
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

            populateInventory();


            if (orderRequest.getSenderEnterprise().getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Provider.getValue())) {
                forwardProviderButton.setEnabled(true);
                sameRequest = true;
            }
            if (orderRequest.getSenderEnterprise().getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Distributor.getValue())) {
            }

            account.getWorkQueue().getWorkRequestList().remove(orderRequest);
            JOptionPane.showMessageDialog(null, "Items added to inventory");


        } else {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
    }//GEN-LAST:event_addInventoryButtonActionPerformed

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

    private void forwardProviderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardProviderButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestJTable.getSelectedRow();
        if (selectedRow >= 0) {
            if (sameRequest) {
                OrderRequest orderRequest = (OrderRequest) requestJTable.getValueAt(selectedRow, 0);
                if (orderRequest.getStatus().equals("Sent from Distributor to Provider inventory")) {
                    JOptionPane.showMessageDialog(null, "Order already processed");
                    return;
                }
                order = orderRequest.getOrder();
                float totalAmountNew = 0.0f;
                for (OrderItem oi : order.getOrderItemList()) {
                    float price = oi.getSalesPrice();
                    float raisedAmt = price + (price * 0.1f);
                    oi.setSalesPrice(raisedAmt);
                    totalAmountNew += oi.getSalesPrice() * oi.getQuantity();
                }
                orderRequest.setStatus("Sent from Distributor to Provider inventory");
                orderRequest.setOrderType("Delivery");
                WorkRequest request = orderRequest;
                FinanceRequest financeReq = new FinanceRequest();
                financeReq.setOrder(order);
                financeReq.setRequestID(WorkRequest.count++);
                financeReq.setTotalAmount(totalAmountNew);
                Date date = new Date();
                financeReq.setBillingDate(date);
                financeReq.setSender(account);
                financeReq.setSenderEnterprise(enterprise);
                financeReq.setRequestDate(date);
                financeReq.setRequestType("Finance");
                financeReq.setFinanceType("d to p");
                financeReq.setStatus("Pending from provider finance");
                WorkRequest request2 = financeReq;
                Network root = system.getNetwork();
                for (Network stateNetwork : root.getNetworkList()) {
                    if (stateNetwork.getName().equals(enterprise.getLocation())) {
                        for (Network cityNetwork : stateNetwork.getNetworkList()) {
                            ProviderEnterprise pe = (ProviderEnterprise) orderRequest.getSenderEnterprise();
                            if (cityNetwork.getName().equals(pe.getCity())) {
                                for (Enterprise enterprise1 : cityNetwork.getEnterpriseDirectory().getEnterpriseList()) {
                                    if (enterprise1.getEnterpriseName().equals(orderRequest.getSenderEnterprise().getEnterpriseName())) {
                                        for (Organization org : enterprise1.getOrganizationDirectory().getOrganizationList()) {
                                            if (org.getName().equals(Organization.Type.Finance.getValue())) {
                                                org.getWorkQueue().getWorkRequestList().add(request2);
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
                        org.getWorkQueue().getWorkRequestList().add(request2);
                    }
                }
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
        populateRequests();
    }//GEN-LAST:event_forwardProviderButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addInventoryButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton forwardProviderButton;
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
