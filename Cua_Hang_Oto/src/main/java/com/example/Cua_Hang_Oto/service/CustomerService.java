package com.example.Cua_Hang_Oto.service;

import com.example.Cua_Hang_Oto.entity.Car;
import com.example.Cua_Hang_Oto.entity.Customer;
import com.example.Cua_Hang_Oto.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCusById(Long id) {
        return customerRepository.findById(id);
    }
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
