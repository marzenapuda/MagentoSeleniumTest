package com.marzenap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WomenJacketsPage {

    protected WebDriver driver;

    public WomenJacketsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='filter-options-title'and contains(text(),'Color')]")
    private WebElement colorFilterTab;

    @FindBy(xpath = "//div[div[@class='filter-options-title'and contains(text(),'Color')]]//div[@option-label='Blue']")
    private WebElement blueColorFilterOption;

    @FindBy(xpath = "//span[@class='filter-value']")
    private WebElement colorFilterStatus;




    public WomenJacketsPage selectColorFilterTab(){
        colorFilterTab.click();
        return this;
    }
    public WomenJacketsPage selectBlueFilter(){
        blueColorFilterOption.click();
        return this;
    }



    public void checkFilterStatus(){
        Assert.assertEquals(colorFilterStatus.getText(),"Blue");
    }



}
