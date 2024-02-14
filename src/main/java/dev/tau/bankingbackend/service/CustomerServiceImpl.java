package dev.tau.bankingbackend.service;

import dev.tau.bankingbackend.model.Customer;
import dev.tau.bankingbackend.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));
    }

    @Override
    @Transactional
    public Customer createCustomer(Customer customer) {
        // You can add additional validation or business logic before saving
        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
        // Check if the customer exists
        getCustomerById(customerId);

        // Set the ID of the updated customer to ensure correct update
        updatedCustomer.setId(customerId);

        return customerRepository.save(updatedCustomer);
    }

    @Override
    @Transactional
    public void deleteCustomer(Long customerId) {
        // Check if the customer exists
        getCustomerById(customerId);

        customerRepository.deleteById(customerId);
    }
}
