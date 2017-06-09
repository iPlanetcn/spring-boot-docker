package com.phenix.study.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.phenix.study.domain.Customer;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

@SuppressWarnings("ALL")
public class JsonUtil {
    private static final String CUSTOMER = "static/customer.json";
    private static final String CUSTOMERS = "static/customer_list.json";

    public static Customer loadCustomer() {
        return new Gson().fromJson(getJson(CUSTOMER), Customer.class);
    }

    public static List<Customer> loadCustomerList() {
        Type type = new TypeToken<List<Customer>>() {
        }.getType();
        return new Gson().fromJson(getJson(CUSTOMERS), type);
    }

    private static String getJson(String filePath) {
        String json;
        try {
            File file = new ClassPathResource(filePath).getFile();
            InputStream is = new FileInputStream(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            //noinspection ResultOfMethodCallIgnored
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
