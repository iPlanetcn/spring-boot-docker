package com.phenix.study.dao;

import com.phenix.study.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Customer dao: contains CRUD actions.
 *
 * @author john
 * @since 2017-06-09
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    /**
     * find customer by the last name
     *
     * @param lastName last name of customer
     * @return Customer List
     */
    List<Customer> findByLastName(String lastName);
}
