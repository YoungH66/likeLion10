package org.example.springdatajpa2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryTest.class);
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void save(){
        Customer customer = new Customer("nw_customer01", "testEmail001@test.com");
        customerRepository.save(customer);

        Assertions.assertThat(customerRepository.findById(11L).get().getName()).isEqualTo("nw_customer01");
        log.info("new customer: {}", customer.getName());
    }

//    @Test
//    void delete(){
//        Optional<Customer> customer = customerRepository.findById(11L);
//        customerRepository.delete(customer.get());
//    }

    @Test
    void findByName(){
        List<Customer> customers = customerRepository.findByName("nw_customer01");
//        Assertions.assertThat(customers).hasSize(1);
        for(Customer customer : customers){
            log.info("customer: {}", customer.getName());
        }
    }

    @Test
    void findByEmailContaining(){
        List<Customer> customers = customerRepository.findByEmailContaining("test");
        customers.forEach(customer -> log.info("customer: {}", customer.getEmail()));
    }

}