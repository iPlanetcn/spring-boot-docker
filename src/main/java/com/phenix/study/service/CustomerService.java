package com.phenix.study.service;

import com.phenix.study.domain.Customer;

import java.util.List;

/**
 * Customer service interface
 */
public interface CustomerService {
    List<Customer> findCustomers(String lastName);

    List<Customer> findAll();

    Customer find(Long id);

    Customer add(Customer customer);

    Boolean delete(Long id);

    Boolean exists(Long id);
}
