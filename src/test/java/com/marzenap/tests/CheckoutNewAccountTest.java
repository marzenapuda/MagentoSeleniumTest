package com.marzenap.tests;

import com.marzenap.models.Customer;
import com.marzenap.pages.PageCategoriesPanel;
import com.marzenap.pages.PageSearchBar;
import com.marzenap.pages.PageTopPanel;
import org.testng.annotations.Test;

public class CheckoutNewAccountTest extends BaseTest {

    @Test(dependsOnMethods = "com.marzenap.tests.CreateAccountTest.createAccount")
    public void checkoutTest() {
        Customer customer = new Customer();

        new PageTopPanel(driver)
                .goToSignInPage()
                .fillEmail(customer.getEmail())
                .fillPassword(customer.getPassword())
                .clickSignInButton();

        new PageCategoriesPanel(driver)
                .goToWomenJackets()
                .selectColorFilterTab()
                .selectBlueFilter()
                .goToProductPage()
                .selectSizeM()
                .selectColorBlue()
                .addToCart();

        new PageSearchBar(driver)
                .proceedToCheckout()
                .checkFirstName(customer.getFirstName())
                .checkLastName(customer.getLastName())
                .fillCompany(customer.getCompany())
                .fillPostalCode(customer.getPostalCode())
                .fillStreetAddress(customer.getStreetAddress())
                .fillCity(customer.getCity())
                .selectCountry(customer.getCountry())
                .selectState(customer.getState())
                .fillPhone(customer.getPhone())
                .goToPaymentMethods()
                .placeOrder()
                .checkConfirmation();

    }
}
