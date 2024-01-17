package com.marzenap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PaymentMethodsPage {

    private WebDriver driver;

    public PaymentMethodsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@class='action primary checkout']")
    private WebElement placeOrderButton;
    @FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
    private WebElement orderConfirmationMessage;
    @FindBy(xpath = "//div[@class='loading-mask']")
    private WebElement overlay;


    public PaymentMethodsPage placeOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.invisibilityOf(overlay));
        placeOrderButton.click();
        return this;
    }

    public PaymentMethodsPage checkConfirmation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.invisibilityOf(overlay));
        Assert.assertTrue(orderConfirmationMessage.getText().contains("Thank you for your purchase!"));
        return this;
    }
}
