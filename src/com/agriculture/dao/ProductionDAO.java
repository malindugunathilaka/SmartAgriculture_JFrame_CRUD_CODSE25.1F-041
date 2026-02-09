package com.agriculture.dao;

import com.agriculture.model.Production;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductionDAO {

    public boolean addProduction(Production production) {
        return insert(production);
    }

    public boolean insert(Production production) {
        String sql = "INSERT INTO production (farmer_id, crop_id, season_id, quantity) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return false;

            stmt.setInt(1, production.getFarmerId());
            stmt.setInt(2, production.getCropId());
            stmt.setInt(3, production.getSeasonId());
            stmt.setDouble(4, production.getQuantity());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Insert Error: " + e.getMessage());
            return false;
        }
    }

    public boolean updateProduction(Production production) {
        return update(production);
    }

    public boolean update(Production production) {
        String sql = "UPDATE production SET farmer_id=?, crop_id=?, season_id=?, quantity=? WHERE production_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return false;

            stmt.setInt(1, production.getFarmerId());
            stmt.setInt(2, production.getCropId());
            stmt.setInt(3, production.getSeasonId());
            stmt.setDouble(4, production.getQuantity());
            stmt.setInt(5, production.getProductionId());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Update Error: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteProduction(int productionId) {
        return delete(productionId);
    }

    public boolean delete(int productionId) {
        String sql = "DELETE FROM production WHERE production_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return false;

            stmt.setInt(1, productionId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Delete Error: " + e.getMessage());
            return false;
        }
    }

    public List<Production> getAllProductions() {
        return getAll();
    }

    public List<Production> getAll() {
        List<Production> productions = new ArrayList<>();
        String sql = "SELECT p.*, f.farmer_name, c.crop_name, CONCAT(s.season_name, ' ', s.year) as season_display " +
                "FROM production p " +
                "JOIN farmer f ON p.farmer_id = f.farmer_id " +
                "JOIN crop c ON p.crop_id = c.crop_id " +
                "JOIN season s ON p.season_id = s.season_id " +
                "ORDER BY p.production_id DESC";

        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            if (conn == null)
                return productions;

            while (rs.next()) {
                Production p = new Production();
                p.setProductionId(rs.getInt("production_id"));
                p.setFarmerId(rs.getInt("farmer_id"));
                p.setCropId(rs.getInt("crop_id"));
                p.setSeasonId(rs.getInt("season_id"));
                p.setQuantity(rs.getDouble("quantity"));
                p.setFarmerName(rs.getString("farmer_name"));
                p.setCropName(rs.getString("crop_name"));
                p.setSeasonName(rs.getString("season_display"));
                productions.add(p);
            }

        } catch (SQLException e) {
            System.err.println("GetAll Error: " + e.getMessage());
        }
        return productions;
    }

    public Production getProductionById(int productionId) {
        return getById(productionId);
    }

    public Production getById(int productionId) {
        String sql = "SELECT p.*, f.farmer_name, c.crop_name, CONCAT(s.season_name, ' ', s.year) as season_display " +
                "FROM production p " +
                "JOIN farmer f ON p.farmer_id = f.farmer_id " +
                "JOIN crop c ON p.crop_id = c.crop_id " +
                "JOIN season s ON p.season_id = s.season_id " +
                "WHERE p.production_id=?";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return null;

            stmt.setInt(1, productionId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Production p = new Production();
                p.setProductionId(rs.getInt("production_id"));
                p.setFarmerId(rs.getInt("farmer_id"));
                p.setCropId(rs.getInt("crop_id"));
                p.setSeasonId(rs.getInt("season_id"));
                p.setQuantity(rs.getDouble("quantity"));
                p.setFarmerName(rs.getString("farmer_name"));
                p.setCropName(rs.getString("crop_name"));
                p.setSeasonName(rs.getString("season_display"));
                return p;
            }

        } catch (SQLException e) {
            System.err.println("GetById Error: " + e.getMessage());
        }
        return null;
    }

    // Report: Farmer Crop Summary
    public List<Map<String, Object>> getFarmerCropSummary() {
        List<Map<String, Object>> data = new ArrayList<>();
        String sql = "SELECT f.farmer_name, c.crop_name, SUM(p.quantity) as total_quantity " +
                "FROM production p " +
                "JOIN farmer f ON p.farmer_id = f.farmer_id " +
                "JOIN crop c ON p.crop_id = c.crop_id " +
                "GROUP BY f.farmer_id, c.crop_id " +
                "ORDER BY f.farmer_name, c.crop_name";

        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            if (conn == null)
                return data;

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("farmer_name", rs.getString("farmer_name"));
                row.put("crop_name", rs.getString("crop_name"));
                row.put("total_quantity", rs.getDouble("total_quantity"));
                data.add(row);
            }

        } catch (SQLException e) {
            System.err.println("Report Error: " + e.getMessage());
        }
        return data;
    }

    // Report: Season Production
    public List<Map<String, Object>> getSeasonProduction() {
        List<Map<String, Object>> data = new ArrayList<>();
        String sql = "SELECT s.season_name, s.year, SUM(p.quantity) as total_quantity " +
                "FROM production p " +
                "JOIN season s ON p.season_id = s.season_id " +
                "GROUP BY s.season_id " +
                "ORDER BY s.year DESC, s.season_name";

        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            if (conn == null)
                return data;

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("season_name", rs.getString("season_name"));
                row.put("year", rs.getInt("year"));
                row.put("total_quantity", rs.getDouble("total_quantity"));
                data.add(row);
            }

        } catch (SQLException e) {
            System.err.println("Report Error: " + e.getMessage());
        }
        return data;
    }

    // Report: Crop Analysis
    public List<Map<String, Object>> getCropAnalysis() {
        List<Map<String, Object>> data = new ArrayList<>();
        String sql = "SELECT c.crop_name, c.crop_type, COUNT(DISTINCT p.farmer_id) as farmer_count, " +
                "SUM(p.quantity) as total_quantity, AVG(p.quantity) as avg_quantity " +
                "FROM crop c " +
                "LEFT JOIN production p ON c.crop_id = p.crop_id " +
                "GROUP BY c.crop_id " +
                "ORDER BY total_quantity DESC";

        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            if (conn == null)
                return data;

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("crop_name", rs.getString("crop_name"));
                row.put("crop_type", rs.getString("crop_type"));
                row.put("farmer_count", rs.getInt("farmer_count"));
                row.put("total_quantity", rs.getDouble("total_quantity"));
                row.put("avg_quantity", rs.getDouble("avg_quantity"));
                data.add(row);
            }

        } catch (SQLException e) {
            System.err.println("Report Error: " + e.getMessage());
        }
        return data;
    }
}
