package com.marzenap.pages;

import com.marzenap.models.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSearchBar {

    private WebDriver driver;
    public PageSearchBar(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class='action search']")
    private WebElement searchButton;

    public SearchResultsPage performSearch(Customer customer){
        searchField.sendKeys(customer.getProduct());
        searchButton.click();
        return new SearchResultsPage(driver);
    }
}
