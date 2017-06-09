package com.phenix.study.service;

import com.phenix.study.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void findCustomers() throws Exception {
        List<Customer> customerList = customerService.findCustomers("Lee");
        assertEquals(2, customerList.size());
    }

    @Test
    public void findAll() throws Exception {
        List<Customer> customerList = customerService.findAll();
        assertEquals(4, customerList.size());
    }

    @Test
    public void find() throws Exception {
        Customer customer = customerService.find(1L);
        assertEquals("John", customer.getFirstName());
    }

    @Test
    public void add() throws Exception {
        Customer customer = new Customer(null, "William", "Wallance");
        assertEquals(customer.getFirstName(), customerService.add(customer)
                                                             .getFirstName());
    }

}