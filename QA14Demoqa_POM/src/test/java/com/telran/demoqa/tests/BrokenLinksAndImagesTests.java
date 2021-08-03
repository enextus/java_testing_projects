package com.telran.demoqa.tests;

import com.telran.demoqa.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksAndImagesTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).gotoElementsPage();
    }

    @Test
    public void
}
