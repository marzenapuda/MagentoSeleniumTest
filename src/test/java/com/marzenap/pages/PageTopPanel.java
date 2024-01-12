package com.marzenap.pages;

import com.marzenap.models.Customer;
import com.marzenap.tests.CreateAccountTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PageTopPanel {
    private WebDriver driver;
    public PageTopPanel(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(linkText = "Create an Account")
    private WebElement createAccountButton;

    @FindBy(xpath = "//li[@class='authorization-link']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@class='logged-in']")
    private WebElement welcomeMessage;

    public CreateAccountPage goToCreateAccountPage(){
        createAccountButton.click();
        return new CreateAccountPage(driver);
    }

    public SignInPage goToSignInPage(){
        signInButton.click();
        return new SignInPage(driver);
    }

    public void checkWelcomeMessage(Customer customer){
        Assert.assertTrue(welcomeMessage.getText().contains(customer.getFirstName()));
    }

}
