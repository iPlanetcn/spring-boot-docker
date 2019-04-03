package com.phenix.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Welcome Controller
 *
 * @author john
 * @since 2017-10-16
 */
@ApiIgnore
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showMessage() {
        return "index";
    }
}
