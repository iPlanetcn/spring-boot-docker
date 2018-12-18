package com.phenix.study.controller;

import com.phenix.study.domain.Customer;
import com.phenix.study.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CustomerControllerTest {
    @Autowired
    private CustomerController customerController;

    @MockBean
    private CustomerService customerService;

    @Before
    public void setUp() {
        given(customerService.find(1L)).willReturn(new Customer("John", "Lee"));
    }

    @Test
    public void findById() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.customerController)
                                         .build();

        mockMvc.perform(
                get("/customer/1").contentType(MediaType.APPLICATION_JSON_UTF8))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
               .andExpect(jsonPath("$.code", is(0)))
               .andExpect(jsonPath("$.message", is("success")))
               .andExpect(jsonPath("$.data.firstName", is("John")))
               .andExpect(jsonPath("$.data.lastName", is("Lee")));

    }

}