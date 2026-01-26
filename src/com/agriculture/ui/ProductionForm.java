package com.agriculture.ui;

import com.agriculture.dao.*;
import com.agriculture.model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProductionForm extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    private JTextField txtProductionId, txtQuantity;
    private JComboBox<String> cmbFarmer, cmbCrop, cmbSeason;
    private JTable tblProduction;

    public ProductionForm() {
        initComponents();
        setLocationRelativeTo(null);
        loadComboBoxes();
        loadProductionData();
    }

    private void loadComboBoxes() {
        cmbFarmer.removeAllItems();
        for (Farmer f : FarmerDAO.getAllFarmers()) cmbFarmer.addItem(f.getFarmerId() + " - " + f.getFarmerName());
        cmbCrop.removeAllItems();
        for (Crop c : CropDAO.getAllCrops()) cmbCrop.addItem(c.getCropId() + " - " + c.getCropName());
        cmbSeason.removeAllItems();
        for (Season s : SeasonDAO.getAllSeasons()) cmbSeason.addItem(s.getSeasonId() + " - " + s.getSeasonName() + " " + s.getYear());
    }

    private void loadProductionData() {
        tableModel.setRowCount(0);
        for (Production p : ProductionDAO.getAllProduction()) {
            tableModel.addRow(new Object[]{p.getProductionId(), p.getFarmerName(), p.getCropName(), p.getSeasonName(), p.getQuantity()});
        }
    }

    private int getIdFromCombo(String item) { return Integer.parseInt(item.split(" - ")[0]); }

    private void clearForm() {
        txtProductionId.setText(""); txtQuantity.setText("");
        if (cmbFarmer.getItemCount() > 0) cmbFarmer.setSelectedIndex(0);
        if (cmbCrop.getItemCount() > 0) cmbCrop.setSelectedIndex(0);
        if (cmbSeason.getItemCount() > 0) cmbSeason.setSelectedIndex(0);
        tblProduction.clearSelection();
    }

    private void initComponents() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Production Entry");
        
        JPanel panel = new JPanel(new java.awt.BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new java.awt.Color(245, 245, 245));

        JPanel formPanel = new JPanel(new java.awt.GridLayout(2, 6, 5, 5));
        formPanel.setBackground(java.awt.Color.WHITE);
        formPanel.setBorder(BorderFactory.createTitledBorder("Production Details"));
        formPanel.add(new JLabel("ID:")); txtProductionId = new JTextField(); txtProductionId.setEditable(false); formPanel.add(txtProductionId);
        formPanel.add(new JLabel("Farmer:")); cmbFarmer = new JComboBox<>(); formPanel.add(cmbFarmer);
        formPanel.add(new JLabel("Crop:")); cmbCrop = new JComboBox<>(); formPanel.add(cmbCrop);
        formPanel.add(new JLabel("Season:")); cmbSeason = new JComboBox<>(); formPanel.add(cmbSeason);
        formPanel.add(new JLabel("Quantity (kg):")); txtQuantity = new JTextField(); formPanel.add(txtQuantity);
        formPanel.add(new JLabel("")); formPanel.add(new JLabel(""));

        JPanel btnPanel = new JPanel();
        JButton btnSave = new JButton("Save"); btnSave.setBackground(new java.awt.Color(46, 139, 87)); btnSave.setForeground(java.awt.Color.WHITE);
        JButton btnUpdate = new JButton("Update"); btnUpdate.setBackground(new java.awt.Color(70, 130, 180)); btnUpdate.setForeground(java.awt.Color.WHITE);
        JButton btnDelete = new JButton("Delete"); btnDelete.setBackground(new java.awt.Color(178, 34, 34)); btnDelete.setForeground(java.awt.Color.WHITE);
        JButton btnClear = new JButton("Clear"); btnClear.setBackground(new java.awt.Color(255, 140, 0)); btnClear.setForeground(java.awt.Color.WHITE);
        JButton btnClose = new JButton("Close"); btnClose.setBackground(new java.awt.Color(128, 128, 128)); btnClose.setForeground(java.awt.Color.WHITE);
        btnPanel.add(btnSave); btnPanel.add(btnUpdate); btnPanel.add(btnDelete); btnPanel.add(btnClear); btnPanel.add(btnClose);

        btnSave.addActionListener(e -> { try { Production p = new Production(getIdFromCombo(cmbFarmer.getSelectedItem().toString()), getIdFromCombo(cmbCrop.getSelectedItem().toString()), getIdFromCombo(cmbSeason.getSelectedItem().toString()), Double.parseDouble(txtQuantity.getText())); if (ProductionDAO.insertProduction(p)) { JOptionPane.showMessageDialog(this, "Saved!"); clearForm(); loadProductionData(); }} catch (Exception ex) { JOptionPane.showMessageDialog(this, "Enter valid quantity!"); }});
        btnUpdate.addActionListener(e -> { if (txtProductionId.getText().isEmpty()) return; try { Production p = new Production(); p.setProductionId(Integer.parseInt(txtProductionId.getText())); p.setFarmerId(getIdFromCombo(cmbFarmer.getSelectedItem().toString())); p.setCropId(getIdFromCombo(cmbCrop.getSelectedItem().toString())); p.setSeasonId(getIdFromCombo(cmbSeason.getSelectedItem().toString())); p.setQuantity(Double.parseDouble(txtQuantity.getText())); if (ProductionDAO.updateProduction(p)) { JOptionPane.showMessageDialog(this, "Updated!"); clearForm(); loadProductionData(); }} catch (Exception ex) {}});
        btnDelete.addActionListener(e -> { if (txtProductionId.getText().isEmpty()) return; if (JOptionPane.showConfirmDialog(this, "Delete?") == 0) { ProductionDAO.deleteProduction(Integer.parseInt(txtProductionId.getText())); clearForm(); loadProductionData(); }});
        btnClear.addActionListener(e -> clearForm());
        btnClose.addActionListener(e -> dispose());

        tableModel = new DefaultTableModel(new String[]{"ID", "Farmer", "Crop", "Season", "Quantity"}, 0);
        tblProduction = new JTable(tableModel);
        tblProduction.setRowHeight(25);
        tblProduction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) { int r = tblProduction.getSelectedRow(); if (r >= 0) { txtProductionId.setText(tableModel.getValueAt(r, 0).toString()); txtQuantity.setText(tableModel.getValueAt(r, 4).toString()); }}
        });

        JPanel topPanel = new JPanel(new java.awt.BorderLayout());
        topPanel.add(formPanel, java.awt.BorderLayout.CENTER);
        topPanel.add(btnPanel, java.awt.BorderLayout.SOUTH);
        panel.add(topPanel, java.awt.BorderLayout.NORTH);
        panel.add(new JScrollPane(tblProduction), java.awt.BorderLayout.CENTER);
        add(panel);
        setSize(750, 500);
    }
}
