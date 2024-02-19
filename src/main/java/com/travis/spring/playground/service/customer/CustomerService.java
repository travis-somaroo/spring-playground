package com.travis.spring.playground.service.customer;

import com.travis.spring.playground.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    Page<Customer> findAllCustomers(Pageable pageable);
}
