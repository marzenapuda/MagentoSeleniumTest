package com.marzenap.pages;

import com.marzenap.models.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@name='company']")
    private WebElement companyInput;
    @FindBy(xpath = "//input[@name='street[0]']")
    private WebElement streetInput;
    @FindBy(xpath = "//input[@name='city']")
    private WebElement cityInput;
    @FindBy(xpath = "//select[@name='country_id']")
    private WebElement countrySelect;
    @FindBy(xpath = "//select[@name='region_id']")
    private WebElement stateSelect;
    @FindBy(xpath = "//input[@name='postcode']")
    private WebElement postcodeInput;
    @FindBy(xpath = "//input[@name='telephone']")
    private WebElement phoneInput;
    @FindBy(xpath = "//button[@class='button action continue primary' and not (div[@class='loading-mask'])]")
    private WebElement nextButton;
    @FindBy(xpath = "//div[@class='loading-mask']")
    private WebElement overlay;

    public CheckoutPage checkFirstName(Customer customer) {
        Assert.assertEquals(firstNameInput.getAttribute("value"), customer.getFirstName());
        return this;
    }

    public CheckoutPage checkLastName(Customer customer) {
        Assert.assertEquals(lastNameInput.getAttribute("value"), customer.getLastName());
        return this;
    }

    public CheckoutPage fillCompany(Customer customer) {
        companyInput.sendKeys(customer.getCompany());
        return this;
    }

    public CheckoutPage fillStreetAddress(Customer customer) {
        streetInput.sendKeys(customer.getStreetAddress());
        return this;
    }

    public CheckoutPage fillCity(Customer customer) {
        cityInput.sendKeys(customer.getCity());
        return this;
    }

    public CheckoutPage selectCountry(Customer customer) {
        Select drpCountry = new Select(countrySelect);
        drpCountry.selectByVisibleText(customer.getCountry());
        return this;
    }

    public CheckoutPage selectState(Customer customer) {
        Select drpState = new Select(stateSelect);
        drpState.selectByVisibleText(customer.getState());
        return this;
    }

    public CheckoutPage fillPostalCode(Customer customer) {
        postcodeInput.sendKeys(customer.getPostalCode());
        return this;
    }

    public CheckoutPage fillPhone(Customer customer) {
        phoneInput.sendKeys(customer.getPhone());
        return this;
    }

    public PaymentMethodsPage goToPaymentMethods() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOf(overlay));
        nextButton.click();
        return new PaymentMethodsPage(driver);
    }

}
