package com.malkollm.ElJournalServer.mapper;

import com.malkollm.ElJournalServer.model.entity.Customer;
import com.malkollm.ElJournalServer.model.request.CustomerRequest;
import com.malkollm.ElJournalServer.model.response.CustomerResponse;

public class Mapper {
    public static Customer toEntity(CustomerRequest dto) {
        Customer customer = new Customer();

        customer.setCustomerLocalName(dto.getCustomerLocalName());
        customer.setCustomerEnglishName(dto.getCustomerEnglishName());
        customer.setCustomerEmail(dto.getCustomerEmail());
        customer.setCustomerPhone(dto.getCustomerPhone());
        customer.setCustomerAddress(dto.getCustomerAddress());

        return customer;
    }

    public static CustomerResponse toDto(Customer customer) {
        CustomerResponse dto = new CustomerResponse();

        dto.setId(customer.getId());
        dto.setCustomerLocalName(customer.getCustomerLocalName());
        dto.setCustomerEnglishName(customer.getCustomerEnglishName());
        dto.setCustomerEmail(customer.getCustomerEmail());
        dto.setCustomerPhone(customer.getCustomerPhone());
        dto.setCustomerAddress(customer.getCustomerAddress());

        return dto;
    }
}
