package com.phenix.study.dao;

import com.phenix.study.domain.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer;

    public CustomerRepositoryTest() {
        customer = new Customer(0L, "John", "Lee");
    }

    @Before
    public void setUp() throws Exception {
        customerRepository.findAll().forEach(c ->
                customerRepository.delete(c)
        );
        customerRepository.save(customer);
    }

    @After
    public void tearDown() throws Exception {
        customerRepository.findAll().forEach(c ->
                customerRepository.delete(c)
        );
    }

    @Test
    public void testFindByLastName() throws Exception {
        assertEquals(1, customerRepository.findByLastName("Lee")
                .size());
    }
}