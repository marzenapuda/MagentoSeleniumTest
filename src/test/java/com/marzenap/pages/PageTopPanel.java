package com.marzenap.pages;

import com.marzenap.tests.CreateAccountTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageTopPanel {
    private WebDriver driver;
    public PageTopPanel(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(linkText = "Create an Account")
    private WebElement createAccountButton;

    @FindBy(linkText = " Sign In ")
    private WebElement signInButton;

    public CreateAccountPage goToCreateAccountPage(){
        createAccountButton.click();
        return new CreateAccountPage(driver);
    }

}
