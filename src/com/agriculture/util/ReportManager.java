package com.agriculture.util;

import com.agriculture.dao.DatabaseConnection;
import java.sql.Connection;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Utility class to handle JasperReports generation and viewing
 */
public class ReportManager {

    private static final String REPORT_DIR = "reports/";

    /**
     * Generates and displays a JasperReport
     * 
     * @param jrxmlFileName The name of the .jrxml file (e.g.,
     *                      "farmer_crop_report.jrxml")
     * @param parameters    Map of parameters to pass to the report
     */
    public static void showReport(String jrxmlFileName, Map<String, Object> parameters) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Database Connection Failed!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String reportPath = REPORT_DIR + jrxmlFileName;

            // 1. Compile the JRXML to Jasper
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);

            // 2. Fill the report with data
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);

            // 3. Show report in Viewer
            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "JasperReport Error:\n" + e.getMessage() +
                    "\n\nMake sure you have added all necessary JasperReport lib JARs.",
                    "Report Generation Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
