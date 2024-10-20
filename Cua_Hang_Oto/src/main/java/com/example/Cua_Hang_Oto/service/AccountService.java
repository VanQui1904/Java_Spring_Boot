package com.example.Cua_Hang_Oto.service;

import com.example.Cua_Hang_Oto.entity.Account;
import com.example.Cua_Hang_Oto.entity.Car;
import com.example.Cua_Hang_Oto.entity.Customer;
import com.example.Cua_Hang_Oto.repository.AccountRepository;
import com.example.Cua_Hang_Oto.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    // Lấy tất cả tài khoản
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Thay đổi quyền của tài khoản
    public void changeRole(Long accountId, String newRole) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setAccount_role(newRole);
        accountRepository.save(account);
    }

    // Thêm tài khoản và đồng thời tạo customer với các trường giá trị rỗng
    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

//    public Account updateAccountWithCustomer(Long accountId, Customer customer) {
//        Account account = accountRepository.findById(accountId)
//                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
//        account.setCustomer(customer);
//        return accountRepository.save(account);
//    }

    // Tìm tài khoản theo username và password
    public Optional<Account> findByUsernameAndPassword(String username, String accountPassword) {
        return accountRepository.findByUsernameAndAccountPassword(username, accountPassword);
    }

    // Tìm tài khoản theo username (để kiểm tra khi đăng ký)
    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Cập nhật các trường của Customer
        existingCustomer.setFirst_name(updatedCustomer.getFirst_name());
        existingCustomer.setLast_name(updatedCustomer.getLast_name());
        existingCustomer.setAddress(updatedCustomer.getAddress());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setPhone_number(updatedCustomer.getPhone_number());

        return customerRepository.save(existingCustomer);
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

//    public Customer createCustomerAndUpdateAccount(Long customer_id, Long accountId) {
//        Customer newCustomer = customerRepository.save(customer_id);
//
//        // Cập nhật tài khoản với CustomerID mới
//        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
//        account.setCustomer_id(newCustomer);
//        accountRepository.save(account);
//
//        return newCustomer;
//    }
}
