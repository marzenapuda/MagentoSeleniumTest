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
    @FindBy(xpath = "//button[@class='button action continue primary' and not(div[@class='loading-mask'])]")
    private WebElement nextButton;
    @FindBy(xpath = "//div[@class='loading-mask']")
    private WebElement overlay;

    public CheckoutPage checkFirstName(String firstName) {
        Assert.assertEquals(firstNameInput.getAttribute("value"), firstName);
        return this;
    }

    public CheckoutPage checkLastName(String lastName) {
        Assert.assertEquals(lastNameInput.getAttribute("value"), lastName);
        return this;
    }

    public CheckoutPage fillCompany(String company) {
        companyInput.sendKeys(company);
        return this;
    }

    public CheckoutPage fillStreetAddress(String streetAddress) {
        streetInput.sendKeys(streetAddress);
        return this;
    }

    public CheckoutPage fillCity(String city) {
        cityInput.sendKeys(city);
        return this;
    }

    public CheckoutPage selectCountry(String country) {
        Select drpCountry = new Select(countrySelect);
        drpCountry.selectByVisibleText(country);
        return this;
    }

    public CheckoutPage selectState(String state) {
        Select drpState = new Select(stateSelect);
        drpState.selectByVisibleText(state);
        return this;
    }

    public CheckoutPage fillPostalCode(String postalCode) {
        postcodeInput.sendKeys(postalCode);
        return this;
    }

    public CheckoutPage fillPhone(String phone) {
        phoneInput.sendKeys(phone);
        return this;
    }

    public PaymentMethodsPage goToPaymentMethods() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOf(overlay));
        nextButton.click();
        return new PaymentMethodsPage(driver);
    }

}
