package dev.tau.bankingbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String phoneNumber;
    private String alternatePhoneNumber;
    private LocalDate dateOfBirth;
    private String socialSecurityNumber;
    private String accountType;
    private String accountNumber;
    private BigDecimal accountBalance;
    private String occupation;
    private String employerName;
    private String employmentStatus;
}
