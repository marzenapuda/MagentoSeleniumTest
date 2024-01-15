package com.marzenap.pages;

import com.marzenap.models.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisteredUserPage {

    private WebDriver driver;
    public RegisteredUserPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='box-content']/p")
    private WebElement contactInformation;

    public WebElement getContactInformation() {
        return contactInformation;
    }

    public void checkContactInformation(Customer customer){
        Assert.assertTrue(contactInformation.getText().contains(customer.getFirstName()));
    }
}
