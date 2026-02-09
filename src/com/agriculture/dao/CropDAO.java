package com.agriculture.dao;

import com.agriculture.model.Crop;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CropDAO {

    public boolean addCrop(Crop crop) {
        return insert(crop);
    }

    public boolean insert(Crop crop) {
        String sql = "INSERT INTO crop (crop_name, crop_type) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return false;

            stmt.setString(1, crop.getCropName());
            stmt.setString(2, crop.getCropType());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Insert Error: " + e.getMessage());
            return false;
        }
    }

    public boolean updateCrop(Crop crop) {
        return update(crop);
    }

    public boolean update(Crop crop) {
        String sql = "UPDATE crop SET crop_name=?, crop_type=? WHERE crop_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return false;

            stmt.setString(1, crop.getCropName());
            stmt.setString(2, crop.getCropType());
            stmt.setInt(3, crop.getCropId());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Update Error: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteCrop(int cropId) {
        return delete(cropId);
    }

    public boolean delete(int cropId) {
        String sql = "DELETE FROM crop WHERE crop_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return false;

            stmt.setInt(1, cropId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Delete Error: " + e.getMessage());
            return false;
        }
    }

    public List<Crop> getAllCrops() {
        return getAll();
    }

    public List<Crop> getAll() {
        List<Crop> crops = new ArrayList<>();
        String sql = "SELECT * FROM crop ORDER BY crop_id";

        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            if (conn == null)
                return crops;

            while (rs.next()) {
                Crop c = new Crop();
                c.setCropId(rs.getInt("crop_id"));
                c.setCropName(rs.getString("crop_name"));
                c.setCropType(rs.getString("crop_type"));
                c.setCreatedAt(rs.getTimestamp("created_at"));
                crops.add(c);
            }

        } catch (SQLException e) {
            System.err.println("GetAll Error: " + e.getMessage());
        }
        return crops;
    }

    public Crop getById(int cropId) {
        String sql = "SELECT * FROM crop WHERE crop_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return null;

            stmt.setInt(1, cropId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Crop c = new Crop();
                c.setCropId(rs.getInt("crop_id"));
                c.setCropName(rs.getString("crop_name"));
                c.setCropType(rs.getString("crop_type"));
                c.setCreatedAt(rs.getTimestamp("created_at"));
                return c;
            }

        } catch (SQLException e) {
            System.err.println("GetById Error: " + e.getMessage());
        }
        return null;
    }
}
