package com.phenix.study.service;

import com.google.common.collect.Lists;
import com.phenix.study.dao.CustomerRepository;
import com.phenix.study.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;
    @MockBean
    private CustomerRepository customerRepository;

    private Customer anotherCustomer;
    private Customer customerFirst;

    @Before
    public void setup() {
        customerFirst = new Customer("John", "Lee");
        customerFirst.setId(1L);
        Customer customerSecond = new Customer("John", "Phoenix");
        customerSecond.setId(2L);
        anotherCustomer = new Customer("William", "Wallace");

        given(customerRepository.findByLastName("Lee"))
                .willReturn(Lists.newArrayList(customerFirst));
        given(customerRepository.findAll())
                .willReturn(Lists.newArrayList(customerFirst, customerSecond));
        given(customerRepository.save(anotherCustomer))
                .willReturn(anotherCustomer);
        given(customerRepository.findById(1L))
                .willReturn(Optional.of(customerFirst));
    }

    @Test
    public void findCustomers() {
        List<Customer> customerList = customerService.findCustomers("Lee");
        assertEquals(1, customerList.size());
    }

    @Test
    public void findAll() {
        List<Customer> customerList = customerService.findAll();
        assertEquals(2, customerList.size());
    }

    @Test
    public void find() {
        Customer customer = customerService.find(customerFirst.getId());
        assertEquals(customerFirst.getFirstName(), customer.getFirstName());
    }

    @Test
    public void add() {
        assertEquals(anotherCustomer.getFirstName(), customerService.add(anotherCustomer)
                                                             .getFirstName());
    }

}