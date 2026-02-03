package com.example.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@CrossOrigin(origins = "*")
@SpringBootApplication
@RestController
public class EcommerceApplication {

    @GetMapping("/")
    public String home() {
        return "Backend is running successfully";
    }

    @GetMapping("/add-to-cart")
    public String addToCart(@RequestParam String product) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ecommerce_db",
                    "root",
                    "jay21"
            );

            PreparedStatement ps =
                    con.prepareStatement("INSERT INTO cart(product) VALUES (?)");

            ps.setString(1, product);
            ps.executeUpdate();

            con.close();

            return "Product added to cart: " + product;

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/buy")
    public String buy(@RequestParam String product) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ecommerce_db",
                    "root",
                    "jay21"
            );

            PreparedStatement ps =
                    con.prepareStatement("INSERT INTO buy(product) VALUES (?)");

            ps.setString(1, product);
            ps.executeUpdate();

            con.close();

            return "Product buy successfully :" + product;

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }
}
