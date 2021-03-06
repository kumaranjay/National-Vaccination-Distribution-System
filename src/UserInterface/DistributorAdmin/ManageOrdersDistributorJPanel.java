/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DistributorAdmin;

import Business.CDCSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danisha
 */
public class ManageOrdersDistributorJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageOrdersDistributorJPanel
     */
    private JPanel userProcessContainer;
    private CDCSystem system;
    private Enterprise enterprise;
    private UserAccount account;
    public ManageOrdersDistributorJPanel(JPanel userProcessContainer, CDCSystem system, UserAccount account ,Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.enterprise = enterprise;
        this.account=account;
        populateRequests();
    }

    public void populateRequests() {
        DefaultTableModel dtm = (DefaultTableModel) requestJTable.getModel();
        dtm.setRowCount(0);
        for (WorkRequest request : system.getNationalDistributor().getWorkQueue().getWorkRequestList()) {
            OrderRequest orderRequest = (OrderRequest) request;
            Object row[] = new Object[5];
            row[0] = orderRequest;
            row[1] = orderRequest.getStatus();
            row[2] = orderRequest.getRequestDate();
            row[3] = orderRequest.getSender();
            row[4] = orderRequest.getSenderEnterprise();
            dtm.addRow(row);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        requestJTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        viewOrderButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        forwardButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        requestJTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        requestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Status", "Request Date", "Enterpsie Name", "Sender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(requestJTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 930, 134));

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

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 520, 135));

        viewOrderButton.setBackground(new java.awt.Color(255, 204, 204));
        viewOrderButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewOrderButton.setText("View Order");
        viewOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderButtonActionPerformed(evt);
            }
        });
        add(viewOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 124, -1));

        backButton.setBackground(new java.awt.Color(255, 204, 204));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 530, 98, -1));

        forwardButton.setBackground(new java.awt.Color(255, 204, 204));
        forwardButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        forwardButton.setText("Forward to Inventory");
        forwardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardButtonActionPerformed(evt);
            }
        });
        add(forwardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 540, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Manage Order Requests");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, -1, 25));
    }// </editor-fold>//GEN-END:initComponents

    private void viewOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestJTable.getSelectedRow();
        if (selectedRow >= 0) {
            OrderRequest orderRequest = (OrderRequest) requestJTable.getValueAt(selectedRow, 0);
            Order order = orderRequest.getOrder();
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

    private void forwardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestJTable.getSelectedRow();
        if (selectedRow >= 0) {
            OrderRequest orderRequest = new OrderRequest();
            orderRequest = (OrderRequest) requestJTable.getValueAt(selectedRow, 0);
            if(orderRequest.getStatus().equals("Pending from Distributor Inventory Org")){
                JOptionPane.showMessageDialog(null,"Order already processed");
                return;
            }
            orderRequest.setStatus("Pending from Distributor Inventory Org");
            Date date = new Date();
            orderRequest.setResolveDate(date);
            WorkRequest request = orderRequest;
            Network rootNetwork = system.getNetwork();
            for (Network network : rootNetwork.getNetworkList()) {
                if (network.getName().equals(orderRequest.getSenderEnterprise().getLocation())) {
                    for (Enterprise enterprise1 : network.getEnterpriseDirectory().getEnterpriseList()) {
                        if (enterprise1.getEnterpriseType().equals(Enterprise.EnterpriseType.Distributor)) {
                            for(Organization org: enterprise1.getOrganizationDirectory().getOrganizationList()){
                                if(org.getName().equals(Organization.Type.Inventory.getValue())){
                                    org.getWorkQueue().getWorkRequestList().add(request);
                                }
                            }
                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Request forwarded to Distributor Inventory");
        } else if (selectedRow > 1) {
            JOptionPane.showMessageDialog(null, "Please select only one row");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
        populateRequests();
    }//GEN-LAST:event_forwardButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton forwardButton;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable orderTable;
    private javax.swing.JTable requestJTable;
    private javax.swing.JButton viewOrderButton;
    // End of variables declaration//GEN-END:variables
}
