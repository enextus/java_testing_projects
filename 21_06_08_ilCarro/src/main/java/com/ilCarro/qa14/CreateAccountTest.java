package com.ilCarro.qa14;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.isSignUpButtonPresent()) {
            app.logout();
        }
    }

    @Test
    public void signUpTest() {
        app.clickOnSignUpTab();
        app.isSignUpFormPresent();

        app.fillRegistrationForm(new User()
                .withFirstName("Mats")
                .withSecondName("Hummels")
                .withEmail("hummels3@gmail.com")
                .withPassword("Hummels098765"));

        app.clickCheckPolicy();
        app.submit();
        app.isLogInFormPresent();

    }

}