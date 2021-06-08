package com.ilCarro.qa14;

import com.ilCarro.qa14.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCarTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!isUserLoggedIn()){
            logIn();
        }
    }

    private void logIn() {
        click(By.xpath("//ul[@class='header__nav desktop']/li[5]"));
        type(By.cssSelector("[name='email']"),"hummels@gmail.com");
        type(By.name("password"),"Hummels098765");
        submit();
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath("//a[contains(.,'logOut')]"));
    }

    @Test
    public void addCarTest() throws InterruptedException {
        Thread.sleep(2000);
        click(By.xpath("//ul[@class='header__nav desktop']/li[2]"));

        type(By.cssSelector(".country"),"Germany");
        type(By.cssSelector(".address"),"Friedrichstrasse");
        type(By.cssSelector(".distance_included"),"1000");

    }

}