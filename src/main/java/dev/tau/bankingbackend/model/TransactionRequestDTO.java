package dev.tau.bankingbackend.model;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class TransactionRequestDTO {

    @NotNull
    private Long customerId;

    @NotNull
    private double amount;

    @NotNull
    private Transaction.TransactionType type;

    @NotBlank
    private String transactionId;

    private LocalDateTime timestamp;

    @NotBlank
    private String description;

    @NotBlank
    private String currencyCode;

    @NotBlank
    private String status;

    @NotBlank
    private String method;

    @NotBlank
    private String referenceNumber;

    private String sourceAccountNumber; // For withdrawals

    private String destinationAccountNumber; // For deposits

    private double transactionFee;

    private double balanceAfterTransaction;

    @NotBlank
    private String authorizedBy;
}


