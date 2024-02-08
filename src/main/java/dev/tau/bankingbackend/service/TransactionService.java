package dev.tau.bankingbackend.service;

import dev.tau.bankingbackend.model.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getAllTransactions();

    Transaction getTransactionById(Long transactionId);

    Transaction createTransaction(Transaction transaction);

    void deleteTransaction(Long transactionId);
}
