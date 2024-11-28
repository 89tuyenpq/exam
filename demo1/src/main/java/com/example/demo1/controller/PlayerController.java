package com.example.demo1.controller;


import com.example.demo1.entity.Player;
import com.example.demo1.service.PlayerService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/player")
public class PlayerController extends HttpServlet {
    private PlayerService playerService = new PlayerService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Player player = playerService.getPlayerById(id);  // You need to implement this method in the service
            request.setAttribute("player", player);
            request.getRequestDispatcher("/views/editPlayer.jsp").forward(request, response);
        } else {
            List<Player> players = playerService.getAllPlayers();
            request.setAttribute("players", players);
            request.getRequestDispatcher("/views/playerList.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String indexName = request.getParameter("index_name");
        int value = Integer.parseInt(request.getParameter("value"));

        Player player = new Player();
        player.setName(name);
        player.setAge(age);
        player.setIndexName(indexName);
        player.setValue(value);

        if (action != null && action.equals("add")) {
            boolean success = playerService.addPlayer(player);
            if (success) {
                response.sendRedirect("player");
            }
        } else if (action != null && action.equals("update")) {
            int id = Integer.parseInt(request.getParameter("id"));
            player.setId(id);
            boolean success = playerService.updatePlayer(player);
            if (success) {
                response.sendRedirect("player");
            }
        } else if (action != null && action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean success = playerService.deletePlayer(id);
            if (success) {
                response.sendRedirect("player");
            }
        }
    }
}
