package com.works.desing_patterns.factory_method;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateFabric {

    final HttpServletRequest httpServletRequest;

    public IProduct create( IProductFactory iProductFactory ) {
        String url = httpServletRequest.getRequestURI();
        System.out.println("URL : " + url);
        return iProductFactory.createProduct();
    }

}
