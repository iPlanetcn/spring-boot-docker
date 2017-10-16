package com.phenix.study.service;

import com.phenix.study.domain.Customer;

import java.util.List;

/**
 * Customer service interface
 *
 * @author john
 * @since 2017-10-16
 */
public interface CustomerService {
    /**
     * find customers by the last name
     *
     * @param lastName last name
     * @return Customer List
     */
    List<Customer> findCustomers(String lastName);

    /**
     * find all customer
     *
     * @return customer list
     */
    List<Customer> findAll();

    /**
     * find customer by id
     *
     * @param id id
     * @return customer
     */
    Customer find(Long id);

    /**
     * add customer
     *
     * @param customer customer
     * @return customer
     */
    Customer add(Customer customer);

    /**
     * delete customer
     *
     * @param id id
     * @return Boolean
     */
    Boolean delete(Long id);

    /**
     * check customer exists or not
     *
     * @param id id
     * @return Boolean
     */
    Boolean exists(Long id);
}
