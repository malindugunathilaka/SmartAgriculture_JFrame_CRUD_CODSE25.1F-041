/*
 * FarmerForm.java - Farmer Management CRUD Form
 */
package com.agriculture.ui;

import com.agriculture.dao.FarmerDAO;
import com.agriculture.model.Farmer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FarmerForm extends javax.swing.JFrame {

    private FarmerDAO farmerDAO = new FarmerDAO();
    private DefaultTableModel tableModel;
    private int selectedId = -1;

    public FarmerForm() {
        initComponents();
        setLocationRelativeTo(null);
        initTable();
        loadData();
    }

    private void initTable() {
        tableModel = new DefaultTableModel(
            new String[]{"ID", "Name", "NIC", "Address", "Contact"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblFarmers.setModel(tableModel);
        tblFarmers.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblFarmers.getSelectedRow() != -1) {
                int row = tblFarmers.getSelectedRow();
                selectedId = (int) tableModel.getValueAt(row, 0);
                txtName.setText((String) tableModel.getValueAt(row, 1));
                txtNIC.setText((String) tableModel.getValueAt(row, 2));
                txtAddress.setText((String) tableModel.getValueAt(row, 3));
                txtContact.setText((String) tableModel.getValueAt(row, 4));
            }
        });
    }

    private void loadData() {
        tableModel.setRowCount(0);
        List<Farmer> farmers = farmerDAO.getAll();
        for (Farmer f : farmers) {
            tableModel.addRow(new Object[]{
                f.getFarmerId(), f.getFarmerName(), f.getNic(), f.getAddress(), f.getContactNo()
            });
        }
    }

    private void clearFields() {
        selectedId = -1;
        txtName.setText("");
        txtNIC.setText("");
        txtAddress.setText("");
        txtContact.setText("");
        tblFarmers.clearSelection();
        txtName.requestFocus();
    }

    private boolean validateFields() {
        if (txtName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Farmer Name", "Validation", JOptionPane.WARNING_MESSAGE);
            txtName.requestFocus();
            return false;
        }
        if (txtNIC.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter NIC", "Validation", JOptionPane.WARNING_MESSAGE);
            txtNIC.requestFocus();
            return false;
        }
        String nic = txtNIC.getText().trim();
        if (!nic.matches("^[0-9]{9}[VvXx]$") && !nic.matches("^[0-9]{12}$")) {
            JOptionPane.showMessageDialog(this, "Invalid NIC format!\nUse: 123456789V or 200012345678", "Validation", JOptionPane.WARNING_MESSAGE);
            txtNIC.requestFocus();
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblNIC = new javax.swing.JLabel();
        txtNIC = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblContact = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFarmers = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Farmer Management");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(34, 139, 34));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24));
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Farmer Management");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitle)
                .addGap(15, 15, 15))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lblName.setText("Farmer Name:");

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14));

        lblNIC.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lblNIC.setText("NIC:");

        txtNIC.setFont(new java.awt.Font("Segoe UI", 0, 14));

        lblAddress.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lblAddress.setText("Address:");

        txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 14));

        lblContact.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lblContact.setText("Contact No:");

        txtContact.setFont(new java.awt.Font("Segoe UI", 0, 14));

        tblFarmers.setFont(new java.awt.Font("Segoe UI", 0, 12));
        tblFarmers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Name", "NIC", "Address", "Contact"}
        ));
        tblFarmers.setRowHeight(25);
        jScrollPane1.setViewportView(tblFarmers);

        btnSave.setBackground(new java.awt.Color(40, 167, 69));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 123, 255));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(220, 53, 69));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(108, 117, 125));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(52, 58, 64));
        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Close");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(lblNIC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName)
                            .addComponent(txtNIC)
                            .addComponent(txtAddress)
                            .addComponent(txtContact)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNIC)
                    .addComponent(txtNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContact)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        if (!validateFields()) return;
        
        if (farmerDAO.isNicExists(txtNIC.getText().trim(), 0)) {
            JOptionPane.showMessageDialog(this, "NIC already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Farmer farmer = new Farmer(
            txtName.getText().trim(),
            txtNIC.getText().trim(),
            txtAddress.getText().trim(),
            txtContact.getText().trim()
        );
        
        if (farmerDAO.insert(farmer)) {
            JOptionPane.showMessageDialog(this, "Farmer saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadData();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to save farmer!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a farmer to update", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!validateFields()) return;
        
        if (farmerDAO.isNicExists(txtNIC.getText().trim(), selectedId)) {
            JOptionPane.showMessageDialog(this, "NIC already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Farmer farmer = new Farmer();
        farmer.setFarmerId(selectedId);
        farmer.setFarmerName(txtName.getText().trim());
        farmer.setNic(txtNIC.getText().trim());
        farmer.setAddress(txtAddress.getText().trim());
        farmer.setContactNo(txtContact.getText().trim());
        
        if (farmerDAO.update(farmer)) {
            JOptionPane.showMessageDialog(this, "Farmer updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadData();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update farmer!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a farmer to delete", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete this farmer?", 
            "Confirm Delete", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            if (farmerDAO.delete(selectedId)) {
                JOptionPane.showMessageDialog(this, "Farmer deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadData();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete farmer!\nMay have production records.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {
        clearFields();
    }

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblNIC;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblFarmers;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtNIC;
    private javax.swing.JTextField txtName;
    // End of variables declaration
}
