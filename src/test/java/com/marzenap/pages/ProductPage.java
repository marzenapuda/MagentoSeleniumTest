package com.marzenap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@option-label='M']")
    private WebElement optionSizeM;
    @FindBy(xpath = "//div[@option-label='Blue']")
    private WebElement optionColorBlue;
    @FindBy(xpath = "//button[@title='Add to Cart']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//div[@data-ui-id='message-success']")
    private WebElement successfullyAddedToCartMessage;

    public ProductPage selectSizeM() {
        optionSizeM.click();
        return this;
    }

    public ProductPage selectColorBlue() {
        optionColorBlue.click();
        return this;
    }

    public ProductPage addToCart() {
        addToCartButton.click();
        return this;
    }

    public void checkMessage() {
        Assert.assertTrue(successfullyAddedToCartMessage.isDisplayed(),"Alert not displayed");
    }

}


