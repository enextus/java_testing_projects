package com.telran.demoqa.tests;

import com.telran.demoqa.pages.BrowserWindowsPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).goToFrameAlertAndWindowPage();
        new SidePanelPage(driver).selectBrowserWindows();
    }

    @Test
    public void newTabTest() {
        new BrowserWindowsPage(driver).clickOnNewTabBtn();
        Assert.assertTrue(new BrowserWindowsPage(driver).getTextFromNewTab().contains("sample"));
    }

    @Test
    public void newWindowsTest() {
        new BrowserWindowsPage(driver).clickOnNewWindowsBtn();
        Assert.assertTrue(new BrowserWindowsPage(driver).getTextFromNewTab().contains("sample"));
    }

}
