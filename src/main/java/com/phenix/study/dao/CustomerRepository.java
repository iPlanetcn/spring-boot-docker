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
    List<Customer> findByLastName(String lastName);
}
