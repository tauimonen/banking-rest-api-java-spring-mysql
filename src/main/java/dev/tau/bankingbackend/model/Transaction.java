package dev.tau.bankingbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "transactions")
@EntityListeners(AuditingEntityListener.class)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "amount")
    private double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TransactionType type;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "timestamp")
    @CreatedDate
    private LocalDateTime timestamp;

    @Column(name = "description")
    private String description;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "status")
    private String status;

    @Column(name = "method")
    private String method;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "source_account_number")
    private String sourceAccountNumber; // For withdrawals

    @Column(name = "destination_account_number")
    private String destinationAccountNumber; // For deposits

    @Column(name = "transaction_fee")
    private double transactionFee;

    @Column(name = "balance_after_transaction")
    private double balanceAfterTransaction;

    @Column(name = "authorized_by")
    private String authorizedBy;

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    public enum TransactionType {
        DEPOSIT, WITHDRAW
    }
}
