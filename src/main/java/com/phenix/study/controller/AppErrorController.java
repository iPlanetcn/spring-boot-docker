package com.phenix.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * AppErrorController
 *
 * @author john
 * @since 2017-06-14
 */
@ApiIgnore
@RestController
public class AppErrorController extends AbstractErrorController {
    private static final String PATH = "/error";


    @Autowired
    public AppErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }


    @RequestMapping(value = PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> handleError(HttpServletRequest request) {
        return super.getErrorAttributes(request, true);
    }


    @Override
    public String getErrorPath() {
        return PATH;
    }
}
