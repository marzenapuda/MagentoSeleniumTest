package com.marzenap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public PageTopPanel pageTopPanel = new PageTopPanel(driver);
    public PageCategoriesPanel pageCategoriesPanel = new PageCategoriesPanel(driver);

    public PageSearchBar pageSearchBar = new PageSearchBar(driver);

}
