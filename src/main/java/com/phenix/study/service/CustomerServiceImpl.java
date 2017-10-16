package com.phenix.study.service;

import com.phenix.study.dao.CustomerRepository;
import com.phenix.study.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Customer service implement
 *
 * @author john
 * @since 2017-10-16
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findCustomers(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    @Override
    public List<Customer> findAll() {
        return StreamSupport.stream(customerRepository.findAll()
                                                      .spliterator(), true)
                            .collect(Collectors.toList());
    }

    @Override
    public Customer find(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer add(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Boolean delete(Long id) {
        customerRepository.delete(id);
        return !exists(id);
    }

    @Override
    public Boolean exists(Long id) {
        return customerRepository.exists(id);
    }
}
