package com.works.customer;

import com.works.ProjectApplication;
import com.works.entities.Customer;
import com.works.services.CustomerService;
import com.works.utils.AppEnum;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {ProjectApplication.class} )
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @ParameterizedTest(name = "1st={0}, 2nd={1}")
    @CsvSource(value = { "ali@mail.com, 12345", "kemal@mail.com, 123456" })
    @Order(1)
    @DisplayName("Customer Login Test")
    public void customerLoginTest( String email, String password ) {
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword(password);
        Customer dbCustomer = customerService.login(customer);
        Assertions.assertAll(
                () -> Assertions.assertNotNull(dbCustomer),
                () -> Assertions.assertEquals(1, dbCustomer.getCid())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"ali@mail.com", "veli@mail.com", "zehra@mail.com"})
    @Order(2)
    @DisplayName("Parameter Test")
    public void parametersTest(String item) {
        System.out.println(item);
    }

    @ParameterizedTest(name = "1st={0}, 2nd={1}")
    @CsvSource(value = { "ali@mail.com, 12345", "kemal@mail.com, 123456" })
    @Order(3)
    @DisplayName("Parameters All Test")
    public void parametersAllTest(String email, String password) {
        System.out.println(email + " " + password);
    }


    @Order(4)
    @DisplayName("Customer All Login Test")
    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/customer.csv"})
    public void customerAllLoginTest(long id, int age, String email, String name, String password, String surname, String tc) {
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword(password);
        Customer dbCustomer = customerService.login(customer);
        Assertions.assertAll(
                () -> Assertions.assertNotNull(dbCustomer),
                () -> Assertions.assertEquals(id, dbCustomer.getCid())
        );
    }

    @Order(5)
    @DisplayName("Customer All Enum Test")
    @ParameterizedTest
    @EnumSource( AppEnum.class )
    @Disabled
    public void enumParamsTest( AppEnum appEnum ) {
        System.out.println( appEnum );
    }

    @Test
    @Order(6)
    @DisplayName("Status Test")
    @EnabledIf("status")
    public void statusTest() {
        System.out.println("statusTest call");
    }

    public boolean status() {
        return customerService == null ? true : false;
    }

}
