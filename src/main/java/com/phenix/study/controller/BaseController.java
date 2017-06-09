package com.phenix.study.controller;

import com.phenix.study.service.CustomerService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
class BaseController {
    @SuppressWarnings("SpringAutowiredFieldsWarningInspection")
    @Autowired
    private CustomerService customerService;
}
