package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import com.works.utils.CustomerSecurity;
import com.works.utils.ValidUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.InvalidPropertiesFormatException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;
    final CustomerSecurity customerSecurity;

    public Customer register(Customer customer) throws Exception{
        boolean tcValidStatus = ValidUtil.tcValid(customer.getTc());
        boolean passwordValidStatus = ValidUtil.passwordValid(customer.getPassword());

        if(!tcValidStatus ) {
            throw new InvalidPropertiesFormatException("TC no not valid");
        }else if (!passwordValidStatus){
            throw  new InvalidPropertiesFormatException("Password format not valid");
        }else {
            return customerRepository.save(customer);
        }

    }


    public Customer login(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmailEqualsIgnoreCaseAndPasswordEquals(customer.getEmail(), customer.getPassword());
        if (optionalCustomer.isPresent()) {
            Customer customerDb = optionalCustomer.get();
            // security id
            customerSecurity.customerValid(customerDb.getCid());
            return customerDb;
        }
        return null;
    }

}
