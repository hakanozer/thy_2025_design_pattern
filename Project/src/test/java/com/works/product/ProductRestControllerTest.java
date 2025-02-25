package com.works.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.works.desing_patterns.builder.ProductDirectory;
import com.works.entities.Product;
import com.works.restcontrollers.ProductRestController;
import com.works.services.ProductService;
import com.works.utils.Util;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

@WebMvcTest(controllers = {ProductRestController.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductDirectory productDirectory;

    @MockitoBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeAll
    public void setup() {
        // login call
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach call");
    }


    @Tag(Util.rest)
    @Order(1)
    @Test
    @DisplayName("Product Save Test")
    @EnabledIf("loginStatus")
    void productSaveTest() throws Exception {
        String url = "/product/save/1";
        Product product = new Product();
        product.setTitle("TV");
        product.setDescription("TV description");
        product.setPrice(new BigDecimal("100.00"));
        String stProduct = objectMapper.writeValueAsString(product);

        mockMvc.perform(
                MockMvcRequestBuilders.post(url)
                        .header("token", "token123")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(stProduct)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Tag(Util.rest)
    @Order(2)
    @Test
    @DisplayName("Product Create Test")
    @Disabled
    public void productCreateTest() throws Exception {
        String url = "/product/create/sale";
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get(url))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String content = mvcResult.getRequest().getContentAsString();
        System.out.println(content);
    }

    public boolean loginStatus() {
        // login call
        return true;
    }

}
