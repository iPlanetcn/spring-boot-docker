package com.phenix.study.controller;

import com.phenix.study.service.CustomerService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * BaseController
 *
 * @author john
 * @since 2017-06-14
 */
@Getter
class BaseController {
    @SuppressWarnings("SpringAutowiredFieldsWarningInspection")
    @Autowired
    private CustomerService customerService;
}
