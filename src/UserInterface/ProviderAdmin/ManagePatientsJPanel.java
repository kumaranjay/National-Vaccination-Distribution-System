/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ProviderAdmin;

import Business.CDCSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ProviderEnterprise;
import Business.Organization.Organization;
import Business.Provider.Patient;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danisha
 */
public class ManagePatientsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagePatientsJPanel
     */
    private JPanel userProcessContainer;
    private CDCSystem system;
    private UserAccount account;
    private Enterprise enterprise;
    private Organization organization;
    private ProviderEnterprise pe;

    public ManagePatientsJPanel(JPanel userProcessContainer, CDCSystem system, UserAccount account, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.enterprise = enterprise;
        this.account = account;
        pe = (ProviderEnterprise) enterprise;
        populate();
    }

    public void populate() {
        
        DefaultTableModel dtm = (DefaultTableModel) patientTable.getModel();
        dtm.setRowCount(0);
        for (Patient patient : pe.getPatientDirectory().getPatientList()) {
            Object row[] = new Object[5];
            row[0] = patient;
            row[1] = patient.getPatientName();
            row[2] = patient.getAge();
            row[3] = patient.getInsuranceName();
            row[4] = patient.getContactNo();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        viewPatientButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        billPatientButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        ageTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        contactNumberTextField = new javax.swing.JTextField();
        insuranceNameTextField = new javax.swing.JTextField();
        insuranceTypeComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        insurancePercentageTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Patient Name", "Age", "Insurance Name", "Contact Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(patientTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 50, 950, 130));

        backButton.setBackground(new java.awt.Color(255, 204, 204));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 98, -1));

        viewPatientButton.setBackground(new java.awt.Color(255, 204, 204));
        viewPatientButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewPatientButton.setText("View Patient");
        viewPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPatientButtonActionPerformed(evt);
            }
        });
        add(viewPatientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, -1, -1));

        refreshButton.setBackground(new java.awt.Color(255, 204, 204));
        refreshButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, 98, -1));

        deleteButton.setBackground(new java.awt.Color(255, 204, 204));
        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 200, 98, -1));

        billPatientButton.setBackground(new java.awt.Color(255, 204, 204));
        billPatientButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        billPatientButton.setText("Bill Patient");
        billPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billPatientButtonActionPerformed(evt);
            }
        });
        add(billPatientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 200, 117, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Patient Info");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Last Name");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Age");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Contact Number");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Insurance Name");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Insurance Type");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 550, -1, -1));

        firstNameTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        firstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTextFieldActionPerformed(evt);
            }
        });
        add(firstNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 310, 196, -1));

        ageTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageTextFieldActionPerformed(evt);
            }
        });
        add(ageTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 400, 196, -1));

        lastNameTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextFieldActionPerformed(evt);
            }
        });
        add(lastNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, 196, -1));

        contactNumberTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        contactNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactNumberTextFieldActionPerformed(evt);
            }
        });
        add(contactNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, 196, -1));

        insuranceNameTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        insuranceNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insuranceNameTextFieldActionPerformed(evt);
            }
        });
        add(insuranceNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 500, 196, -1));

        insuranceTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fully Insured", "Partially Insured", "Un-Insured" }));
        insuranceTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insuranceTypeComboBoxActionPerformed(evt);
            }
        });
        add(insuranceTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 550, 196, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("First Name");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, -1, -1));

        submitButton.setBackground(new java.awt.Color(255, 204, 204));
        submitButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 650, 98, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Insurance Percentage");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 590, -1, -1));

        insurancePercentageTextField.setEditable(false);
        insurancePercentageTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        insurancePercentageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insurancePercentageTextFieldActionPerformed(evt);
            }
        });
        add(insurancePercentageTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 590, 196, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Manage Patient");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void viewPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPatientButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = patientTable.getSelectedRow();
        if (selectedRow >= 0) {
            Patient patient = (Patient) patientTable.getValueAt(selectedRow, 0);
            ViewPatientJPanel viewPatientJPanel = new ViewPatientJPanel(userProcessContainer, system, enterprise, patient);
            userProcessContainer.add("ViewPatientJPanel", viewPatientJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else if (selectedRow > 1) {
            JOptionPane.showMessageDialog(null, "Please select only one row");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }

    }//GEN-LAST:event_viewPatientButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        populate();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = patientTable.getSelectedRow();
        if (selectedRow >= 0) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete", "warning", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                Patient patient = (Patient) patientTable.getValueAt(selectedRow, 0);
                for (Patient patient1 : pe.getPatientDirectory().getPatientList()) {
                    if (patient1 == patient) {
                        pe.getPatientDirectory().getPatientList().remove(patient);
                    }
                }
            }
        } else if (selectedRow > 1) {
            JOptionPane.showMessageDialog(null, "Please select only one row");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
        populate();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void billPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billPatientButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = patientTable.getSelectedRow();
        if (selectedRow >= 0) {
            Patient patient = (Patient) patientTable.getValueAt(selectedRow, 0);
            AddBillPatientJPanel addBillPatientJPanel = new AddBillPatientJPanel(userProcessContainer, system,account, enterprise, patient);
            userProcessContainer.add("AddBillPatientJPanel", addBillPatientJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else if (selectedRow > 1) {
            JOptionPane.showMessageDialog(null, "Please select only one row");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
    }//GEN-LAST:event_billPatientButtonActionPerformed

    private void firstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTextFieldActionPerformed

    private void ageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageTextFieldActionPerformed

    private void lastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTextFieldActionPerformed

    private void contactNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactNumberTextFieldActionPerformed

    private void insuranceNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insuranceNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insuranceNameTextFieldActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        try {
            String name = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String contactNo = contactNumberTextField.getText();
            String insuranceName = insuranceNameTextField.getText();
            String age1 = ageTextField.getText();
            String percentage= insurancePercentageTextField.getText();
            int age = Integer.parseInt(ageTextField.getText());
            if (!(name.isEmpty()) && !(lastName.isEmpty()) && !(contactNo.isEmpty()) && !(insuranceName.isEmpty()) && !(age1.isEmpty())) {
                Patient patient = new Patient();
                patient.setAge(age);
                patient.setPatientName(name);
                patient.setContactNo(contactNo);
                patient.setLastName(lastName);
                patient.setInsuranceName(insuranceName);
                String insuranceType = String.valueOf(insuranceTypeComboBox.getSelectedItem());
                patient.setInsuredType(insuranceType);
                if(insuranceType.equals("Partially Insured")){
                    int insurancePercentage= Integer.parseInt(percentage);
                    patient.setInsurancePercentage(insurancePercentage);
                }
                pe.getPatientDirectory().getPatientList().add(patient);
                JOptionPane.showMessageDialog(null, "Details Submitted");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter appropriate details");
        }
        populate();
        firstNameTextField.setText(null);
        lastNameTextField.setText(null);
        contactNumberTextField.setText(null);
        insuranceNameTextField.setText(null);
        ageTextField.setText(null);
        insuranceTypeComboBox.setSelectedIndex(0);
        insurancePercentageTextField.setText(null);

    }//GEN-LAST:event_submitButtonActionPerformed

    private void insurancePercentageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insurancePercentageTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insurancePercentageTextFieldActionPerformed

    private void insuranceTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insuranceTypeComboBoxActionPerformed
        // TODO add your handling code here:
        String insuranceType= String.valueOf(insuranceTypeComboBox.getSelectedItem());
        if(insuranceType.equals("Partially Insured")){
            insurancePercentageTextField.setEditable(true);
        }
        else{
            insurancePercentageTextField.setEditable(false);
        }
    }//GEN-LAST:event_insuranceTypeComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageTextField;
    private javax.swing.JButton backButton;
    private javax.swing.JButton billPatientButton;
    private javax.swing.JTextField contactNumberTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JTextField insuranceNameTextField;
    private javax.swing.JTextField insurancePercentageTextField;
    private javax.swing.JComboBox insuranceTypeComboBox;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JTable patientTable;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton viewPatientButton;
    // End of variables declaration//GEN-END:variables
}
