package com.travis.spring.playground.bootstrap;

import com.github.javafaker.Faker;
import com.travis.spring.playground.model.customer.Customer;
import com.travis.spring.playground.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Component
@RequiredArgsConstructor
public class DummyDataRunner implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    private final Faker faker;

    @Override
    public void run(String... args) throws Exception {
        generateCustomers();
    }

    private void generateCustomers() {
        log.info("Loading test data...");
        List<Customer> customers = IntStream.rangeClosed(1, 100)
            .mapToObj(i -> new Customer(
                faker.name().firstName(),
                faker.name().lastName()))
            .toList();
        customerRepository.saveAll(customers);
        log.info("Test data loaded!");
    }
}
