package com.telran.demoqa.tests.bookstoretests;

import com.telran.demoqa.pages.BookStorePage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchBookTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).goToBookStore();
    }

    @Test
    public void searchBookPositiveTest() throws IOException {
        String text = "Git";
        new BookStorePage(driver).typeInSearchFieldInput(text).takeNameOfBook();
        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(text));

        new BookStorePage(driver).takeScreenshotField(driver
                .findElement(By.xpath("//span[@class='mr-2']/a")));
    }

    @Test
    public void verifyEmptyFieldtest() {
        new BookStorePage(driver).typeInSearchFieldInput("  ").verifyEmptyField();
        Assert.assertTrue(new BookStorePage(driver).verifyEmptyField().contains(""));
    }

}
