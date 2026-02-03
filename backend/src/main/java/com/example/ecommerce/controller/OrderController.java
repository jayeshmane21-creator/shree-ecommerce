package com.example.ecommerce.controller;

import com.example.ecommerce.model.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrderController {

    @PostMapping("/pay")
    public String payment(@RequestBody Order order) {
        order.setStatus("SUCCESS");
        return "Payment Successful";
    }
}