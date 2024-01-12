package com.marzenap.tests;

import com.marzenap.models.Customer;
import com.marzenap.pages.PageTopPanel;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest{

    @Test(dependsOnMethods = "com.marzenap.tests.CreateAccountTest.createAccount")
    public void signInTest(){
        Customer customer = new Customer();
        new PageTopPanel(driver).goToSignInPage().fillEmail(customer).fillPassword(customer).clickSignInButton();

    }
}
