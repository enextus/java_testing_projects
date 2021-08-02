package com.telran.demoqa.tests;

import com.telran.demoqa.pages.AlertsPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).goToFrameAlertAndWindowPage();
        new SidePanelPage(driver).selectAlerts();
    }

    @Test
    public void alertWaitTest() {
        new AlertsPage(driver).clickAlertButton2AndWait();
    }

    @Test
    public void cancelAlertTest() {
        new AlertsPage(driver).clickAlertButton3().clickOnCancelButton("Cancel");
        Assert.assertTrue(new AlertsPage(driver).getConfirmResult().contains("You selected Cancel"));
    }

    @Test
    public void alertSendTextTest() {
        new AlertsPage(driver).clickAlertButton4().sendTextToAlert("Hello");
        Assert.assertTrue(new AlertsPage(driver).getConfirmLastResult().contains("You entered Hello"));
    }

}
