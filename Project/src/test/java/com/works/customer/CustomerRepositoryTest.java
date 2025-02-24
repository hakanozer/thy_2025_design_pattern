package com.works.customer;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import com.works.utils.Util;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    private Util util;

    @BeforeAll
    public void setup() {
        util = new Util();
        customerRepository.saveAll(util.customerResult());
    }

    @Test
    @Order(1)
    @DisplayName("Customer Add Test")
    public void addCustomerTest() {
        Customer customer = util.customerResult().get(0);
        customerRepository.save(customer);
        Assertions.assertAll(
                () -> Assertions.assertNotNull(customer),
                () -> Assertions.assertEquals(11, customer.getCid())
        );
    }

    @Test
    @Order(2)
    @DisplayName("Customer All Result Test")
    public void allCustomerTest() {
        List<Customer> customerList = customerRepository.findAll();
        Assertions.assertEquals(10, customerList.size());
    }

    @Test
    @Order(3)
    @DisplayName("Customer Delete Test")
    public void deleteTest() {
        Optional<Customer> customerOptional = customerRepository.findById(15l);
        if (customerOptional.isPresent()) {
            customerRepository.delete(customerOptional.get());
            Assertions.assertTrue(true);
        }else {
            Assertions.assertTrue(false);
        }
    }

}
