package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.framework.TestBase;
import com.ilCarro.qa14.models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.user.isSignUpButtonPresent()) {
            app.user.logout();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {

        app.user.clickOnLoginTab();

        app.user.fillLoginForm(new User().withEmail("hummels@gmail.com")
                .withPassword("Hummels098765"));

        app.user.submit();

        app.header.isLogoutTabPresent();

    }

    @Test
    public void loginRegisteredUserWithWrongPasswordNegativeTest() {

        app.user.clickOnLoginTab();

        app.user.fillLoginForm(new User().withEmail("hummels@gmail.com")
                .withPassword("hummels098765"));

        app.user.submit();
    }

}
