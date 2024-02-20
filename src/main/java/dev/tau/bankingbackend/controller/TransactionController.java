package dev.tau.bankingbackend.controller;

import dev.tau.bankingbackend.model.Transaction;
import dev.tau.bankingbackend.model.TransactionRequestDTO;
import dev.tau.bankingbackend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionRequestDTO requestDTO) {
        Transaction createdTransaction = transactionService.createTransaction(requestDTO);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/byCustomerId/{customerId}")
    public ResponseEntity<List<Transaction>> getTransactionsByCustomerId(@PathVariable Long customerId) {
        List<Transaction> transactions = transactionService.getTransactionsByCustomerId(customerId);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}

