package com.phenix.study.controller;

import com.phenix.study.dto.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@ApiIgnore
@RestController
public class AppErrorController implements ErrorController {
    private static final String PATH = "/error";

    private final ErrorAttributes errorAttributes;

    @Autowired
    public AppErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(value = PATH)
    Resp error(HttpServletRequest request, HttpServletResponse response) {
        return new Resp(response.getStatus(), getErrorAttributes(request).get("error").toString());
    }


    @Override
    public String getErrorPath() {
        return PATH;
    }

    private Map<String,Object> getErrorAttributes(HttpServletRequest request){
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes,false);
    }
}
