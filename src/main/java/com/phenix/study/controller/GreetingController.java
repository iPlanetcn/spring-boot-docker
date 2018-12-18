package com.phenix.study.controller;

import com.google.common.base.Strings;
import com.phenix.study.bean.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicLong;

/**
 * GreetingController
 *
 * @author john
 * @since 2017-06-14
 */
@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
        if (Strings.isNullOrEmpty(name)) {
            int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, hour < 12 ?
                    "Good Morning" : "Good Night" +
                    ""));
        }
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }

}