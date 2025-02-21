package com.works.utils;

import com.works.desing_patterns.singleton.DB;

public class Action extends Thread{

    @Override
    public void run() {
        DB.getInstance();
    }
}
