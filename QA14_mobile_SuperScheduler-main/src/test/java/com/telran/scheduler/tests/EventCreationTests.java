package com.telran.scheduler.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EventCreationTests extends TestBase {

    @Test
    public void registerTest() {
        app.user().register();
    }


    @Test
    public void eventCreationOfRegisteredUserTest() throws InterruptedException {
        int quantityBeforeAdd;
        int quantityAfterAdd;
        if (!app.event().isNavPanelPresent()) {
            app.user().defaultLogin();
        }

        quantityBeforeAdd = app.event().getTotalEvents();
        app.event().tapOnPlusButton();
        app.event().tapOnPencilButton();
        Thread.sleep(10000);
        app.event().swipeDayToLeft();
        app.event().fillEventForm("Party", "1", 1, "50");
        app.event().saveEvent();
        quantityAfterAdd = app.event().getTotalEvents();
        Assert.assertEquals(quantityAfterAdd,quantityBeforeAdd+1);

    }

    // "//android.widget.TextView[contains(@text,'text')]"

    @Test
    public void eventCreationOfUnregisteredUserTest() throws InterruptedException {
        // preconditions for wizard
        if (!app.event().isNavPanelPresent()) {
            app.user().register();
            app.wage().chooseWage("30");
        }

        app.event().tapOnPlusButton();
        app.event().tapOnPencilButton();
        Thread.sleep(1000);
        app.event().fillEventForm1("Event", "1", 3);
        app.event().saveEvent();

    }

    @Test
    public void eventCreationChangeDateTestOfRegisteredUserTest() throws InterruptedException {
        if (!app.event().isNavPanelPresent()) {
            app.user().defaultLogin();
        }
        app.event().tapOnPlusButton();
        app.event().tapOnPencilButton();
        app.event().selectDate("past", "JUNE", "29");

        app.event().fillEventForm("Event", "1", 1, "50");
        app.event().saveEvent();
    }


}