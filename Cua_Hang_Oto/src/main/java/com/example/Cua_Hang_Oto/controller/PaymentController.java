package com.example.Cua_Hang_Oto.controller;

import com.example.Cua_Hang_Oto.entity.Car;
import com.example.Cua_Hang_Oto.entity.Payment;
import com.example.Cua_Hang_Oto.service.CarService;
import com.example.Cua_Hang_Oto.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @GetMapping("/getAllPayment")
    public List<Payment> getAllPayment() {
        return paymentService.getAllPayment();
    }

    @GetMapping("/getPaymentById/{id}")
    public ResponseEntity<Payment> getCarById(@PathVariable Long id) {
        Optional<Payment> payment = paymentService.getPaymentById(id);
        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/createPayment")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    @PutMapping("/update/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        payment.setId(id);
        return paymentService.savePayment(payment);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }
}
