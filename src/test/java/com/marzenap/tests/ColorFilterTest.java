package com.marzenap.tests;

import com.marzenap.pages.PageCategoriesPanel;
import org.testng.annotations.Test;

public class ColorFilterTest extends BaseTest {
    @Test
    public void filterByColorTest() {

        new PageCategoriesPanel(driver)
                .goToWomenJackets()
                .selectColorFilterTab()
                .selectBlueFilter()
                .checkFilterStatus();

    }
}
