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

    @FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in' and contains(.,'Welcome')]")
    private WebElement welcomeMessage;

    @FindBy(xpath = "//span[@class='customer-name']")
    private WebElement customerDropdown;

    @FindBy(xpath = "//a[contains(.,'Sign Out')]")
    private WebElement signOutButton;

    public CreateAccountPage goToCreateAccountPage(){
        createAccountButton.click();
        return new CreateAccountPage(driver);
    }

    public SignInPage goToSignInPage(){
        signInButton.click();
        return new SignInPage(driver);
    }

    public PageTopPanel signOut(){
        customerDropdown.click();
        signOutButton.click();
        return new PageTopPanel(driver);
    }

    public PageTopPanel checkWelcomeMessage(Customer customer){
        Assert.assertTrue(welcomeMessage.getText().contains(customer.getFirstName()));
        return new PageTopPanel(driver);
    }

    public PageTopPanel checkMessageAfterLogout(){
        Assert.assertTrue(signOutButton.getText().contains("Sign In"));
        return new PageTopPanel(driver);
    }

}
