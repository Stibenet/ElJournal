package com.malkollm.ElJournalServer.service;

import com.malkollm.ElJournalServer.model.entity.Customer;
import com.malkollm.ElJournalServer.model.response.CustomerResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    Customer create (Customer request);

    Customer getById(int id);

    Customer update(int id, Customer request);

    List<CustomerResponse> getAllList();

    void delete(int id);

    Page<CustomerResponse> getAllPagination(Map<String, String> params);
}
