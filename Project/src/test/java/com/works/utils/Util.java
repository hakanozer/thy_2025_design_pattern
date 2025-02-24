package com.works.utils;

import com.works.entities.Customer;

import java.util.ArrayList;
import java.util.List;

public class Util {

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
