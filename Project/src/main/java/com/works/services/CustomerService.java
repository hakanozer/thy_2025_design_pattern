package com.works.services;

import com.works.entities.Customer;
import com.works.entities.impl.Admin;
import com.works.entities.impl.Operator;
import com.works.entities.impl.User;
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
    final NotificationsService notificationsService;

    public Customer register(Customer customer) throws Exception{
        boolean tcValidStatus = ValidUtil.tcValid(customer.getTc());
        boolean passwordValidStatus = ValidUtil.passwordValid(customer.getPassword());

        if(!tcValidStatus ) {
            throw new InvalidPropertiesFormatException("TC no not valid");
        }else if (!passwordValidStatus){
            throw  new InvalidPropertiesFormatException("Password format not valid");
        }else {
            Customer dbCustomer = customerRepository.save(customer);
            notificationsService.emailSend("","",dbCustomer.getEmail());
            return dbCustomer;
        }

    }

    public Customer login(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmailEqualsIgnoreCaseAndPasswordEquals(customer.getEmail(), customer.getPassword());
        if (optionalCustomer.isPresent()) {
            Customer customerDb = optionalCustomer.get();
            // security id
            customerSecurity.customerValid(customerDb.getCid());
            Admin admin = new Admin();
            User user = new User();
            Operator operator = new Operator();
            customerSecurity.securityControl(user);
            return customerDb;
        }
        return null;
    }

}
