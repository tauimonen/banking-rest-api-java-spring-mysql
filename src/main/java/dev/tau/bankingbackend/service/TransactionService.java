package dev.tau.bankingbackend.service;

import dev.tau.bankingbackend.model.Customer;
import dev.tau.bankingbackend.model.Transaction;
import dev.tau.bankingbackend.model.TransactionRequestDTO;
import dev.tau.bankingbackend.repository.CustomerRepository;
import dev.tau.bankingbackend.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, CustomerRepository customerRepository) {
        this.transactionRepository = transactionRepository;
        this.customerRepository = customerRepository;
    }

    public Transaction createTransaction(TransactionRequestDTO requestDTO) {
        Customer customer = customerRepository.findById(requestDTO.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        Transaction transaction = new Transaction();
        transaction.setCustomer(customer);
        transaction.setAmount(requestDTO.getAmount());
        transaction.setType(requestDTO.getType());
        transaction.setTransactionId(requestDTO.getTransactionId());
        transaction.setTimestamp(requestDTO.getTimestamp());
        transaction.setDescription(requestDTO.getDescription());
        transaction.setCurrencyCode(requestDTO.getCurrencyCode());
        transaction.setStatus(requestDTO.getStatus());
        transaction.setMethod(requestDTO.getMethod());
        transaction.setReferenceNumber(requestDTO.getReferenceNumber());
        transaction.setSourceAccountNumber(requestDTO.getSourceAccountNumber());
        transaction.setDestinationAccountNumber(requestDTO.getDestinationAccountNumber());
        transaction.setTransactionFee(requestDTO.getTransactionFee());
        transaction.setBalanceAfterTransaction(requestDTO.getBalanceAfterTransaction());
        transaction.setAuthorizedBy(requestDTO.getAuthorizedBy());

        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByCustomerId(Long customerId) {
        return transactionRepository.findByCustomerId(customerId);
    }
}
