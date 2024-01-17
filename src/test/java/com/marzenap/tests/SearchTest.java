package com.marzenap.tests;

import com.marzenap.models.Customer;
import com.marzenap.pages.PageSearchBar;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    @Test
    public void searchTest() {
        Customer customer = new Customer();
        new PageSearchBar(driver)
                .performSearch(customer)
                .checkSearchResultInfo(customer);
    }
}
