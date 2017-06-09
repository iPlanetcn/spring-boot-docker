package com.phenix.study.service;

import com.phenix.study.dao.CustomerRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
class BaseService {
    @SuppressWarnings("SpringAutowiredFieldsWarningInspection")
    @Autowired
    private CustomerRepository customerRepository;
}
