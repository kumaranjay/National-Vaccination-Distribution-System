/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CDCSystemAdmin;

import Business.CDCSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Danisha
 */
public class ManageEnterpriseAdminJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageEnterpriseAdminJPanel
     */
    private JPanel userProcessContainer;
    private CDCSystem system;
    private String username;
    private String password;
    private String name;
    private String enterpriseName;
    private String networkName;
    private String enterpriseType;
    private UserAccount userAccount=null;
    
    public ManageEnterpriseAdminJPanel(JPanel userProcessContainer, CDCSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        populate();
        
    }

    public void populate() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) useraccountTable.getModel();
            dtm.setRowCount(0);
            Network network = system.getNetwork();
            for (Network network1 : network.getNetworkList()) {
                for (Enterprise enterprise : network1.getEnterpriseDirectory().getEnterpriseList()) {
                   for (UserAccount account : enterprise.getUserAccountDirectory().getUserAccountList()) {
                        Object row[] = new Object[5];
                        row[0] = enterprise.getEnterpriseName();
                        row[1] = network1.getName();
                        row[2] = enterprise.getEnterpriseType().getValue();
                        row[3] = account;
                        row[4] = account.getPassword();
                        dtm.addRow(row);
                    }
                }
            }
        } catch (Exception e) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        useraccountTable = new javax.swing.JTable();
        passwordJTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        enterpriseNameJTextField = new javax.swing.JTextField();
        nameJTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        viewAccountButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        usernameJTextField = new javax.swing.JTextField();
        networkNameJTextField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        backButton1 = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        useraccountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enterprise Name", "Network", "Location", "Username", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(useraccountTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 110, 910, 140));

        passwordJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        passwordJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordJTextFieldActionPerformed(evt);
            }
        });
        add(passwordJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 530, 166, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Network");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, -1, -1));

        enterpriseNameJTextField.setEditable(false);
        enterpriseNameJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        enterpriseNameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseNameJTextFieldActionPerformed(evt);
            }
        });
        add(enterpriseNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 430, 166, -1));

        nameJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJTextFieldActionPerformed(evt);
            }
        });
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 590, 166, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Username");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Manage Enterprise Admin");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Password");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 530, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Name");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 590, -1, -1));

        submitButton.setBackground(new java.awt.Color(255, 204, 204));
        submitButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submitButton.setText("Submit Changes");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 650, 170, -1));

        viewAccountButton.setBackground(new java.awt.Color(255, 204, 204));
        viewAccountButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewAccountButton.setText("View Admin");
        viewAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAccountButtonActionPerformed(evt);
            }
        });
        add(viewAccountButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, 140, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Enterprise");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, -1, -1));

        usernameJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usernameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameJTextFieldActionPerformed(evt);
            }
        });
        add(usernameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 480, 166, -1));

        networkNameJTextField.setEditable(false);
        networkNameJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        networkNameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkNameJTextFieldActionPerformed(evt);
            }
        });
        add(networkNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 380, 166, -1));

        backButton.setBackground(new java.awt.Color(255, 204, 204));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 640, 120, -1));

        backButton1.setBackground(new java.awt.Color(255, 204, 204));
        backButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backButton1.setText("Add Admin");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });
        add(backButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 290, 120, -1));

        refreshButton.setBackground(new java.awt.Color(255, 204, 204));
        refreshButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 290, 120, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void passwordJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordJTextFieldActionPerformed

    private void enterpriseNameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseNameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterpriseNameJTextFieldActionPerformed

    private void nameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameJTextFieldActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        username = enterpriseNameJTextField.getText();
        password = passwordJTextField.getText();
        name = nameJTextField.getText();
        enterpriseName= enterpriseNameJTextField.getText();
        networkName= networkNameJTextField.getText();
       
        if (!(username.isEmpty()) && !(password.isEmpty()) && !(name.isEmpty())) {
           
            userAccount.setUsername(username);
            userAccount.setPassword(password);
            userAccount.getEmployee().setName(name);
            JOptionPane.showMessageDialog(null, "Details Submitted");
            populate();
        } else {
            JOptionPane.showMessageDialog(null, "Please enter all the fields");
        }
        networkNameJTextField.setText(null);
        enterpriseNameJTextField.setText(null);
        usernameJTextField.setText(null);
        passwordJTextField.setText(null);
        nameJTextField.setText(null);

    }//GEN-LAST:event_submitButtonActionPerformed

    private void viewAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAccountButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = useraccountTable.getSelectedRow();
        if (selectedRow >= 0) {
            enterpriseName= String.valueOf(useraccountTable.getValueAt(selectedRow, 0));
            networkName= String.valueOf(useraccountTable.getValueAt(selectedRow, 1));
            enterpriseType= String.valueOf(useraccountTable.getValueAt(selectedRow, 2));
            userAccount= (UserAccount)(useraccountTable.getValueAt(selectedRow, 3));
            username= userAccount.getUsername();
            password= String.valueOf(useraccountTable.getValueAt(selectedRow, 4));
            
            enterpriseNameJTextField.setText(enterpriseName);
            networkNameJTextField.setText(networkName);
            usernameJTextField.setText(username);
            passwordJTextField.setText(password);
            nameJTextField.setText(userAccount.getEmployee().getName());
            
        
        }else if (selectedRow > 1) {
            JOptionPane.showMessageDialog(null, "Please select only one row");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
        
    }//GEN-LAST:event_viewAccountButtonActionPerformed

    private void usernameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameJTextFieldActionPerformed

    private void networkNameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkNameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_networkNameJTextFieldActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        // TODO add your handling code here:
        AddAdminJPanel addAdminJPanel = new AddAdminJPanel(userProcessContainer, system);
         userProcessContainer.add("AddAdminJPanel", addAdminJPanel);
         CardLayout layout = (CardLayout) userProcessContainer.getLayout();
         layout.next(userProcessContainer);
    }//GEN-LAST:event_backButton1ActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        populate();
    }//GEN-LAST:event_refreshButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton backButton1;
    private javax.swing.JTextField enterpriseNameJTextField;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTextField networkNameJTextField;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JTable useraccountTable;
    private javax.swing.JTextField usernameJTextField;
    private javax.swing.JButton viewAccountButton;
    // End of variables declaration//GEN-END:variables
}
