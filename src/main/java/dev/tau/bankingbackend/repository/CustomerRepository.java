package dev.tau.bankingbackend.repository;

import dev.tau.bankingbackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="customer")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
