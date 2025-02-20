package com.works.entities.impl;

public class Admin implements IUser{

    @Override
    public void control() {
        System.out.println("Admin control");
    }

}
