package com.example.Cua_Hang_Oto.controller;

import com.example.Cua_Hang_Oto.entity.Order;
import com.example.Cua_Hang_Oto.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = {"http://localhost:4200"})
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PutMapping("/confirm/{id}")
    public ResponseEntity<Order> confirmOrder(@PathVariable Long id) {
        Optional<Order> order = orderService.getOrderById(id);
        if (order.isPresent()) {
            Order updatedOrder = order.get();
            updatedOrder.setStatus("Confirmed"); // Cập nhật trạng thái
            orderService.saveOrder(updatedOrder);
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Hủy đơn hàng
    @PutMapping("/cancel/{id}")
    public ResponseEntity<Order> cancelOrder(@PathVariable Long id) {
        Optional<Order> order = orderService.getOrderById(id);
        if (order.isPresent()) {
            Order updatedOrder = order.get();
            updatedOrder.setStatus("Cancelled"); // Cập nhật trạng thái
            orderService.saveOrder(updatedOrder);
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getOrder")
    public List<Order> getOrder() {
        return orderService.getAllOrder();
    }

    @PostMapping("/addOrder")
    public Order createOrder(@RequestBody Order order) {

        return orderService.saveOrder(order);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
