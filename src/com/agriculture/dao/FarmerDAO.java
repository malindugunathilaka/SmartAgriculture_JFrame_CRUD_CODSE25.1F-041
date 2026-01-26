package com.agriculture.dao;

import com.agriculture.model.Farmer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FarmerDAO {
    public static boolean insertFarmer(Farmer f) {
        String sql = "INSERT INTO farmer (farmer_name, nic, address, contact_no) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, f.getFarmerName());
            ps.setString(2, f.getNic());
            ps.setString(3, f.getAddress());
            ps.setString(4, f.getContactNo());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public static List<Farmer> getAllFarmers() {
        List<Farmer> list = new ArrayList<>();
        String sql = "SELECT * FROM farmer ORDER BY farmer_name";
        try (Statement st = DatabaseConnection.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Farmer(rs.getInt("farmer_id"), rs.getString("farmer_name"),
                    rs.getString("nic"), rs.getString("address"), rs.getString("contact_no"),
                    rs.getTimestamp("created_at")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public static boolean updateFarmer(Farmer f) {
        String sql = "UPDATE farmer SET farmer_name=?, nic=?, address=?, contact_no=? WHERE farmer_id=?";
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, f.getFarmerName());
            ps.setString(2, f.getNic());
            ps.setString(3, f.getAddress());
            ps.setString(4, f.getContactNo());
            ps.setInt(5, f.getFarmerId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public static boolean deleteFarmer(int id) {
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("DELETE FROM farmer WHERE farmer_id=?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public static boolean isNicExists(String nic) {
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("SELECT COUNT(*) FROM farmer WHERE nic=?")) {
            ps.setString(1, nic);
            ResultSet rs = ps.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) { return false; }
    }
}
