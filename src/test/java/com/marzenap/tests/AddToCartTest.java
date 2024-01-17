package com.marzenap.tests;

import com.marzenap.pages.PageCategoriesPanel;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest{



    @Test
    public void addProductToCartTest(){
        new PageCategoriesPanel(driver)
                .goToWomensJackets()
                .selectColorFilterTab()
                .selectBlueFilter()
                .goToProductPage()
                .selectSizeM()
                .selectColorBlue()
                .addToCart()
                .checkMessage();
    }
}
