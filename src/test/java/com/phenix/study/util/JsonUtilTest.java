package com.phenix.study.util;

import com.phenix.study.domain.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JsonUtilTest {
    @Test
    public void testLoadCustomerFromJsonFile() throws Exception {
        Customer customer = JsonUtil.loadCustomer();
        assertTrue(customer != null);
        assertEquals(1, customer.getId()
                                .longValue());
        assertEquals("John", customer.getFirstName());
        assertEquals("Lee", customer.getLastName());
    }
}