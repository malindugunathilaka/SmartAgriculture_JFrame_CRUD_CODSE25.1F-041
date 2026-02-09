package com.agriculture.dao;

import com.agriculture.model.Season;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeasonDAO {

    public boolean addSeason(Season season) {
        String sql = "INSERT INTO season (season_name, year) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return false;

            stmt.setString(1, season.getSeasonName());
            stmt.setInt(2, season.getYear());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Insert Error: " + e.getMessage());
            return false;
        }
    }

    public boolean updateSeason(Season season) {
        String sql = "UPDATE season SET season_name=?, year=? WHERE season_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return false;

            stmt.setString(1, season.getSeasonName());
            stmt.setInt(2, season.getYear());
            stmt.setInt(3, season.getSeasonId());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Update Error: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteSeason(int seasonId) {
        String sql = "DELETE FROM season WHERE season_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return false;

            stmt.setInt(1, seasonId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Delete Error: " + e.getMessage());
            return false;
        }
    }

    public List<Season> getAllSeasons() {
        List<Season> seasons = new ArrayList<>();
        String sql = "SELECT * FROM season ORDER BY year DESC, season_name";

        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            if (conn == null)
                return seasons;

            while (rs.next()) {
                Season s = new Season();
                s.setSeasonId(rs.getInt("season_id"));
                s.setSeasonName(rs.getString("season_name"));
                s.setYear(rs.getInt("year"));
                seasons.add(s);
            }

        } catch (SQLException e) {
            System.err.println("GetAll Error: " + e.getMessage());
        }
        return seasons;
    }

    public Season getSeasonById(int seasonId) {
        String sql = "SELECT * FROM season WHERE season_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return null;

            stmt.setInt(1, seasonId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Season s = new Season();
                s.setSeasonId(rs.getInt("season_id"));
                s.setSeasonName(rs.getString("season_name"));
                s.setYear(rs.getInt("year"));
                return s;
            }

        } catch (SQLException e) {
            System.err.println("GetById Error: " + e.getMessage());
        }
        return null;
    }

    public boolean isDuplicate(String seasonName, int year, int excludeId) {
        String sql = "SELECT COUNT(*) FROM season WHERE season_name=? AND year=? AND season_id!=?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return false;

            stmt.setString(1, seasonName);
            stmt.setInt(2, year);
            stmt.setInt(3, excludeId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            System.err.println("Duplicate Check Error: " + e.getMessage());
        }
        return false;
    }
}
