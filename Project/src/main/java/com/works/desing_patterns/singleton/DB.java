package com.works.desing_patterns.singleton;

public class DB {

    private static DB instance;

    public static DB getInstance() {

        if (instance == null) {
            synchronized (DB.class) {
                if (instance == null) {
                    instance = new DB();
                    System.out.println("DB Create");
                }
            }
        }
         /*
        if (instance == null) {
            try {
                Thread.sleep(1000);
                instance = new DB();
                System.out.println("DB Create");
            }catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        */
        return instance;
    }

}
