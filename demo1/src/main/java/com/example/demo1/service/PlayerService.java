package com.example.demo1.service;

import com.example.demo1.DAO.PlayerDAO;
import com.example.demo1.entity.Player;

import java.util.List;

public class PlayerService {
    private PlayerDAO playerDAO = new PlayerDAO();

    public boolean addPlayer(Player player) {
        return playerDAO.addPlayer(player);
    }

    public List<Player> getAllPlayers() {
        return playerDAO.getAllPlayers();
    }

    public boolean updatePlayer(Player player) {
        return playerDAO.updatePlayer(player);
    }

    public boolean deletePlayer(int id) {
        return playerDAO.deletePlayer(id);
    }

    // Thêm phương thức getPlayerById
    public Player getPlayerById(int id) {
        return playerDAO.getPlayerById(id); // Gọi phương thức từ PlayerDAO
    }
}
