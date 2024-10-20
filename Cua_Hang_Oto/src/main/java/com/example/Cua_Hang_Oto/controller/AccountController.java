package com.example.Cua_Hang_Oto.controller;

import com.example.Cua_Hang_Oto.entity.Account;
import com.example.Cua_Hang_Oto.entity.Car;
import com.example.Cua_Hang_Oto.entity.Customer;
import com.example.Cua_Hang_Oto.repository.AccountRepository;
import com.example.Cua_Hang_Oto.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/getAllAccount")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping("/change-role/{id}")
    public ResponseEntity<?> changeRole(@PathVariable Long id, @RequestBody String newRole) {
        accountService.changeRole(id, newRole);
        return ResponseEntity.ok("Role updated successfully");
    }
    @PutMapping("/upgrade-role/{id}")
    public ResponseEntity<?> upgradeRole(@PathVariable Long id) {
        accountService.changeRole(id, "ADMIN"); // Thay đổi thành "ADMIN" hoặc quyền bạn muốn
        return ResponseEntity.ok("Role upgraded successfully");
    }

    @PutMapping("/downgrade-role/{id}")
    public ResponseEntity<?> downgradeRole(@PathVariable Long id) {
        accountService.changeRole(id, "USER"); // Thay đổi thành "USER" hoặc quyền bạn muốn
        return ResponseEntity.ok("Role downgraded successfully");
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Account account) {
        // Kiểm tra xem username đã tồn tại chưa
        if (accountService.findByUsername(account.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        // Kiểm tra xem email đã tồn tại chưa
        if (accountRepository.findByEmail(account.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        Account savedAccount = accountService.addAccount(account);
        return ResponseEntity.ok(savedAccount);
    }

    // Đăng nhập
    @PostMapping("/login")
    public ResponseEntity<?> getAccount(@RequestBody Account loginRequest) {
        Optional<Account> account = accountService.findByUsernameAndPassword(
                loginRequest.getUsername(), loginRequest.getAccountPassword());

        if (account.isPresent()) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
    @PutMapping("/update-customer/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer updatedCustomer) {
        Customer customer = accountService.updateCustomer(customerId, updatedCustomer);
        return ResponseEntity.ok(customer);
    }
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.addAccount(account);
        return ResponseEntity.ok(createdAccount);
    }

    @GetMapping("/getCarById/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Optional<Account> account = accountService.getAccountById(id);
        return account.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // API để thêm khách hàng và cập nhật tài khoản
//    @PostMapping("/create-customer/{accountId}")
//    public ResponseEntity<Customer> createCustomerAndUpdateAccount(@RequestBody Customer customer, @PathVariable Long accountId) {
//        Customer newCustomer = accountService.createCustomerAndUpdateAccount(customer, accountId);
//        return ResponseEntity.ok(newCustomer);
//    }
}
