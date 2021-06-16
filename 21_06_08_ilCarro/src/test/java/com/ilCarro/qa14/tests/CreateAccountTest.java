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

    @DataProvider
    public Iterator<Object[]> validUser() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"fName", "sName", "fName+1@gm.co", "Fnnnnn123456"});
        list.add(new Object[]{"fName", "sName", "fNames+1@gm.co", "Fnnnnn123456"});
        list.add(new Object[]{"fName", "sName", "fNamess+1@gm.co", "Fnnnnn123456"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validUserFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/tests_NewUser.csv")));
        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User().withFirstName(split[0]).withSecondName(split[1])
                    .withEmail(split[2]).withPassword(split[3])});
            line = reader.readLine();
        }
        return list.iterator();
    }

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

        app.user().fillRegistrationForm(new User()
                .withFirstName("Mats")
                .withSecondName("Hummels")
                .withEmail("hummels" + System.currentTimeMillis() + "@gmail.com")
                .withPassword("Hummels098765"));

        app.user().clickCheckPolicy();
        app.user().submit();
        app.user().isLogInFormPresent();

    }

    @Test(dataProvider = "validUser")
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

    @Test(dataProvider = "validUserFromCSV")
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