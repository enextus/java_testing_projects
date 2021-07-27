package com.telran.demoqa.tests.bookstoretests;

import com.telran.demoqa.pages.BookStorePage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.LoginPage;
import com.telran.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBookToCollection extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).goToBookStore();
        new BookStorePage(driver).goToLoginPage();
        new LoginPage(driver).login("aaaa", "Ku7854_Ku7854$$");

    }

    @Test
    public void addBookToCollectionTest() {
        String text = "Git";

        new BookStorePage(driver).typeInSearchInputFieldInput(text).clickByFirstBook()
                    .addBookToCollection().clickOnProfileButton();


    }
}
