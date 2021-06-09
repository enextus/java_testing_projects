package com.ilCarro.qa14;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.isSignUpButtonPresent()) {
            app.logout();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {

        app.clickOnLoginTab();

        app.fillLoginForm(new User().withEmail("hummels@gmail.com")
                .withPassword("Hummels098765"));

        app.submit();

        app.isLogoutTabPresent();

    }

    @Test
    public void loginRegisteredUserWithWrongPasswordNegativeTest() {

        app.clickOnLoginTab();

        app.fillLoginForm(new User().withEmail("hummels@gmail.com")
                .withPassword("hummels098765"));

        app.submit();

    }

}
