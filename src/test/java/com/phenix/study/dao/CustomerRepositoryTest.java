package com.phenix.study.dao;

import com.phenix.study.domain.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Before
    public void setUp() {
        customerRepository.deleteAll();
        entityManager.persistAndFlush(new Customer("John", "Lee"));
    }

    @After
    public void tearDown() {
        entityManager.clear();
    }

    @Test
    public void testFindByLastName() {
        List<Customer> customerList = customerRepository.findByLastName("Lee");
        assertEquals(1,customerList.size());
    }
}