package com.example.stats.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}