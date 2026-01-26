package com.agriculture.ui;

import com.agriculture.dao.SeasonDAO;
import com.agriculture.model.Season;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SeasonForm extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    private javax.swing.JTextField txtSeasonId, txtYear;
    private javax.swing.JComboBox<String> cmbSeasonName;
    private javax.swing.JTable tblSeasons;

    public SeasonForm() {
        initComponents();
        setLocationRelativeTo(null);
        loadSeasonData();
    }

    private void loadSeasonData() {
        tableModel.setRowCount(0);
        for (Season s : SeasonDAO.getAllSeasons()) {
            tableModel.addRow(new Object[]{s.getSeasonId(), s.getSeasonName(), s.getYear()});
        }
    }

    private void clearForm() {
        txtSeasonId.setText(""); cmbSeasonName.setSelectedIndex(0); txtYear.setText(""); tblSeasons.clearSelection();
    }

    private void initComponents() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Season Management");
        
        javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.BorderLayout(5, 5));
        panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.JPanel formPanel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));
        formPanel.setBackground(java.awt.Color.WHITE);
        formPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Season Details"));
        formPanel.add(new javax.swing.JLabel("Season ID:")); txtSeasonId = new javax.swing.JTextField(5); txtSeasonId.setEditable(false); formPanel.add(txtSeasonId);
        formPanel.add(new javax.swing.JLabel("Season:")); cmbSeasonName = new javax.swing.JComboBox<>(new String[]{"Yala", "Maha"}); formPanel.add(cmbSeasonName);
        formPanel.add(new javax.swing.JLabel("Year:")); txtYear = new javax.swing.JTextField(6); formPanel.add(txtYear);

        javax.swing.JPanel btnPanel = new javax.swing.JPanel();
        javax.swing.JButton btnSave = new javax.swing.JButton("Save"); btnSave.setBackground(new java.awt.Color(46, 139, 87)); btnSave.setForeground(java.awt.Color.WHITE);
        javax.swing.JButton btnUpdate = new javax.swing.JButton("Update"); btnUpdate.setBackground(new java.awt.Color(70, 130, 180)); btnUpdate.setForeground(java.awt.Color.WHITE);
        javax.swing.JButton btnDelete = new javax.swing.JButton("Delete"); btnDelete.setBackground(new java.awt.Color(178, 34, 34)); btnDelete.setForeground(java.awt.Color.WHITE);
        javax.swing.JButton btnClear = new javax.swing.JButton("Clear"); btnClear.setBackground(new java.awt.Color(255, 140, 0)); btnClear.setForeground(java.awt.Color.WHITE);
        javax.swing.JButton btnClose = new javax.swing.JButton("Close"); btnClose.setBackground(new java.awt.Color(128, 128, 128)); btnClose.setForeground(java.awt.Color.WHITE);
        btnPanel.add(btnSave); btnPanel.add(btnUpdate); btnPanel.add(btnDelete); btnPanel.add(btnClear); btnPanel.add(btnClose);

        btnSave.addActionListener(e -> { try { if (SeasonDAO.insertSeason(new Season(cmbSeasonName.getSelectedItem().toString(), Integer.parseInt(txtYear.getText())))) { JOptionPane.showMessageDialog(this, "Saved!"); clearForm(); loadSeasonData(); }} catch (Exception ex) { JOptionPane.showMessageDialog(this, "Enter valid year!"); }});
        btnUpdate.addActionListener(e -> { if (txtSeasonId.getText().isEmpty()) return; Season s = new Season(); s.setSeasonId(Integer.parseInt(txtSeasonId.getText())); s.setSeasonName(cmbSeasonName.getSelectedItem().toString()); s.setYear(Integer.parseInt(txtYear.getText())); if (SeasonDAO.updateSeason(s)) { JOptionPane.showMessageDialog(this, "Updated!"); clearForm(); loadSeasonData(); }});
        btnDelete.addActionListener(e -> { if (txtSeasonId.getText().isEmpty()) return; if (JOptionPane.showConfirmDialog(this, "Delete?") == 0) { SeasonDAO.deleteSeason(Integer.parseInt(txtSeasonId.getText())); clearForm(); loadSeasonData(); }});
        btnClear.addActionListener(e -> clearForm());
        btnClose.addActionListener(e -> dispose());

        tableModel = new DefaultTableModel(new String[]{"ID", "Season", "Year"}, 0);
        tblSeasons = new javax.swing.JTable(tableModel);
        tblSeasons.setRowHeight(25);
        tblSeasons.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) { int r = tblSeasons.getSelectedRow(); if (r >= 0) { txtSeasonId.setText(tableModel.getValueAt(r, 0).toString()); cmbSeasonName.setSelectedItem(tableModel.getValueAt(r, 1)); txtYear.setText(tableModel.getValueAt(r, 2).toString()); }}
        });

        javax.swing.JPanel topPanel = new javax.swing.JPanel(new java.awt.BorderLayout());
        topPanel.add(formPanel, java.awt.BorderLayout.CENTER);
        topPanel.add(btnPanel, java.awt.BorderLayout.SOUTH);
        panel.add(topPanel, java.awt.BorderLayout.NORTH);
        panel.add(new javax.swing.JScrollPane(tblSeasons), java.awt.BorderLayout.CENTER);
        add(panel);
        setSize(550, 400);
    }
}
