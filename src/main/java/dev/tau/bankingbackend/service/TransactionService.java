package dev.tau.bankingbackend.service;

import dev.tau.bankingbackend.model.Customer;
import dev.tau.bankingbackend.model.Transaction;
import dev.tau.bankingbackend.repository.CustomerRepository;
import dev.tau.bankingbackend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, CustomerRepository customerRepository) {
        this.transactionRepository = transactionRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void processTransaction(Transaction transaction) {
        // Get the customer from the transaction
        Customer customer = customerRepository.findById(transaction.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Perform the transaction logic
        if ("DEPOSIT".equals(transaction.getType())) {
            // Deposit logic
            BigDecimal newBalance = customer.getAccountBalance().add(BigDecimal.valueOf(transaction.getAmount()));
            customer.setAccountBalance(newBalance);
        } else if ("WITHDRAW".equals(transaction.getType())) {
            // Withdraw logic
            BigDecimal newBalance = customer.getAccountBalance().subtract(BigDecimal.valueOf(transaction.getAmount()));
            if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
                throw new RuntimeException("Insufficient funds");
            }
            customer.setAccountBalance(newBalance);
        } else {
            throw new RuntimeException("Invalid transaction type");
        }

        // Update customer's last modified details
        customer.setLastModifiedDate(LocalDateTime.now());
        customer.setLastModifiedBy("TransactionService");

        // Save the updated customer
        customerRepository.save(customer);

        // Set transaction details and save it
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setBalanceAfterTransaction(customer.getAccountBalance().doubleValue());
        transaction.setStatus("COMPLETED");
        transactionRepository.save(transaction);
    }
}
