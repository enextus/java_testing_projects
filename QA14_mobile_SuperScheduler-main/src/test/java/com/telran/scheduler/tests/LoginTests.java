package com.telran.scheduler.tests;

import com.telran.scheduler.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class LoginTests extends TestBase {

    @Test
    public void registrationPositiveTest() {
        Random ran = new Random();
        int ln = ran.nextInt(6) + 5;

        app.user().login(new User().setEmail("neuer+" + ln + "@gmail.com").setPassword("Neuer2021"));
        Assert.assertTrue(app.event().isWizardTitlePresent());
    }

    @Test
    public void loginPositiveTest() {
        app.user().login(new User().setEmail("neuer@gmail.com").setPassword("Neuer2021"));
        Assert.assertTrue(app.event().isNavPanelPresent());
    }
// wizard_settings_title
    // login_btn
}
