package com.works.configs;

import com.works.utils.CustomerSecurity;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class AppBeans {

    @Bean(name = "customerSecurity")
    public CustomerSecurity customerSecurity(HttpServletRequest httpServletRequest) {
        return new CustomerSecurity(httpServletRequest);
    }

    @Bean
    public Random customerRandom( CustomerSecurity customerSecurity ) {
        return new Random();
    }

    /*
    @Bean(name = "customerSecurityConfig")
    public CustomerSecurity customerSecurityConfig(String data) {
        return new CustomerSecurity();
    }
     */



}
