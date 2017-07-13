package com.phenix.study.service;

import com.phenix.study.domain.Customer;
import org.junit.After;
import org.junit.Before;
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

    @Before
    public void setup() throws Exception {
        clearAll();
        customerService.add(new Customer(1L,"John","Lee"));
        customerService.add(new Customer(2L,"John","Phoenix"));
    }

    @After
    public void tearDown() throws Exception {
        clearAll();
    }

    public void clearAll(){
        customerService.findAll().forEach(customer -> customerService.delete(customer.getId()));
    }

    @Test
    public void findCustomers() throws Exception {
        List<Customer> customerList = customerService.findCustomers("Lee");
        assertEquals(1, customerList.size());
    }

    @Test
    public void findAll() throws Exception {
        List<Customer> customerList = customerService.findAll();
        assertEquals(2, customerList.size());
    }

    @Test
    public void find() throws Exception {
        List<Customer> customerList = customerService.findCustomers("Lee");
        Customer customer = customerService.find(customerList.get(0).getId());
        assertEquals("John", customer.getFirstName());
    }

    @Test
    public void add() throws Exception {
        Customer customer = new Customer(null, "William", "Wallace");
        assertEquals(customer.getFirstName(), customerService.add(customer)
                                                             .getFirstName());
    }

}