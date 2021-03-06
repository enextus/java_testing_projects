package com.telran.demoqa.tests.bookstoretests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.bookstore.BookStorePage;
import com.telran.demoqa.pages.bookstore.LoginPage;
import com.telran.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).goToBookStore();
        new BookStorePage(driver).goToLoginPage();
    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(driver).login("aaaa", "Ku7854_Ku7854$$")
                .verifyUserName("neuer").logout();
    }

}
