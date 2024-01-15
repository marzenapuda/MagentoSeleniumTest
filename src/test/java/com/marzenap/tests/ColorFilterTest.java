package com.marzenap.tests;

import com.marzenap.pages.PageCategoriesPanel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ColorFilterTest extends BaseTest{
    @Test
    public void filterByColorTest(){
        new PageCategoriesPanel(driver)
                .gotoWomensJackets()
                .selectColorFilterTab()
                .selectBlueFilter()
                .checkFilterStatus();


}}
