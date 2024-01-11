package com.marzenap.tests;

import com.marzenap.models.Customer;
import com.marzenap.pages.CreateAccountPage;
import com.marzenap.pages.LoggedUserPage;
import com.marzenap.pages.PageTopPanel;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class CreateAccountTest extends BaseTest{

    @Test
    public void createAccount(){
        String randomEmail = "email" + (int) (Math.random() * 100) + "@email.com";
        Customer customer = new Customer();
        customer.setEmail(randomEmail);
        WebElement contactInformation = new PageTopPanel(driver).goToCreateAccountPage()
                .fillNewAccountForm(customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPassword())
                .getContactInformation();

        Assert.assertTrue(contactInformation.getText().contains(customer.getFirstName()));
    }







}
