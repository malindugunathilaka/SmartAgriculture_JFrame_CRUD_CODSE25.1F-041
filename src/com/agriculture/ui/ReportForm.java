package com.agriculture.ui;

import com.agriculture.dao.DatabaseConnection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ReportForm extends javax.swing.JFrame {
    public ReportForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Generate Reports");

        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(245, 245, 245));
        panel.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("REPORT CENTER", JLabel.CENTER);
        title.setFont(new java.awt.Font("Segoe UI", 1, 20));
        title.setForeground(new java.awt.Color(70, 130, 180));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 1;
        panel.add(title, gbc);

        JButton btnFarmerReport = createButton("Farmer Crop Summary Report", new java.awt.Color(46, 139, 87));
        JButton btnSeasonReport = createButton("Season-wise Production Report", new java.awt.Color(70, 130, 180));
        JButton btnCropReport = createButton("Crop Production Analysis", new java.awt.Color(255, 140, 0));
        JButton btnClose = createButton("Close", new java.awt.Color(128, 128, 128));

        gbc.gridy = 1; panel.add(btnFarmerReport, gbc);
        gbc.gridy = 2; panel.add(btnSeasonReport, gbc);
        gbc.gridy = 3; panel.add(btnCropReport, gbc);
        gbc.gridy = 4; panel.add(btnClose, gbc);

        btnFarmerReport.addActionListener(e -> generateReport("farmer"));
        btnSeasonReport.addActionListener(e -> generateReport("season"));
        btnCropReport.addActionListener(e -> generateReport("crop"));
        btnClose.addActionListener(e -> dispose());

        add(panel);
        setSize(400, 350);
    }

    private JButton createButton(String text, java.awt.Color bg) {
        JButton btn = new JButton(text);
        btn.setBackground(bg); btn.setForeground(java.awt.Color.WHITE);
        btn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btn.setPreferredSize(new java.awt.Dimension(280, 40));
        return btn;
    }

    private void generateReport(String type) {
        String sql = "", title = "";
        String[] columns = null;
        switch (type) {
            case "farmer": title = "Farmer Crop Summary"; columns = new String[]{"Farmer", "Crop", "Season", "Year", "Qty (kg)"};
                sql = "SELECT f.farmer_name, c.crop_name, s.season_name, s.year, p.quantity FROM production p JOIN farmer f ON p.farmer_id = f.farmer_id JOIN crop c ON p.crop_id = c.crop_id JOIN season s ON p.season_id = s.season_id ORDER BY f.farmer_name"; break;
            case "season": title = "Season Production"; columns = new String[]{"Season", "Year", "Crop", "Total (kg)"};
                sql = "SELECT s.season_name, s.year, c.crop_name, SUM(p.quantity) FROM production p JOIN crop c ON p.crop_id = c.crop_id JOIN season s ON p.season_id = s.season_id GROUP BY s.season_id, c.crop_id ORDER BY s.year DESC"; break;
            case "crop": title = "Crop Analysis"; columns = new String[]{"Crop", "Type", "Farmers", "Total (kg)", "Avg (kg)"};
                sql = "SELECT c.crop_name, c.crop_type, COUNT(DISTINCT p.farmer_id), SUM(p.quantity), AVG(p.quantity) FROM crop c LEFT JOIN production p ON c.crop_id = p.crop_id GROUP BY c.crop_id"; break;
        }
        try {
            Statement stmt = DatabaseConnection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            while (rs.next()) { Object[] row = new Object[columns.length]; for (int i = 0; i < columns.length; i++) row[i] = rs.getObject(i + 1); model.addRow(row); }
            JTable table = new JTable(model);
            JScrollPane sp = new JScrollPane(table); sp.setPreferredSize(new java.awt.Dimension(600, 350));
            JOptionPane.showMessageDialog(this, sp, title, JOptionPane.PLAIN_MESSAGE);
            rs.close(); stmt.close();
        } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage()); }
    }
}
