package com.example.ecommerce.controller;

import com.example.ecommerce.model.CartItem;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartController {

    private List<CartItem> cart = new ArrayList<>();

    @PostMapping("/add")
    public List<CartItem> addToCart(@RequestBody CartItem item) {
        cart.add(item);
        return cart;
    }

    @GetMapping
    public List<CartItem> getCart() {
        return cart;
    }

    @DeleteMapping("/clear")
    public void clearCart() {
        cart.clear();
    }
}