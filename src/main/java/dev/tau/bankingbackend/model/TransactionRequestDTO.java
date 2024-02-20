package dev.tau.bankingbackend.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionRequestDTO {
    private Long customerId;
    private double amount;
    private Transaction.TransactionType type;
    private String transactionId;
    private LocalDateTime timestamp;
    private String description;
    private String currencyCode;
    private String status;
    private String method;
    private String referenceNumber;
    private String sourceAccountNumber; // For withdrawals
    private String destinationAccountNumber; // For deposits
    private double transactionFee;
    private double balanceAfterTransaction;
    private String authorizedBy;
}

