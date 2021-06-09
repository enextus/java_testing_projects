package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.framework.TestBase;
import com.ilCarro.qa14.models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.user.isSignUpButtonPresent()) {
            app.user.logout();
        }
    }

    @Test
    public void signUpTest() {
        app.header.clickOnSignUpTab();
        app.user.isSignUpFormPresent();

        app.user.fillRegistrationForm(new User()
                .withFirstName("Mats")
                .withSecondName("Hummels")
                .withEmail("hummels3@gmail.com")
                .withPassword("Hummels098765"));

        app.user.clickCheckPolicy();
        app.user.submit();
        app.user.isLogInFormPresent();

    }

}