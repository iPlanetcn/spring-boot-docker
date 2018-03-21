package com.phenix.study.dao;

import com.phenix.study.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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
    @Query("SELECT a FROM Customer a WHERE a.lastName=:lastName")
    List<Customer> findByLastName(@Param("lastName") String lastName);
}
