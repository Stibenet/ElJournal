package com.malkollm.ElJournalServer.mapper;

import com.malkollm.ElJournalServer.model.entity.Customer;
import com.malkollm.ElJournalServer.model.request.CustomerRequest;
import com.malkollm.ElJournalServer.model.response.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toEntity(CustomerRequest request);
    CustomerResponse toDto(Customer entity);
}
