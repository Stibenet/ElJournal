package com.malkollm.ElJournalServer.controller;

import com.malkollm.ElJournalServer.model.entity.Customer;
import com.malkollm.ElJournalServer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
