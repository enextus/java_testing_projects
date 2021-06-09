package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.framework.TestBase;
import com.ilCarro.qa14.models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isSignUpButtonPresent()) {
            app.getUser().logout();
        }
    }

    @Test
    public void signUpTest() {
        app.getHeader().clickOnSignUpTab();
        app.getUser().isSignUpFormPresent();
        app.getUser().fillRegistrationForm(new User()
                .withFirstName("Mats")
                .withSecondName("Hummels")
                .withEmail("hummels3@gmail.com")
                .withPassword("Hummels098765"));
        app.getUser().clickCheckPolicy();
        app.getUser().submit();
        app.getUser().isLogInFormPresent();
    }

}
