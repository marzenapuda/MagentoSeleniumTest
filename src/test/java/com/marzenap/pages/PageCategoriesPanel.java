package com.marzenap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCategoriesPanel {

    private WebDriver driver;

    public PageCategoriesPanel(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//li[@class='level0 nav-2 category-item level-top parent ui-menu-item']")
    private WebElement womenCategoryButton;
    @FindBy(xpath = "//li[@class='level1 nav-2-1 category-item first parent ui-menu-item']")
    private WebElement topsCategoryButton;
    @FindBy(xpath = "//a[@id='ui-id-11']")
    private WebElement jacketsCategoryButton;

    public WomenJacketsPage goToWomenJackets(){
        new Actions(driver).moveToElement(womenCategoryButton).perform();
        new Actions(driver).moveToElement(topsCategoryButton).perform();
        new Actions(driver).moveToElement(jacketsCategoryButton).perform();

        jacketsCategoryButton.click();
        return new WomenJacketsPage(driver);
    }
}
