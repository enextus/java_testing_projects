package com.telran.demoqa.tests.bookstoretests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.bookstore.BookStorePage;
import com.telran.demoqa.pages.bookstore.LoginPage;
import com.telran.demoqa.pages.bookstore.RegisterPage;
import com.telran.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).goToBookStore();
        new BookStorePage(driver).goToLoginPage();
        new LoginPage(driver).clickOnNewUserButton();
    }

    @Test
    public void registrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        String fName = "Mats" + i;
        String lName = "Hummels" + i;
        String uName = "hummels" + i;
        String pwd = "Mats$" + i;

        new RegisterPage(driver).fillRegisterForm(fName, lName, uName, pwd).clickCaptcha();
    }

}
