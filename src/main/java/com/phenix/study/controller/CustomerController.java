package com.phenix.study.controller;

import com.phenix.study.domain.Customer;
import com.phenix.study.dto.Resp;
import com.phenix.study.dto.RespData;
import com.phenix.study.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * CustomerController
 *
 * @author john
 * @since 2017-06-14
 */
@Api(value = "/customer", tags = "Customer", description = "operations about customer")
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    private Logger log = Logger.getLogger(CustomerController.this.getClass()
                                                                 .getSimpleName());

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "search customer", notes = "input keyword then return the customer")
    @ApiParam(value = "keyword", name = "query")
    @GetMapping("/search")
    public Resp findCustomer(@RequestParam(value = "keyword", defaultValue = "john") String keyword) {

        List<Customer> result = customerService.findCustomers(keyword);
        if (result.size() == 0) {
            return new Resp(0, "found none");
        } else {
            return new RespData<>(0, "success", new ArrayList<>(result));
        }
    }

    @GetMapping("/all")
    public Resp findAll() {
        return new RespData<>(0, "success", customerService.findAll());
    }

    @GetMapping("/{id}")
    public Resp findById(@PathVariable Long id) {
        return new RespData<>(0, "success", customerService.find(id));
    }

    @PutMapping("/add")
    public Resp add(@RequestBody Customer customer) {
        log.info(customer.toString());
        if (customer.toString()
                    .contains("=null,")) {
            return new Resp(-1, "input json error");
        }

        Customer result = customerService.add(customer);
        if (result == null) {
            return new Resp(-1, "add failure");
        }
        return new RespData<>(0, "success", result);
    }

    @DeleteMapping("/{id}")
    public Resp delete(@PathVariable Long id) {
        if (!customerService.exists(id)) {
            return new Resp(-1, "id not exists");
        }
        Boolean result = customerService.delete(id);
        if (result) {
            return new Resp(0, "success");
        } else {
            return new Resp(-1, "delete failure");
        }
    }


}
