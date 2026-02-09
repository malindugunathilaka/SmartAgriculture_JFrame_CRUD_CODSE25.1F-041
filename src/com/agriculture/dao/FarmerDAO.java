package com.agriculture.dao;

import com.agriculture.model.Farmer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FarmerDAO {

    public boolean insert(Farmer farmer) {
        String sql = "INSERT INTO farmer (farmer_name, nic, address, contact_no) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return false;

            stmt.setString(1, farmer.getFarmerName());
            stmt.setString(2, farmer.getNic());
            stmt.setString(3, farmer.getAddress());
            stmt.setString(4, farmer.getContactNo());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Insert Error: " + e.getMessage());
            return false;
        }
    }

    public boolean update(Farmer farmer) {
        String sql = "UPDATE farmer SET farmer_name=?, nic=?, address=?, contact_no=? WHERE farmer_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return false;

            stmt.setString(1, farmer.getFarmerName());
            stmt.setString(2, farmer.getNic());
            stmt.setString(3, farmer.getAddress());
            stmt.setString(4, farmer.getContactNo());
            stmt.setInt(5, farmer.getFarmerId());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Update Error: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int farmerId) {
        String sql = "DELETE FROM farmer WHERE farmer_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return false;

            stmt.setInt(1, farmerId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Delete Error: " + e.getMessage());
            return false;
        }
    }

    public List<Farmer> getAllFarmers() {
        return getAll();
    }

    public List<Farmer> getAll() {
        List<Farmer> farmers = new ArrayList<>();
        String sql = "SELECT * FROM farmer ORDER BY farmer_id";

        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            if (conn == null)
                return farmers;

            while (rs.next()) {
                Farmer f = new Farmer();
                f.setFarmerId(rs.getInt("farmer_id"));
                f.setFarmerName(rs.getString("farmer_name"));
                f.setNic(rs.getString("nic"));
                f.setAddress(rs.getString("address"));
                f.setContactNo(rs.getString("contact_no"));
                f.setCreatedAt(rs.getTimestamp("created_at"));
                farmers.add(f);
            }

        } catch (SQLException e) {
            System.err.println("GetAll Error: " + e.getMessage());
        }
        return farmers;
    }

    public Farmer getById(int farmerId) {
        String sql = "SELECT * FROM farmer WHERE farmer_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return null;

            stmt.setInt(1, farmerId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Farmer f = new Farmer();
                f.setFarmerId(rs.getInt("farmer_id"));
                f.setFarmerName(rs.getString("farmer_name"));
                f.setNic(rs.getString("nic"));
                f.setAddress(rs.getString("address"));
                f.setContactNo(rs.getString("contact_no"));
                f.setCreatedAt(rs.getTimestamp("created_at"));
                return f;
            }

        } catch (SQLException e) {
            System.err.println("GetById Error: " + e.getMessage());
        }
        return null;
    }

    public boolean isNicExists(String nic, int excludeId) {
        String sql = "SELECT COUNT(*) FROM farmer WHERE nic=? AND farmer_id!=?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return false;

            stmt.setString(1, nic);
            stmt.setInt(2, excludeId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            System.err.println("NIC Check Error: " + e.getMessage());
        }
        return false;
    }
}
