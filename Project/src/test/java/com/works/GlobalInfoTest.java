package com.works;

import com.works.services.CustomerService;
import com.works.utils.ValidUtil;
import com.works.utils.Word;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GlobalInfoTest {

    @Autowired
    CustomerService customerService;

    static Word word;

    @BeforeAll
    public static void setup(){
        System.out.println("BeforeAll call");
        word = new Word();
    }

    @Order(1)
    @Test
    public void zTest() {
        Assertions.assertTrue(false);
        System.out.println("zTest call");
    }

    @Order(2)
    @Test
    public void bTest() {
        System.out.println("bTest call");
    }

    @Order(3)
    @Test
    public void cTest() {
        boolean tcStatus = ValidUtil.tcValid("2134567");
        System.out.println("aTest call : " + tcStatus);
        //Assertions.assertTrue(tcStatus);
        Assertions.assertTrue(tcStatus);
    }

    @BeforeEach
    public void beforeTest(){
        System.out.println("beforeTest call");
    }

    @AfterEach
    public void afterTest(){
        System.out.println("afterTest call");
    }

    @AfterAll
    public static void tearDown(){
        word = null;
        System.out.println("AfterAll call");
    }

}
