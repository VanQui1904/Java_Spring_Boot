package com.example.Cua_Hang_Oto.controller;


import com.example.Cua_Hang_Oto.entity.Account;
import com.example.Cua_Hang_Oto.entity.Customer;

import com.example.Cua_Hang_Oto.repository.AccountRepository;
import com.example.Cua_Hang_Oto.repository.CustomerRepository;
import com.example.Cua_Hang_Oto.service.AccountService;
import com.example.Cua_Hang_Oto.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/getAllCustomer")
    public List<Customer> getAllCars() {
        return customerService.getAllCustomer();
    }

    @GetMapping("/getCusById/{id}")
    public ResponseEntity<Customer> getCusById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.getCusById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
//    @PostMapping("/add-customer")
//    public ResponseEntity<?> addCustomerAndUpdateAccount(@RequestBody Customer customer, Principal principal) {
//        // Lấy tài khoản đã đăng nhập
//        String username = principal.getName();
//        Account account = accountRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("Account not found"));
//
//        // Lưu thông tin khách hàng mới
//        Long newCustomer = customerRepository.save(customer);
//
//        // Cập nhật tài khoản với customer_id mới
//        account.setCustomer_id(newCustomer);
//        accountRepository.save(account);
//
//        return ResponseEntity.ok("Customer created and account updated");
//    }
}
