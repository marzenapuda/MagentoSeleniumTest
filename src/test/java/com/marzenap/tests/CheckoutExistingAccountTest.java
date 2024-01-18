package com.marzenap.tests;

import com.marzenap.models.Customer;
import com.marzenap.pages.PageCategoriesPanel;
import com.marzenap.pages.PageSearchBar;
import com.marzenap.pages.PageTopPanel;
import org.testng.annotations.Test;

public class CheckoutExistingAccountTest extends BaseTest {

    @Test
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
                .goToPaymentMethods()
                .placeOrder()
                .checkConfirmation();

    }
}
