package dev.tau.bankingbackend.repository;

import dev.tau.bankingbackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
