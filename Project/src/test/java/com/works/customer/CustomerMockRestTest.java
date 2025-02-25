package com.works.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.works.ProjectApplication;
import com.works.entities.Customer;
import com.works.restcontrollers.CustomerRestController;
import com.works.services.CustomerService;
import com.works.utils.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {CustomerRestController.class})
public class CustomerMockRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CustomerService customerService;


    @Autowired
    private ObjectMapper mapper;

    @Test
    @Tag(Util.rest)
    @DisplayName("Customer Login - Mock Test")
    public void customerLoginTest() throws Exception {
        String url = "/customer/login";
        Customer customer = new Customer();
        customer.setEmail("ali@mail.com");
        customer.setPassword("12345");
        customer.setTc("48509311258");
        String stCustomer = mapper.writeValueAsString(customer);

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(stCustomer))
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andDo(MockMvcResultHandlers.print())
                .andReturn();

        String content = mvcResult.getRequest().getContentAsString();
        Customer bodyCustomer = mapper.readValue(content, Customer.class);
        Assertions.assertEquals("ali@mail.com", bodyCustomer.getEmail());

    }

}
