package com.malkollm.ElJournalServer.service;

import com.malkollm.ElJournalServer.model.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer create (Customer request);

    Customer getById(int id);

    Customer update(int id, Customer request);

    List<Customer> getAllList();

    void delete(int id);
}
