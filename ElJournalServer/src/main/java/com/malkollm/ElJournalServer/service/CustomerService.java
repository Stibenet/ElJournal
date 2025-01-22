package com.malkollm.ElJournalServer.service;

import com.malkollm.ElJournalServer.model.entity.Customer;

public interface CustomerService {
    Customer create (Customer request);

    Customer getById(int id);
}
