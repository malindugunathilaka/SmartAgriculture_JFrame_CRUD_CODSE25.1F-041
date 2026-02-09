package com.agriculture.ui;

import com.agriculture.dao.ProductionDAO;
import com.agriculture.util.ReportManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Reports Form - View various reports
 */
public class ReportForm extends javax.swing.JFrame {

    private ProductionDAO productionDAO;

    public ReportForm() {
        initComponents();
        productionDAO = new ProductionDAO();
        setLocationRelativeTo(null);
    }

    private void showReportDialog(String title, String content) {
        JTextArea textArea = new JTextArea(content);
        textArea.setEditable(false);
        textArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
        textArea.setCaretPosition(0);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(600, 400));

        JOptionPane.showMessageDialog(this, scrollPane, title, JOptionPane.PLAIN_MESSAGE);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnFarmerCropSummary = new javax.swing.JButton();
        lblFarmerCrop = new javax.swing.JLabel();
        btnSeasonProduction = new javax.swing.JButton();
        lblSeason = new javax.swing.JLabel();
        btnCropAnalysis = new javax.swing.JButton();
        lblCrop = new javax.swing.JLabel();
        btnAllProductions = new javax.swing.JButton();
        lblAll = new javax.swing.JLabel();
        btnJasperReport = new javax.swing.JButton();
        lblJasper = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reports");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reports & Analytics");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addGap(20, 20, 20)));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Available Reports"));

        btnFarmerCropSummary.setBackground(new java.awt.Color(0, 102, 204));
        btnFarmerCropSummary.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnFarmerCropSummary.setForeground(new java.awt.Color(255, 255, 255));
        btnFarmerCropSummary.setText("Farmer-Crop Summary");
        btnFarmerCropSummary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFarmerCropSummaryActionPerformed(evt);
            }
        });

        lblFarmerCrop.setText("View total production by each farmer for each crop");

        btnSeasonProduction.setBackground(new java.awt.Color(0, 153, 51));
        btnSeasonProduction.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnSeasonProduction.setForeground(new java.awt.Color(255, 255, 255));
        btnSeasonProduction.setText("Season Production");
        btnSeasonProduction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeasonProductionActionPerformed(evt);
            }
        });

        lblSeason.setText("View total production for each season");

        btnCropAnalysis.setBackground(new java.awt.Color(255, 140, 0));
        btnCropAnalysis.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnCropAnalysis.setForeground(new java.awt.Color(255, 255, 255));
        btnCropAnalysis.setText("Crop Analysis");
        btnCropAnalysis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCropAnalysisActionPerformed(evt);
            }
        });

        lblCrop.setText("View total quantity, average, and farmer count for each crop");

        btnAllProductions.setBackground(new java.awt.Color(128, 0, 128));
        btnAllProductions.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnAllProductions.setForeground(new java.awt.Color(255, 255, 255));
        btnAllProductions.setText("All Productions");
        btnAllProductions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllProductionsActionPerformed(evt);
            }
        });

        lblAll.setText("View complete production records list");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(btnFarmerCropSummary,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblFarmerCrop))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(btnSeasonProduction,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblSeason))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(btnCropAnalysis, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblCrop))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(btnAllProductions, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblAll))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(btnJasperReport, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblJasper)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnFarmerCropSummary, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblFarmerCrop))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSeasonProduction, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblSeason))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCropAnalysis, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblCrop))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAllProductions, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblAll))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnJasperReport, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblJasper))
                                .addContainerGap(20, Short.MAX_VALUE)));

        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClose)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
        btnJasperReport.setBackground(new java.awt.Color(204, 0, 0));
        btnJasperReport.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnJasperReport.setForeground(new java.awt.Color(255, 255, 255));
        btnJasperReport.setText("Print PDF Report");
        btnJasperReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJasperReportActionPerformed(evt);
            }
        });

        lblJasper.setText("Generate professional PDF report using JasperReports");

    }// </editor-fold>//GEN-END:initComponents

    private void btnJasperReportActionPerformed(java.awt.event.ActionEvent evt) {
        Map<String, Object> parameters = new HashMap<>();
        ReportManager.showReport("farmer_crop_report.jrxml", parameters);
    }

    private void btnFarmerCropSummaryActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFarmerCropSummaryActionPerformed
        List<Map<String, Object>> data = productionDAO.getFarmerCropSummary();

        if (data.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No production data found!", "Report", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-25s %-20s %15s%n", "FARMER NAME", "CROP NAME", "TOTAL QTY (kg)"));
        sb.append("=".repeat(65)).append("\n");

        for (Map<String, Object> row : data) {
            sb.append(String.format("%-25s %-20s %15.2f%n",
                    row.get("farmer_name"),
                    row.get("crop_name"),
                    row.get("total_quantity")));
        }

        sb.append("=".repeat(65)).append("\n");
        sb.append("Total Records: ").append(data.size());

        showReportDialog("Farmer-Crop Production Summary", sb.toString());
    }// GEN-LAST:event_btnFarmerCropSummaryActionPerformed

    private void btnSeasonProductionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSeasonProductionActionPerformed
        List<Map<String, Object>> data = productionDAO.getSeasonProduction();

        if (data.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No production data found!", "Report", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-25s %10s %15s%n", "SEASON NAME", "YEAR", "TOTAL QTY (kg)"));
        sb.append("=".repeat(55)).append("\n");

        double grandTotal = 0;
        for (Map<String, Object> row : data) {
            double qty = ((Number) row.get("total_quantity")).doubleValue();
            grandTotal += qty;
            sb.append(String.format("%-25s %10s %15.2f%n",
                    row.get("season_name"),
                    row.get("year"),
                    qty));
        }

        sb.append("=".repeat(55)).append("\n");
        sb.append(String.format("%-36s %15.2f%n", "GRAND TOTAL:", grandTotal));

        showReportDialog("Season Production Report", sb.toString());
    }// GEN-LAST:event_btnSeasonProductionActionPerformed

    private void btnCropAnalysisActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCropAnalysisActionPerformed
        List<Map<String, Object>> data = productionDAO.getCropAnalysis();

        if (data.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No production data found!", "Report", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-20s %12s %15s %15s %10s%n",
                "CROP NAME", "CROP TYPE", "TOTAL QTY (kg)", "AVG QTY (kg)", "FARMERS"));
        sb.append("=".repeat(78)).append("\n");

        for (Map<String, Object> row : data) {
            sb.append(String.format("%-20s %12s %15.2f %15.2f %10d%n",
                    row.get("crop_name"),
                    row.get("crop_type"),
                    row.get("total_quantity"),
                    row.get("avg_quantity"),
                    row.get("farmer_count")));
        }

        sb.append("=".repeat(78)).append("\n");
        sb.append("Total Crops: ").append(data.size());

        showReportDialog("Crop Analysis Report", sb.toString());
    }// GEN-LAST:event_btnCropAnalysisActionPerformed

    private void btnAllProductionsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAllProductionsActionPerformed
        List<com.agriculture.model.Production> data = productionDAO.getAllProductions();

        if (data.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No production records found!", "Report",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-5s %-20s %-15s %-20s %12s%n",
                "ID", "FARMER", "CROP", "SEASON", "QTY (kg)"));
        sb.append("=".repeat(78)).append("\n");

        double total = 0;
        for (com.agriculture.model.Production p : data) {
            total += p.getQuantity();
            sb.append(String.format("%-5d %-20s %-15s %-20s %12.2f%n",
                    p.getProductionId(),
                    truncate(p.getFarmerName(), 18),
                    truncate(p.getCropName(), 13),
                    truncate(p.getSeasonName(), 18),
                    p.getQuantity()));
        }

        sb.append("=".repeat(78)).append("\n");
        sb.append(String.format("Total Records: %d | Total Quantity: %.2f kg%n", data.size(), total));

        showReportDialog("All Production Records", sb.toString());
    }// GEN-LAST:event_btnAllProductionsActionPerformed

    private String truncate(String str, int maxLen) {
        if (str == null)
            return "";
        return str.length() > maxLen ? str.substring(0, maxLen - 2) + ".." : str;
    }

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }// GEN-LAST:event_btnCloseActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllProductions;
    private javax.swing.JButton btnJasperReport;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCropAnalysis;
    private javax.swing.JButton btnFarmerCropSummary;
    private javax.swing.JButton btnSeasonProduction;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAll;
    private javax.swing.JLabel lblJasper;
    private javax.swing.JLabel lblCrop;
    private javax.swing.JLabel lblFarmerCrop;
    private javax.swing.JLabel lblSeason;
    // End of variables declaration//GEN-END:variables
}
