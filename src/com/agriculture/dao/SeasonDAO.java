package com.agriculture.dao;

import com.agriculture.model.Season;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeasonDAO {
    public static boolean insertSeason(Season s) {
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("INSERT INTO season (season_name, year) VALUES (?, ?)")) {
            ps.setString(1, s.getSeasonName());
            ps.setInt(2, s.getYear());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public static List<Season> getAllSeasons() {
        List<Season> list = new ArrayList<>();
        try (Statement st = DatabaseConnection.getConnection().createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM season ORDER BY year DESC, season_name")) {
            while (rs.next()) {
                Season s = new Season();
                s.setSeasonId(rs.getInt("season_id"));
                s.setSeasonName(rs.getString("season_name"));
                s.setYear(rs.getInt("year"));
                list.add(s);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public static boolean updateSeason(Season s) {
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("UPDATE season SET season_name=?, year=? WHERE season_id=?")) {
            ps.setString(1, s.getSeasonName());
            ps.setInt(2, s.getYear());
            ps.setInt(3, s.getSeasonId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public static boolean deleteSeason(int id) {
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("DELETE FROM season WHERE season_id=?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }
}
