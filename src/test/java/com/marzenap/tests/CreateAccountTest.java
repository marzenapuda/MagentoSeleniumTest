package com.marzenap.tests;

import com.marzenap.models.Customer;
import com.marzenap.pages.PageTopPanel;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {

    @Test
    public void createAccount() {
        String randomEmail =  System.currentTimeMillis() + "@email.com";
        Customer customer = new Customer();
        customer.setEmail(randomEmail);
        new PageTopPanel(driver)
                .goToCreateAccountPage()
                .fillFirstName(customer.getFirstName())
                .fillLastName(customer.getLastName())
                .fillEmail(customer.getEmail())
                .fillPassword(customer.getPassword())
                .fillConfirmPassword(customer.getPassword())
                .submitValid()
                .checkContactInformation(customer.getFirstName());

    }

    @Test
    public void createAccountExistingEmail() {
        Customer customer = new Customer();
        customer.setEmail("email@email.com");
        new PageTopPanel(driver)
                .goToCreateAccountPage()
                .fillFirstName(customer.getFirstName())
                .fillLastName(customer.getLastName())
                .fillEmail(customer.getEmail())
                .fillPassword(customer.getPassword())
                .fillConfirmPassword(customer.getPassword())
                .submitInvalid()
                .checkAlert();


    }


}
