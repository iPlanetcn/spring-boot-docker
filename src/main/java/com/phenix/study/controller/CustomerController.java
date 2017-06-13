package com.phenix.study.controller;

import com.phenix.study.domain.Customer;
import com.phenix.study.dto.Resp;
import com.phenix.study.dto.RespData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "/customer", tags = "Customer", description = "operations about customer")
@RestController
@Log4j
@RequestMapping("/customer")
public class CustomerController extends BaseController {

    @ApiOperation(value = "search customer", notes = "input keyword then return the customer")
    @ApiParam(value = "keyword", name="query")
    @GetMapping("/search")
    public Resp findCustomer(@RequestParam(value = "keyword", defaultValue = "john") String keyword) {

        List<Customer> result = getCustomerService().findCustomers(keyword);
        if (result.size() == 0) {
            return new Resp(0, "found none");
        } else {
            return new RespData<>(0, "success", new ArrayList<>(result));
        }
    }

    @GetMapping("/all")
    public Resp findAll() {
        return new RespData<>(0, "success", getCustomerService().findAll());
    }

    @GetMapping("/{id}")
    public Resp findById(@PathVariable Long id) {
        return new RespData<>(0, "success", getCustomerService().find(id));
    }

    @PutMapping("/add")
    public Resp add(@RequestBody Customer customer) {
        log.info(customer.toString());
        if (customer.toString()
                    .contains("=null,")) {
            return new Resp(-1, "input json error");
        }

        Customer result = getCustomerService().add(customer);
        if (result == null) {
            return new Resp(-1, "add failure");
        }
        return new RespData<>(0, "success", result);
    }

    @DeleteMapping("/{id}")
    public Resp delete(@PathVariable Long id) {
        if (!getCustomerService().exists(id)) {
            return new Resp(-1, "id not exists");
        }
        Boolean result = getCustomerService().delete(id);
        if (result) {
            return new Resp(0, "success");
        } else {
            return new Resp(-1, "delete failure");
        }
    }


}
