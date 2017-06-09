package com.phenix.study.service;

import com.phenix.study.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerServiceImpl extends BaseService
        implements CustomerService {

    @Override
    public List<Customer> findCustomers(String lastName) {
        return getCustomerRepository().findByLastName(lastName);
    }

    @Override
    public List<Customer> findAll() {
        return StreamSupport.stream(getCustomerRepository().findAll()
                                                           .spliterator(), true)
                            .collect(Collectors.toList());
    }

    @Override
    public Customer find(Long id) {
        return getCustomerRepository().findOne(id);
    }

    @Override
    public Customer add(Customer customer) {
        return getCustomerRepository().save(customer);
    }

    @Override
    public Boolean delete(Long id) {
        getCustomerRepository().delete(id);
        return !exists(id);
    }

    @Override
    public Boolean exists(Long id) {
        return getCustomerRepository().exists(id);
    }
}
