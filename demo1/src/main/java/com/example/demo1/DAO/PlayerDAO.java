package com.example.demo1.DAO;

import com.example.demo1.entity.Player;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PlayerDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/player_evaluation";  // Update with your DB details
    private static final String USER = "root";  // DB username
    private static final String PASSWORD = "root";  // DB password

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public boolean addPlayer(Player player) {
        String sql = "INSERT INTO players (name, age, index_name, value) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, player.getName());
            stmt.setInt(2, player.getAge());
            stmt.setString(3, player.getIndexName());
            stmt.setInt(4, player.getValue());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM players";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Player player = new Player(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("index_name"),
                        rs.getInt("value")
                );
                players.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    public boolean updatePlayer(Player player) {
        String sql = "UPDATE players SET name = ?, age = ?, index_name = ?, value = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, player.getName());
            stmt.setInt(2, player.getAge());
            stmt.setString(3, player.getIndexName());
            stmt.setInt(4, player.getValue());
            stmt.setInt(5, player.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePlayer(int id) {
        String sql = "DELETE FROM players WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Thêm phương thức getPlayerById
    public Player getPlayerById(int id) {
        String sql = "SELECT * FROM players WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Player(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("age"),
                            rs.getString("index_name"),
                            rs.getInt("value")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Không tìm thấy player với id này
    }
}
