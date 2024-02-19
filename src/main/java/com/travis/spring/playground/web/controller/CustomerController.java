package com.travis.spring.playground.web.controller;

import com.travis.spring.playground.model.customer.Customer;
import com.travis.spring.playground.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public Page<Customer> findAllCustomers(Pageable pageable) {
        return customerService.findAllCustomers(pageable);
    }

}
