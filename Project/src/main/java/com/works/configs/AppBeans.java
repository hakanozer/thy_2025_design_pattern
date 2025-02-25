package com.works.configs;

import com.works.desing_patterns.factory_method.CreateFabric;
import com.works.utils.CustomerSecurity;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Configuration
public class AppBeans {

    @Bean(name = "customerSecurity")
    public CustomerSecurity customerSecurity(HttpServletRequest httpServletRequest) {
        System.out.println("customerSecurity call");
        return new CustomerSecurity(httpServletRequest);
    }

    @Bean
    public Random customerRandom( CustomerSecurity customerSecurity ) {
        return new Random();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /*
    @Bean
    public CreateFabric createFabric() {
        return new CreateFabric();
    }
     */

    /*
    @Bean(name = "customerSecurityConfig")
    public CustomerSecurity customerSecurityConfig(String data) {
        return new CustomerSecurity();
    }
     */



}
