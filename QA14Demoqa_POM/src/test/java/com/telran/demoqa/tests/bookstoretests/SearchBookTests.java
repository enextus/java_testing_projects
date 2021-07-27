package com.telran.demoqa.tests.bookstoretests;

import com.telran.demoqa.pages.BookStorePage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBookTests  extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).goToBookStore();
    }

    @Test
    public void searchBookPositiveTest() {
        String text = "Git";
        new BookStorePage(driver).typeInSearchInputFieldInput(text).takeNameOfBook();
        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(text));

    }
}
