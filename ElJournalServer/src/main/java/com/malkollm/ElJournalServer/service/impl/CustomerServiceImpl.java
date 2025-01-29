package com.malkollm.ElJournalServer.service.impl;

import com.malkollm.ElJournalServer.exception.ResourceNotFoundException;
import com.malkollm.ElJournalServer.model.entity.Customer;
import com.malkollm.ElJournalServer.repository.CustomerRepository;
import com.malkollm.ElJournalServer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer create(Customer request) {
        return customerRepository.save(request);
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Customer", id));
    }

    @Override
    public Customer update(int id, Customer request) {
        Customer customer = getById(id);

        customer.setCustomerLocalName(request.getCustomerLocalName());
        customer.setCustomerEmail(request.getCustomerEmail());
        customer.setCustomerPhone(request.getCustomerPhone());
        customer.setCustomerAddress(request.getCustomerAddress());
        customer.setCustomerEnglishName(request.getCustomerEnglishName());

        return customerRepository.save(customer);

    }

    @Override
    public List<Customer> getAllList() {
        return customerRepository.findByIsDeletedFalseOrderByIdDesc();
    }

    @Override
    public void delete(int id) {
        Customer customer = getById(id);
        customer.setDeleted(true);
        customerRepository.save(customer);
    }
}
