package com.malkollm.ElJournalServer.service.impl;

import com.malkollm.ElJournalServer.exception.ResourceNotFoundException;
import com.malkollm.ElJournalServer.model.entity.Customer;
import com.malkollm.ElJournalServer.repository.CustomerRepository;
import com.malkollm.ElJournalServer.service.CustomerService;
import com.malkollm.ElJournalServer.service.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public Page<Customer> getAllPagination(Map<String, String> params) {
        int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
        if (params.containsKey(PageUtil.PAGE_LIMIT)) {
            pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
        }

        int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
        if (params.containsKey(PageUtil.PAGE_NUMBER)) {
            pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
        }

        Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);

        Page<Customer> customer = customerRepository.findByIsDeletedFalseOrderByIdDesc(pageable);

        return customer;
    }
}
