package com.marzenap.pages;

import com.marzenap.models.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchResultsPage {
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
    private WebElement searchResultInfo;


    public SearchResultsPage checkSearchResultInfo(Customer customer) {
        Assert.assertTrue(searchResultInfo.getText().contains(customer.getProduct()));
        return this;
    }
}
