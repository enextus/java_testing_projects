package com.telran.demoqa.tests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanelPage;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksAndImagesTests extends TestBase {

    public BrokenLinksAndImagesTests(EventFiringWebDriver driver) {
        super();
    }

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).gotoElementsPage();
    }

    @Test
    public void getAllLinksTest() {
        new SidePanelPage(driver).selectLinks();
        new BrokenLinksAndImagesTests(driver).getAllLinksTest();
    }

    @Test
    public void getBrokenLinksTest() {
        new SidePanelPage(driver).selectLinks();
        new BrokenLinksAndImagesTests()
    }
}
