package com.malkollm.ElJournalServer.controller;

import com.malkollm.ElJournalServer.model.dto.PageDto;
import com.malkollm.ElJournalServer.model.entity.Customer;
import com.malkollm.ElJournalServer.service.CustomerService;
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
    public ResponseEntity<?> create(@RequestBody Customer request) {
        Customer customer = customerService.create(request);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Customer customer = customerService.getById(id);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Customer request) {
        Customer update = customerService.update(id, request);
        return ResponseEntity.ok(update);
    }

    @GetMapping("get-all")
    public ResponseEntity<?> getAll() {
        List<Customer> customers = customerService.getAllList();
        return ResponseEntity.ok(customers);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getAllPagination(@RequestParam Map<String, String> params) {
        Page<Customer> allPagination = customerService.getAllPagination(params);
        PageDto pageDto = new PageDto(allPagination);
        return ResponseEntity.ok(pageDto);
    }
}
