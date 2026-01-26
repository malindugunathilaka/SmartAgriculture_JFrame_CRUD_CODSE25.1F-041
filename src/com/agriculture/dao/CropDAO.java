package com.agriculture.dao;

import com.agriculture.model.Crop;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CropDAO {
    public static boolean insertCrop(Crop c) {
        String sql = "INSERT INTO crop (crop_name, crop_type) VALUES (?, ?)";
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, c.getCropName());
            ps.setString(2, c.getCropType());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public static List<Crop> getAllCrops() {
        List<Crop> list = new ArrayList<>();
        try (Statement st = DatabaseConnection.getConnection().createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM crop ORDER BY crop_name")) {
            while (rs.next()) {
                Crop c = new Crop();
                c.setCropId(rs.getInt("crop_id"));
                c.setCropName(rs.getString("crop_name"));
                c.setCropType(rs.getString("crop_type"));
                list.add(c);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public static boolean updateCrop(Crop c) {
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("UPDATE crop SET crop_name=?, crop_type=? WHERE crop_id=?")) {
            ps.setString(1, c.getCropName());
            ps.setString(2, c.getCropType());
            ps.setInt(3, c.getCropId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public static boolean deleteCrop(int id) {
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("DELETE FROM crop WHERE crop_id=?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }
}
