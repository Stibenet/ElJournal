package com.malkollm.ElJournalServer.service.impl;

import com.malkollm.ElJournalServer.model.entity.Customer;
import com.malkollm.ElJournalServer.repository.CustomerRepository;
import com.malkollm.ElJournalServer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer create(Customer request) {
        return customerRepository.save(request);
    }
}
