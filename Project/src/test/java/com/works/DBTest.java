package com.works;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import com.works.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:test-application.properties")
@AutoConfigureMockMvc
public class DBTest {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Autowired
    private MockMvc mvc;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void loginTest() {
        System.out.println("dbUrl: " + dbUrl);
        Customer customer = new Customer();
        customer.setAge(30);
        customer.setTc("11355745898");
        customer.setPassword("123456");
        customer.setName("Erdal");
        customer.setSurname("Bil");
        customer.setEmail("erdal@gmail.com");
        customerRepository.save(customer);
        Assertions.assertNotNull(customer);
        Assertions.assertEquals(1, customer.getCid());
    }

}
