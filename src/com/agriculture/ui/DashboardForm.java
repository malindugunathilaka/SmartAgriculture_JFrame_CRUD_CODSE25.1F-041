/*
 * DashboardForm.java - Main Dashboard for Smart Agriculture System
 */
package com.agriculture.ui;

public class DashboardForm extends javax.swing.JFrame {

    public DashboardForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnFarmer = new javax.swing.JButton();
        btnCrop = new javax.swing.JButton();
        btnSeason = new javax.swing.JButton();
        btnProduction = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblSubtitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Smart Agriculture System - Dashboard");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(34, 139, 34));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 28));
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Smart Agriculture System");

        lblSubtitle.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lblSubtitle.setForeground(new java.awt.Color(255, 255, 255));
        lblSubtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubtitle.setText("Farmer Production Management");

        btnFarmer.setBackground(new java.awt.Color(255, 255, 255));
        btnFarmer.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnFarmer.setForeground(new java.awt.Color(34, 139, 34));
        btnFarmer.setText("Farmer Management");
        btnFarmer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFarmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFarmerActionPerformed(evt);
            }
        });

        btnCrop.setBackground(new java.awt.Color(255, 255, 255));
        btnCrop.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnCrop.setForeground(new java.awt.Color(34, 139, 34));
        btnCrop.setText("Crop Management");
        btnCrop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCropActionPerformed(evt);
            }
        });

        btnSeason.setBackground(new java.awt.Color(255, 255, 255));
        btnSeason.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnSeason.setForeground(new java.awt.Color(34, 139, 34));
        btnSeason.setText("Season Management");
        btnSeason.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeasonActionPerformed(evt);
            }
        });

        btnProduction.setBackground(new java.awt.Color(255, 255, 255));
        btnProduction.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnProduction.setForeground(new java.awt.Color(34, 139, 34));
        btnProduction.setText("Production Entry");
        btnProduction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProduction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductionActionPerformed(evt);
            }
        });

        btnReports.setBackground(new java.awt.Color(255, 255, 255));
        btnReports.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnReports.setForeground(new java.awt.Color(34, 139, 34));
        btnReports.setText("Reports");
        btnReports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(220, 53, 69));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Exit");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFarmer, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrop, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeason, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProduction, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitle)
                .addGap(5, 5, 5)
                .addComponent(lblSubtitle)
                .addGap(30, 30, 30)
                .addComponent(btnFarmer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnCrop, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnSeason, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnProduction, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void btnFarmerActionPerformed(java.awt.event.ActionEvent evt) {
        new FarmerForm().setVisible(true);
    }

    private void btnCropActionPerformed(java.awt.event.ActionEvent evt) {
        new CropForm().setVisible(true);
    }

    private void btnSeasonActionPerformed(java.awt.event.ActionEvent evt) {
        new SeasonForm().setVisible(true);
    }

    private void btnProductionActionPerformed(java.awt.event.ActionEvent evt) {
        new ProductionForm().setVisible(true);
    }

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {
        new ReportForm().setVisible(true);
    }

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnCrop;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFarmer;
    private javax.swing.JButton btnProduction;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton btnSeason;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration
}
