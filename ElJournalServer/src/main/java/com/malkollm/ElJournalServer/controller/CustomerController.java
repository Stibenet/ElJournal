package com.malkollm.ElJournalServer.controller;

import com.malkollm.ElJournalServer.model.entity.Customer;
import com.malkollm.ElJournalServer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
