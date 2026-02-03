package com.example.ecommerce;

import org.springframework.web.bind.annotation.*;
import java.sql.*;

@CrossOrigin(origins = "*")
@RestController
public class LoginController {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String url = "jdbc:mysql://localhost:3306/Ecommerce_db";
    String user = "root";      // OR ecom
    String pass = "jay21";  // EXACT MySQL password

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password) {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps =
                    con.prepareStatement(
                            "INSERT INTO users(username, password) VALUES (?, ?) ");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            return "Registered Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Register Failed";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps =
                    con.prepareStatement(
                            "SELECT * FROM users WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return "SUCCESS:" + username;
            } else {
                return "Invalid Login";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }
}