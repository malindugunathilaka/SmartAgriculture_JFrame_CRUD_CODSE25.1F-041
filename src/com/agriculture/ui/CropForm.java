package com.agriculture.ui;

import com.agriculture.dao.CropDAO;
import com.agriculture.model.Crop;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CropForm extends javax.swing.JFrame {
    private DefaultTableModel tableModel;

    public CropForm() {
        initComponents();
        setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) tblCrops.getModel();
        loadCropData();
    }

    private void loadCropData() {
        tableModel.setRowCount(0);
        List<Crop> crops = CropDAO.getAllCrops();
        for (Crop crop : crops) {
            tableModel.addRow(new Object[]{crop.getCropId(), crop.getCropName(), crop.getCropType()});
        }
    }

    private void clearForm() {
        txtCropId.setText("");
        txtCropName.setText("");
        cmbCropType.setSelectedIndex(0);
        tblCrops.clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCropId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCropName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbCropType = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCrops = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crop Management");

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Crop Details"));

        jLabel1.setText("Crop ID:");
        txtCropId.setEditable(false);
        txtCropId.setBackground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Crop Name:");
        jLabel3.setText("Crop Type:");
        cmbCropType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Cereal", "Vegetable", "Fruit", "Pulse", "Spice", "Other"}));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createSequentialGroup().addGap(10)
            .addComponent(jLabel1).addGap(5).addComponent(txtCropId, 80, 80, 80).addGap(20)
            .addComponent(jLabel2).addGap(5).addComponent(txtCropName, 150, 150, 150).addGap(20)
            .addComponent(jLabel3).addGap(5).addComponent(cmbCropType, 120, 120, 120).addGap(10));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createSequentialGroup().addGap(15)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1).addComponent(txtCropId).addComponent(jLabel2).addComponent(txtCropName)
                .addComponent(jLabel3).addComponent(cmbCropType)).addGap(15));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        btnSave = createButton("Save", new java.awt.Color(46, 139, 87));
        btnUpdate = createButton("Update", new java.awt.Color(70, 130, 180));
        btnDelete = createButton("Delete", new java.awt.Color(178, 34, 34));
        btnClear = createButton("Clear", new java.awt.Color(255, 140, 0));
        btnClose = createButton("Close", new java.awt.Color(128, 128, 128));

        btnSave.addActionListener(e -> {
            if (txtCropName.getText().trim().isEmpty()) { JOptionPane.showMessageDialog(this, "Crop name required!"); return; }
            if (CropDAO.insertCrop(new Crop(txtCropName.getText().trim(), cmbCropType.getSelectedItem().toString()))) {
                JOptionPane.showMessageDialog(this, "Saved!"); clearForm(); loadCropData();
            }
        });
        btnUpdate.addActionListener(e -> {
            if (txtCropId.getText().isEmpty()) return;
            Crop c = new Crop(); c.setCropId(Integer.parseInt(txtCropId.getText()));
            c.setCropName(txtCropName.getText().trim()); c.setCropType(cmbCropType.getSelectedItem().toString());
            if (CropDAO.updateCrop(c)) { JOptionPane.showMessageDialog(this, "Updated!"); clearForm(); loadCropData(); }
        });
        btnDelete.addActionListener(e -> {
            if (txtCropId.getText().isEmpty()) return;
            if (JOptionPane.showConfirmDialog(this, "Delete?") == 0) { CropDAO.deleteCrop(Integer.parseInt(txtCropId.getText())); clearForm(); loadCropData(); }
        });
        btnClear.addActionListener(e -> clearForm());
        btnClose.addActionListener(e -> dispose());

        jPanel3.add(btnSave); jPanel3.add(btnUpdate); jPanel3.add(btnDelete); jPanel3.add(btnClear); jPanel3.add(btnClose);

        tblCrops = new javax.swing.JTable(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"ID", "Crop Name", "Type"}));
        tblCrops.setRowHeight(25);
        tblCrops.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int r = tblCrops.getSelectedRow();
                if (r >= 0) { txtCropId.setText(tableModel.getValueAt(r, 0).toString()); txtCropName.setText(tableModel.getValueAt(r, 1).toString()); cmbCropType.setSelectedItem(tableModel.getValueAt(r, 2)); }
            }
        });
        jScrollPane1.setViewportView(tblCrops);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup().addGroup(jPanel1Layout.createSequentialGroup().addGap(10)
            .addGroup(jPanel1Layout.createParallelGroup().addComponent(jPanel2).addComponent(jPanel3).addComponent(jScrollPane1, 600, 600, 600)).addGap(10)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup().addGap(10).addComponent(jPanel2).addGap(5)
            .addComponent(jPanel3, 50, 50, 50).addGap(5).addComponent(jScrollPane1, 250, 250, 250).addGap(10));

        getContentPane().add(jPanel1);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private javax.swing.JButton createButton(String text, java.awt.Color bg) {
        javax.swing.JButton btn = new javax.swing.JButton(text);
        btn.setBackground(bg); btn.setForeground(java.awt.Color.WHITE);
        btn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        return btn;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear, btnClose, btnDelete, btnSave, btnUpdate;
    private javax.swing.JComboBox<String> cmbCropType;
    private javax.swing.JLabel jLabel1, jLabel2, jLabel3;
    private javax.swing.JPanel jPanel1, jPanel2, jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCrops;
    private javax.swing.JTextField txtCropId, txtCropName;
    // End of variables declaration//GEN-END:variables
}
