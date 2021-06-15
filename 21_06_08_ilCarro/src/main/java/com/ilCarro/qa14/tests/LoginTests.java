package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.fw.TestBase;
import com.ilCarro.qa14.models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getUser().isSignUpButtonPresent()) {
            app.getUser().logout();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        app.getUser().clickOnLoginTab();
        app.getUser().fillLoginForm(new User().withEmail("hummels@gmail.com")
                .withPassword("Hummels098765"));
        app.getUser().submit();
        app.getHeader().isLogoutTabPresent();
    }

    @Test
    public void loginRegisteredUserWithWrongPasswordNegativeTest() {
        app.getUser().clickOnLoginTab();
        app.getUser().fillLoginForm(new User().withEmail("hummels@gmail.com")
                .withPassword("hummels098765"));
        app.getUser().submit();
    }

}
