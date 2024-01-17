package com.marzenap.tests;

import com.marzenap.models.Customer;
import com.marzenap.pages.MainPage;
import com.marzenap.pages.PageCategoriesPanel;
import com.marzenap.pages.PageSearchBar;
import com.marzenap.pages.PageTopPanel;
import org.testng.annotations.Test;

public class CheckoutTestNewAccount extends BaseTest{

    @Test(dependsOnMethods = "com.marzenap.tests.CreateAccountTest.createAccount")
    public void checkoutTest(){
        Customer customer = new Customer();
        //sign in
        new PageTopPanel(driver)
                .goToSignInPage()
                .fillEmail(customer)
                .fillPassword(customer)
                .clickSignInButton();

                new PageCategoriesPanel(driver)
                .goToWomensJackets()
                .selectColorFilterTab()
                .selectBlueFilter()
                .goToProductPage()
                .selectSizeM()
                .selectColorBlue()
                .addToCart();

        //proceed to checkout and fill address form
        new PageSearchBar(driver).proceedToChcekout().checkFirstName(customer).fillCompany(customer).fillPostalCode(customer).fillStreetAddress(customer)
                .fillCity(customer).selectCountry(customer).selectState(customer).fillPhone(customer).goToPaymentMethods().placeOrder().checkConfirmation();

    }
}
