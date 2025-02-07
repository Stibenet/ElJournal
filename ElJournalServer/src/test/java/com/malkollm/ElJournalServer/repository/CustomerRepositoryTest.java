package com.malkollm.ElJournalServer.repository;

import com.malkollm.ElJournalServer.model.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CustomerRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void whenFindByIdAndIsDeleteFalse_thenReturnCustomer() {
        Customer customer = new Customer();
        customer.setDeleted(false);
        entityManager.persist(customer);
        entityManager.flush();

        //test find by ID and no delete
        Optional<Customer> foundCustomer = customerRepository.findByIdAndIsDeletedFalse(customer.getId());
        assertThat(foundCustomer.isPresent()).isTrue();
        assertThat(foundCustomer.get().getId()).isEqualTo(customer.getId());
    }
}
