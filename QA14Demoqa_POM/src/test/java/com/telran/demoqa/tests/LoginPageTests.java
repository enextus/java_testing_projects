package com.telran.demoqa.tests;

import com.telran.demoqa.pages.BookStorePage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).goToBookStore();
        new BookStorePage(driver).goToLoginPage();
    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(driver).login("neuer","Neuer1234!")
                .verifyUserName("neuer").logout();
    }
}
