package dev.tau.bankingbackend.service;

import dev.tau.bankingbackend.model.Transaction;
import dev.tau.bankingbackend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found with ID: " + transactionId));
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        // You can add additional validation or business logic before saving
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long transactionId) {
        // Check if the transaction exists
        getTransactionById(transactionId);

        transactionRepository.deleteById(transactionId);
    }
}
