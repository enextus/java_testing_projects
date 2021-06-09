package com.ilCarro.qa14;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!isSignUpButtonPresent()) {
            logout();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {

        clickOnLoginTab();

        fillLoginForm(new User().withEmail("hummels@gmail.com")
                .withPassword("Hummels098765"));

        submit();

        isLogoutTabPresent();

    }

    @Test
    public void loginRegisteredUserWithWrongPasswordNegativeTest() {

        clickOnLoginTab();

        fillLoginForm(new User().withEmail("hummels@gmail.com")
                .withPassword("hummels098765"));

        submit();

    }

}
