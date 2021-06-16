package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.user().isSignUpButtonPresent()) {
            app.user().logout();
        }
    }

    @Test
    public void signUpTest() {
        app.header().clickOnSignUpTab();
        app.user().isSignUpFormPresent();

        User user = new User()
                .withFirstName("Mats2")
                .withSecondName("Hummels2")
                .withEmail("hummels2" + System.currentTimeMillis() + "@gmail.com")
                .withPassword("Hummels0987652");

/*        app.user().fillRegistrationForm(new User()
                .withFirstName("Mats2")
                .withSecondName("Hummels2")
                .withEmail("hummels2" + System.currentTimeMillis() + "@gmail.com")
                .withPassword("Hummels0987652"));*/


        app.user().fillRegistrationForm(user);

        System.out.println("" + user);

        app.user().clickCheckPolicy();
        app.user().submit();
        app.user().isLogInFormPresent();

    }

    @Test(dataProvider = "validUser", dataProviderClass = DataProviders.class)
    public void signUpFromDataProviderTest(String fName, String sName, String email, String password) {
        app.header().clickOnSignUpTab();
        app.user().isSignUpFormPresent();

        app.user().fillRegistrationForm(new User()
                .withFirstName(fName)
                .withSecondName(sName)
                .withEmail(email)
                .withPassword(password));

        app.user().clickCheckPolicy();
        app.user().submit();
        logger.info("Login form present. Actual result: " + app.user().isLoginFormPresent()
                + ". Expected result: true.");
        app.user().isLogInFormPresent();


    }

    @Test(dataProvider = "validUserFromCSV", dataProviderClass = DataProviders.class)
    public void signUpFromDataProviderFromCSVTest(User user) {
        app.header().clickOnSignUpTab();
        app.user().isSignUpFormPresent();

        app.user().fillRegistrationForm(user);

        app.user().clickCheckPolicy();
        app.user().submit();
        logger.info("Login form present. Actual result: " + app.user().isLoginFormPresent()
                + ". Expected result: true.");
        app.user().isLogInFormPresent();
    }

}
