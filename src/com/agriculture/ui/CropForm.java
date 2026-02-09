/*
 * CropForm.java - Crop Management CRUD Form
 */
package com.agriculture.ui;

import com.agriculture.dao.CropDAO;
import com.agriculture.model.Crop;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CropForm extends javax.swing.JFrame {

    private CropDAO cropDAO = new CropDAO();
    private DefaultTableModel tableModel;
    private int selectedId = -1;

    public CropForm() {
        initComponents();
        setLocationRelativeTo(null);
        initTable();
        loadData();
    }

    private void initTable() {
        tableModel = new DefaultTableModel(
            new String[]{"ID", "Crop Name", "Crop Type"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblCrops.setModel(tableModel);
        tblCrops.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblCrops.getSelectedRow() != -1) {
                int row = tblCrops.getSelectedRow();
                selectedId = (int) tableModel.getValueAt(row, 0);
                txtCropName.setText((String) tableModel.getValueAt(row, 1));
                cmbCropType.setSelectedItem(tableModel.getValueAt(row, 2));
            }
        });
    }

    private void loadData() {
        tableModel.setRowCount(0);
        List<Crop> crops = cropDAO.getAll();
        for (Crop c : crops) {
            tableModel.addRow(new Object[]{c.getCropId(), c.getCropName(), c.getCropType()});
        }
    }

    private void clearFields() {
        selectedId = -1;
        txtCropName.setText("");
        cmbCropType.setSelectedIndex(0);
        tblCrops.clearSelection();
        txtCropName.requestFocus();
    }

    private boolean validateFields() {
        if (txtCropName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Crop Name", "Validation", JOptionPane.WARNING_MESSAGE);
            txtCropName.requestFocus();
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
        lblCropName = new javax.swing.JLabel();
        txtCropName = new javax.swing.JTextField();
        lblCropType = new javax.swing.JLabel();
        cmbCropType = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCrops = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crop Management");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(34, 139, 34));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24));
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Crop Management");

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

        lblCropName.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lblCropName.setText("Crop Name:");

        txtCropName.setFont(new java.awt.Font("Segoe UI", 0, 14));

        lblCropType.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lblCropType.setText("Crop Type:");

        cmbCropType.setFont(new java.awt.Font("Segoe UI", 0, 14));
        cmbCropType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cereal", "Vegetable", "Fruit", "Pulse", "Spice", "Other" }));

        tblCrops.setFont(new java.awt.Font("Segoe UI", 0, 12));
        tblCrops.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Crop Name", "Crop Type"}
        ));
        tblCrops.setRowHeight(25);
        jScrollPane1.setViewportView(tblCrops);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCropName, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(lblCropType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCropName)
                            .addComponent(cmbCropType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCropName)
                    .addComponent(txtCropName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCropType)
                    .addComponent(cmbCropType, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        
        Crop crop = new Crop(
            txtCropName.getText().trim(),
            (String) cmbCropType.getSelectedItem()
        );
        
        if (cropDAO.insert(crop)) {
            JOptionPane.showMessageDialog(this, "Crop saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadData();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to save crop!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a crop to update", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!validateFields()) return;
        
        Crop crop = new Crop();
        crop.setCropId(selectedId);
        crop.setCropName(txtCropName.getText().trim());
        crop.setCropType((String) cmbCropType.getSelectedItem());
        
        if (cropDAO.update(crop)) {
            JOptionPane.showMessageDialog(this, "Crop updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadData();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update crop!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a crop to delete", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete this crop?", 
            "Confirm Delete", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            if (cropDAO.delete(selectedId)) {
                JOptionPane.showMessageDialog(this, "Crop deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadData();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete crop!\nMay have production records.", "Error", JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JComboBox<String> cmbCropType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCropName;
    private javax.swing.JLabel lblCropType;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblCrops;
    private javax.swing.JTextField txtCropName;
    // End of variables declaration
}
