package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import com.works.utils.ValidUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.InvalidPropertiesFormatException;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;

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


}
