package com.marzenap.pages;

import com.marzenap.models.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateAccountPage {

    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@name='password_confirmation']")
    private WebElement confirmPasswordInput;
    @FindBy(xpath = "//button[@class='action submit primary']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='message-error error message']")
    private WebElement alert;


    public CreateAccountPage fillFirstName(Customer customer) {
        firstNameInput.sendKeys(customer.getFirstName());
        return this;
    }

    public CreateAccountPage fillLastName(Customer customer) {
        lastNameInput.sendKeys(customer.getLastName());
        return this;
    }

    public CreateAccountPage fillEmail(Customer customer) {
        emailInput.sendKeys(customer.getEmail());
        return this;
    }

    public CreateAccountPage fillPassword(Customer customer) {
        passwordInput.sendKeys(customer.getPassword());
        return this;
    }

    public CreateAccountPage fillConfirmPassword(Customer customer) {
        confirmPasswordInput.sendKeys(customer.getPassword());
        return this;
    }

    public RegisteredUserPage submitValid() {
        submitButton.click();
        return new RegisteredUserPage(driver);
    }

    public CreateAccountPage submitInvalid() {
        submitButton.click();
        return this;
    }


    public void checkAlert() {
        Assert.assertTrue(alert.getText().contains("There is already an account with this email address."));
    }

}


