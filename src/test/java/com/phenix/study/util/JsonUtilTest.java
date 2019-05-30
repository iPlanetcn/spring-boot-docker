package com.phenix.study.util;

import com.phenix.study.domain.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JsonUtilTest {
    @Test
    public void testLoadCustomerFromJsonFile() throws Exception {
        Customer customer = JsonUtil.loadCustomer();
        assertNotNull(customer);
        assertEquals(1, customer.getId().longValue());
        assertEquals("John", customer.getFirstName());
        assertEquals("Lee", customer.getLastName());
    }
}