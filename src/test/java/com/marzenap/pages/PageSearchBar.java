package com.marzenap.pages;

import com.marzenap.models.Customer;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.function.Function;

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

    @FindBy(xpath = "//a[@class='action showcart' and not(span[@class='counter qty _block-content-loading'])]")
    private WebElement showCartButton;

    @FindBy(xpath = "//a[@class='action showcart active' and not(span[@class='counter qty _block-content-loading'])]")
    private WebElement showCartActiveButton;

    @FindBy(xpath = "//div[a[@class='action showcart active']]//button[@id='top-cart-btn-checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//div[@data-block='minicart' and not(span[@class='counter qty _block-content-loading'])]")
    private WebElement minicart;

    @FindBy(xpath = "//div[@class='message-success success message']")
    private WebElement successAlert;

    public SearchResultsPage performSearch(Customer customer){
        searchField.sendKeys(customer.getProduct());
        searchButton.click();
        return new SearchResultsPage(driver);
    }

    public CheckoutPage proceedToChcekout(){


        minicart.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//strong[@class='subtitle empty']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Assert.assertTrue(successAlert.isDisplayed());
        minicart.click();

        proceedToCheckoutButton.click();
        return new CheckoutPage(driver);
    }


}
