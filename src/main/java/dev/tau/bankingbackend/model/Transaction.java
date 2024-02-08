package dev.tau.bankingbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private double amount;
    private String type; // "DEPOSIT" or "WITHDRAW"
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

