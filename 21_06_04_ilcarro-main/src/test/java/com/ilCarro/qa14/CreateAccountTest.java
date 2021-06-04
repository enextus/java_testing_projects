package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    //preconditions: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("[href='/signup']"))) {
            driver.findElement(By.xpath("//a[contains(.,'logOut')]")).click();
        }
    }

    @Test
    public void signUpTest() {
        driver.findElement(By.cssSelector("[href='/signup']")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));

        String name = "#first_name";
        clickClear(name);
        driver.findElement(By.cssSelector(name)).sendKeys("Re");

        name = "#second_name";
        clickClear(name);
        driver.findElement(By.cssSelector(name)).sendKeys("Re");

        name = "#email";
        clickClear(name);
        driver.findElement(By.cssSelector(name)).sendKeys("Re@co.co");

        name = "#email";
        clickClear(name);

        name = "#password";
        clickClear(name);
        driver.findElement(By.cssSelector(name)).sendKeys("87Re012394");

        driver.findElement(By.cssSelector("#check_policy")).click();

    }

    public void clickClear(String name) {
        driver.findElement(By.cssSelector(name)).click();
        driver.findElement(By.cssSelector(name)).clear();
    }
    //click on SignUp Button
    //fill registration form
    //click Submit button
    //check login form displayed
}
