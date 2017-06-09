package com.phenix.study.dao;

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

    @Test
    public void testFindByLastName() throws Exception {
        assertEquals(2, customerRepository.findByLastName("Lee")
                                          .size());
    }
}