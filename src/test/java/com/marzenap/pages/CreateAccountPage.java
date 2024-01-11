package com.marzenap.pages;

import com.marzenap.models.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    private WebDriver driver;
    public CreateAccountPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
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


    public void fillFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
    }
    public void fillLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }
    public void fillEmail(String email){
        emailInput.sendKeys(email);
    }
    public void fillPassword(String password){
        passwordInput.sendKeys(password);
    }
    public void fillConfirmPassword(String password){
        confirmPasswordInput.sendKeys(password);
    }

    public LoggedUserPage fillNewAccountForm(Customer customer){
        fillFirstName(customer.getFirstName());
        fillLastName(customer.getLastName());
        fillEmail(customer.getEmail());
        fillPassword(customer.getPassword());
        fillConfirmPassword(customer.getPassword());
        submitButton.click();
        return new LoggedUserPage(driver);
    }
}


