package com.works.utils;

import com.works.entities.Customer;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public final static String rest = "rest";
    public final static String service = "service";
    public final static String db = "db";
    public final static String security = "security";

    public List<Customer> customerResult() {
        List<Customer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            customer.setAge(30);
            customer.setTc("11355745898");
            customer.setPassword("1234"+i);
            customer.setName("User-"+i);
            customer.setSurname("Bil-"+i);
            customer.setEmail("erdal@gmail.com"+i);
            list.add(customer);
        }
        return list;
    }

}
