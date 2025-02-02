package com.malkollm.ElJournalServer.controller;

import com.malkollm.ElJournalServer.mapper.Mapper;
import com.malkollm.ElJournalServer.model.dto.PageDto;
import com.malkollm.ElJournalServer.model.entity.Customer;
import com.malkollm.ElJournalServer.model.request.CustomerRequest;
import com.malkollm.ElJournalServer.model.response.CustomerResponse;
import com.malkollm.ElJournalServer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("customers")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@Valid @RequestBody CustomerRequest request) {
        Customer entity = Mapper.toEntity(request);
        Customer customer = customerService.create(entity);
        CustomerResponse dto = Mapper.toDto(customer);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable int id) {
        Customer customer = customerService.getById(id);

        CustomerResponse dto = Mapper.toDto(customer);

        return ResponseEntity.ok(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable int id,@Valid @RequestBody CustomerRequest request) {
        Customer entity = Mapper.toEntity(request);
        Customer update = customerService.update(id, entity);
        CustomerResponse dto = Mapper.toDto(update);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<CustomerResponse>> getAll() {
        List<CustomerResponse> customers = customerService.getAllList();
        return ResponseEntity.ok(customers);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<PageDto> getAllPagination(@RequestParam Map<String, String> params) {
        Page<CustomerResponse> allPagination = customerService.getAllPagination(params);
        PageDto pageDto = new PageDto(allPagination);
        return ResponseEntity.ok(pageDto);
    }
}
