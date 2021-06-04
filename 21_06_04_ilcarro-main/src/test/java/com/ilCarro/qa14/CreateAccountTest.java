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
    public void clickClear() {
        driver.findElement(By.cssSelector("#first_name")).click();
        driver.findElement(By.cssSelector("#first_name")).clear();
    }

    public void signUpTest() {
        driver.findElement(By.cssSelector("[href='/signup']")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));
        clickClear();
        driver.findElement(By.cssSelector("#first_name")).sendKeys("Re");
        driver.findElement(By.cssSelector("#second_name")).click();
        driver.findElement(By.cssSelector("#second_name")).clear();
        driver.findElement(By.cssSelector("#second_name")).sendKeys("Re");
        driver.findElement(By.cssSelector("#email")).click();
        driver.findElement(By.cssSelector("#email")).clear();
        driver.findElement(By.cssSelector("#email")).sendKeys("Re@co.co");
        driver.findElement(By.cssSelector("#password")).click();
        driver.findElement(By.cssSelector("#password")).clear();
        driver.findElement(By.cssSelector("#password")).sendKeys("87Re012394");
        driver.findElement(By.cssSelector("#check_policy")).click();

    }
    //click on SignUp Button
    //fill registration form
    //click Submit button
    //check login form displayed
}
