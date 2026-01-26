package com.agriculture.dao;

import com.agriculture.model.Production;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductionDAO {
    public static boolean insertProduction(Production p) {
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(
            "INSERT INTO production (farmer_id, crop_id, season_id, quantity) VALUES (?, ?, ?, ?)")) {
            ps.setInt(1, p.getFarmerId());
            ps.setInt(2, p.getCropId());
            ps.setInt(3, p.getSeasonId());
            ps.setDouble(4, p.getQuantity());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public static List<Production> getAllProduction() {
        List<Production> list = new ArrayList<>();
        String sql = "SELECT p.*, f.farmer_name, c.crop_name, CONCAT(s.season_name, ' ', s.year) as season_display " +
                     "FROM production p JOIN farmer f ON p.farmer_id = f.farmer_id " +
                     "JOIN crop c ON p.crop_id = c.crop_id JOIN season s ON p.season_id = s.season_id ORDER BY p.production_id DESC";
        try (Statement st = DatabaseConnection.getConnection().createStatement(); ResultSet rs = st.executeQuery(sql)) {
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
                list.add(p);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public static boolean updateProduction(Production p) {
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(
            "UPDATE production SET farmer_id=?, crop_id=?, season_id=?, quantity=? WHERE production_id=?")) {
            ps.setInt(1, p.getFarmerId());
            ps.setInt(2, p.getCropId());
            ps.setInt(3, p.getSeasonId());
            ps.setDouble(4, p.getQuantity());
            ps.setInt(5, p.getProductionId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public static boolean deleteProduction(int id) {
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("DELETE FROM production WHERE production_id=?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }
}
