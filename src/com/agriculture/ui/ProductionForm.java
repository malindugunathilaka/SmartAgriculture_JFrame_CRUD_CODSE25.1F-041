package com.agriculture.ui;

import com.agriculture.dao.CropDAO;
import com.agriculture.dao.FarmerDAO;
import com.agriculture.dao.ProductionDAO;
import com.agriculture.dao.SeasonDAO;
import com.agriculture.model.Crop;
import com.agriculture.model.Farmer;
import com.agriculture.model.Production;
import com.agriculture.model.Season;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Production Records Management Form
 */
public class ProductionForm extends javax.swing.JFrame {

    private ProductionDAO productionDAO;
    private FarmerDAO farmerDAO;
    private CropDAO cropDAO;
    private SeasonDAO seasonDAO;
    private DefaultTableModel tableModel;
    private int selectedProductionId = -1;

    public ProductionForm() {
        initComponents();
        productionDAO = new ProductionDAO();
        farmerDAO = new FarmerDAO();
        cropDAO = new CropDAO();
        seasonDAO = new SeasonDAO();
        setupTable();
        loadComboBoxes();
        loadProductions();
        setLocationRelativeTo(null);
    }

    private void setupTable() {
        tableModel = new DefaultTableModel(
            new String[]{"ID", "Farmer", "Crop", "Season", "Quantity (kg)"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblProductions.setModel(tableModel);
        tblProductions.getColumnModel().getColumn(0).setPreferredWidth(40);
        tblProductions.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblProductions.getColumnModel().getColumn(2).setPreferredWidth(120);
        tblProductions.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblProductions.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    private void loadComboBoxes() {
        // Load Farmers
        DefaultComboBoxModel<String> farmerModel = new DefaultComboBoxModel<>();
        farmerModel.addElement("-- Select Farmer --");
        List<Farmer> farmers = farmerDAO.getAllFarmers();
        for (Farmer farmer : farmers) {
            farmerModel.addElement(farmer.getFarmerId() + " - " + farmer.getFarmerName());
        }
        cmbFarmer.setModel(farmerModel);
        
        // Load Crops
        DefaultComboBoxModel<String> cropModel = new DefaultComboBoxModel<>();
        cropModel.addElement("-- Select Crop --");
        List<Crop> crops = cropDAO.getAllCrops();
        for (Crop crop : crops) {
            cropModel.addElement(crop.getCropId() + " - " + crop.getCropName());
        }
        cmbCrop.setModel(cropModel);
        
        // Load Seasons
        DefaultComboBoxModel<String> seasonModel = new DefaultComboBoxModel<>();
        seasonModel.addElement("-- Select Season --");
        List<Season> seasons = seasonDAO.getAllSeasons();
        for (Season season : seasons) {
            seasonModel.addElement(season.getSeasonId() + " - " + season.getSeasonName() + " " + season.getYear());
        }
        cmbSeason.setModel(seasonModel);
    }

    private void loadProductions() {
        tableModel.setRowCount(0);
        List<Production> productions = productionDAO.getAllProductions();
        for (Production p : productions) {
            tableModel.addRow(new Object[]{
                p.getProductionId(),
                p.getFarmerName(),
                p.getCropName(),
                p.getSeasonName(),
                p.getQuantity()
            });
        }
    }

    private void clearFields() {
        cmbFarmer.setSelectedIndex(0);
        cmbCrop.setSelectedIndex(0);
        cmbSeason.setSelectedIndex(0);
        txtQuantity.setText("");
        selectedProductionId = -1;
        tblProductions.clearSelection();
        cmbFarmer.requestFocus();
    }

    private boolean validateInput() {
        if (cmbFarmer.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a farmer!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            cmbFarmer.requestFocus();
            return false;
        }
        
        if (cmbCrop.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a crop!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            cmbCrop.requestFocus();
            return false;
        }
        
        if (cmbSeason.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a season!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            cmbSeason.requestFocus();
            return false;
        }
        
        String quantityText = txtQuantity.getText().trim();
        if (quantityText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter quantity!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            txtQuantity.requestFocus();
            return false;
        }
        
        try {
            double qty = Double.parseDouble(quantityText);
            if (qty <= 0) {
                JOptionPane.showMessageDialog(this, "Quantity must be greater than 0!", "Validation Error", JOptionPane.WARNING_MESSAGE);
                txtQuantity.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity must be a valid number!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            txtQuantity.requestFocus();
            return false;
        }
        
        return true;
    }

    private int getIdFromComboBox(String selectedItem) {
        if (selectedItem == null || selectedItem.startsWith("--")) return -1;
        return Integer.parseInt(selectedItem.split(" - ")[0].trim());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbFarmer = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbCrop = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbSeason = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductions = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Production Records");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(128, 0, 128));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Production Records Management");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Production Details"));

        jLabel2.setText("Farmer:");

        cmbFarmer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select Farmer --" }));

        jLabel3.setText("Crop:");

        cmbCrop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select Crop --" }));

        jLabel4.setText("Season:");

        cmbSeason.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select Season --" }));

        jLabel5.setText("Quantity:");

        jLabel6.setText("kg");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbFarmer, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCrop, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSeason, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbFarmer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbCrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbSeason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        btnAdd.setBackground(new java.awt.Color(0, 153, 51));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 102, 204));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(204, 0, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnRefresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblProductions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Farmer", "Crop", "Season", "Quantity (kg)"}
        ));
        tblProductions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductionsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductions);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!validateInput()) return;
        
        Production production = new Production();
        production.setFarmerId(getIdFromComboBox((String) cmbFarmer.getSelectedItem()));
        production.setCropId(getIdFromComboBox((String) cmbCrop.getSelectedItem()));
        production.setSeasonId(getIdFromComboBox((String) cmbSeason.getSelectedItem()));
        production.setQuantity(Double.parseDouble(txtQuantity.getText().trim()));
        
        if (productionDAO.addProduction(production)) {
            JOptionPane.showMessageDialog(this, "Production record added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadProductions();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add production record!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (selectedProductionId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a record to update!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!validateInput()) return;
        
        Production production = new Production();
        production.setProductionId(selectedProductionId);
        production.setFarmerId(getIdFromComboBox((String) cmbFarmer.getSelectedItem()));
        production.setCropId(getIdFromComboBox((String) cmbCrop.getSelectedItem()));
        production.setSeasonId(getIdFromComboBox((String) cmbSeason.getSelectedItem()));
        production.setQuantity(Double.parseDouble(txtQuantity.getText().trim()));
        
        if (productionDAO.updateProduction(production)) {
            JOptionPane.showMessageDialog(this, "Production record updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadProductions();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update production record!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (selectedProductionId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a record to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete this production record?", 
            "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (confirm == JOptionPane.YES_OPTION) {
            if (productionDAO.deleteProduction(selectedProductionId)) {
                JOptionPane.showMessageDialog(this, "Production record deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadProductions();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete production record!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadComboBoxes();
        loadProductions();
        clearFields();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblProductionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductionsMouseClicked
        int row = tblProductions.getSelectedRow();
        if (row >= 0) {
            selectedProductionId = (int) tableModel.getValueAt(row, 0);
            
            // Get the production details to set combo boxes
            Production p = productionDAO.getProductionById(selectedProductionId);
            if (p != null) {
                // Find and select farmer
                for (int i = 0; i < cmbFarmer.getItemCount(); i++) {
                    if (cmbFarmer.getItemAt(i).startsWith(p.getFarmerId() + " - ")) {
                        cmbFarmer.setSelectedIndex(i);
                        break;
                    }
                }
                
                // Find and select crop
                for (int i = 0; i < cmbCrop.getItemCount(); i++) {
                    if (cmbCrop.getItemAt(i).startsWith(p.getCropId() + " - ")) {
                        cmbCrop.setSelectedIndex(i);
                        break;
                    }
                }
                
                // Find and select season
                for (int i = 0; i < cmbSeason.getItemCount(); i++) {
                    if (cmbSeason.getItemAt(i).startsWith(p.getSeasonId() + " - ")) {
                        cmbSeason.setSelectedIndex(i);
                        break;
                    }
                }
                
                txtQuantity.setText(String.valueOf(p.getQuantity()));
            }
        }
    }//GEN-LAST:event_tblProductionsMouseClicked

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

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
                new ProductionForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbCrop;
    private javax.swing.JComboBox<String> cmbFarmer;
    private javax.swing.JComboBox<String> cmbSeason;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProductions;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
