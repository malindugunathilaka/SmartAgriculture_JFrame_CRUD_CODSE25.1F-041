package com.agriculture.ui;

import com.agriculture.dao.SeasonDAO;
import com.agriculture.model.Season;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Season Management Form
 */
public class SeasonForm extends javax.swing.JFrame {

    private SeasonDAO seasonDAO;
    private DefaultTableModel tableModel;
    private int selectedSeasonId = -1;

    public SeasonForm() {
        initComponents();
        seasonDAO = new SeasonDAO();
        setupTable();
        loadSeasons();
        setLocationRelativeTo(null);
    }

    private void setupTable() {
        tableModel = new DefaultTableModel(
            new String[]{"ID", "Season Name", "Year"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblSeasons.setModel(tableModel);
        tblSeasons.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblSeasons.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblSeasons.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void loadSeasons() {
        tableModel.setRowCount(0);
        List<Season> seasons = seasonDAO.getAllSeasons();
        for (Season season : seasons) {
            tableModel.addRow(new Object[]{
                season.getSeasonId(),
                season.getSeasonName(),
                season.getYear()
            });
        }
    }

    private void clearFields() {
        txtSeasonName.setText("");
        txtYear.setText("");
        selectedSeasonId = -1;
        tblSeasons.clearSelection();
        txtSeasonName.requestFocus();
    }

    private boolean validateInput() {
        if (txtSeasonName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter season name!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            txtSeasonName.requestFocus();
            return false;
        }
        
        String yearText = txtYear.getText().trim();
        if (yearText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter year!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            txtYear.requestFocus();
            return false;
        }
        
        try {
            int year = Integer.parseInt(yearText);
            if (year < 1900 || year > 2100) {
                JOptionPane.showMessageDialog(this, "Year must be between 1900 and 2100!", "Validation Error", JOptionPane.WARNING_MESSAGE);
                txtYear.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Year must be a valid number!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            txtYear.requestFocus();
            return false;
        }
        
        return true;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSeasonName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSeasons = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Season Management");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 140, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Season Management");

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Season Details"));

        jLabel2.setText("Season Name:");

        jLabel3.setText("Year:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSeasonName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSeasonName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(btnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblSeasons.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Season Name", "Year"}
        ));
        tblSeasons.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSeasonsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSeasons);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
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
        
        String seasonName = txtSeasonName.getText().trim();
        int year = Integer.parseInt(txtYear.getText().trim());
        
        // Check for duplicate
        if (seasonDAO.isDuplicate(seasonName, year, -1)) {
            JOptionPane.showMessageDialog(this, 
                "Season '" + seasonName + " " + year + "' already exists!", 
                "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Season season = new Season();
        season.setSeasonName(seasonName);
        season.setYear(year);
        
        if (seasonDAO.addSeason(season)) {
            JOptionPane.showMessageDialog(this, "Season added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadSeasons();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add season!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (selectedSeasonId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a season to update!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!validateInput()) return;
        
        String seasonName = txtSeasonName.getText().trim();
        int year = Integer.parseInt(txtYear.getText().trim());
        
        // Check for duplicate (excluding current record)
        if (seasonDAO.isDuplicate(seasonName, year, selectedSeasonId)) {
            JOptionPane.showMessageDialog(this, 
                "Season '" + seasonName + " " + year + "' already exists!", 
                "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Season season = new Season();
        season.setSeasonId(selectedSeasonId);
        season.setSeasonName(seasonName);
        season.setYear(year);
        
        if (seasonDAO.updateSeason(season)) {
            JOptionPane.showMessageDialog(this, "Season updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadSeasons();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update season!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (selectedSeasonId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a season to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete this season?\nThis may affect related production records.", 
            "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (confirm == JOptionPane.YES_OPTION) {
            if (seasonDAO.deleteSeason(selectedSeasonId)) {
                JOptionPane.showMessageDialog(this, "Season deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadSeasons();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete season!\nIt may be used in production records.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void tblSeasonsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSeasonsMouseClicked
        int row = tblSeasons.getSelectedRow();
        if (row >= 0) {
            selectedSeasonId = (int) tableModel.getValueAt(row, 0);
            txtSeasonName.setText(tableModel.getValueAt(row, 1).toString());
            txtYear.setText(tableModel.getValueAt(row, 2).toString());
        }
    }//GEN-LAST:event_tblSeasonsMouseClicked

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
                new SeasonForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSeasons;
    private javax.swing.JTextField txtSeasonName;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
