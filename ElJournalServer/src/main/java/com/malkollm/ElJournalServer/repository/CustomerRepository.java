package com.malkollm.ElJournalServer.repository;

import com.malkollm.ElJournalServer.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByIdAndIsDeletedFalse(int id);
    List<Customer> findByIsDeletedFalseOrderByIdDesc();
}
