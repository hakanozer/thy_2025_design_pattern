package com.works.utils;

import com.works.entities.impl.IUser;
import jakarta.servlet.http.HttpServletRequest;

public class CustomerSecurity {

    final HttpServletRequest httpServletRequest;
    public CustomerSecurity(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public void customerValid( Long cid ){
        System.out.println( httpServletRequest.getSession().getId() );
        System.out.println("CustomerSecurity.customerValid : " + cid);
    }

    public void securityControl( IUser user ) {
        user.control();
    }

}
