package com.works.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.works.ProjectApplication;
import com.works.entities.Customer;
import com.works.models.CustomerLogin;
import com.works.models.SendLogin;
import com.works.utils.Util;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerRestTemplateTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    //@Test
    @Tag(Util.rest)
    @Order(1)
    @DisplayName("Customer Login Test")
    @RepeatedTest(1)
    public void customerLoginTest() throws JsonProcessingException {
        String url = "https://jsonbulut.com/api/auth/login";
        SendLogin customer = new SendLogin();
        customer.setEmail("hakanozer02@gmail.com");
        customer.setPassword("12345");

        // String stCustomer = objectMapper.writeValueAsString(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity<>(customer, headers);
        try {
            ResponseEntity<CustomerLogin> response = restTemplate.postForEntity(url, entity, CustomerLogin.class);
            Assertions.assertAll(
                    () -> Assertions.assertEquals(response.getStatusCode().value(), 200),
                    () -> Assertions.assertNotNull(response.getBody())
            );
        }catch (Exception ex) {
            Assertions.assertTrue(false);
        }
    }


}
