package com.telran.qa14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstSeleniumTest {

    WebDriver driver;

    //before - setUp(){}
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver", "Path...../chromedriver")
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

/*    //Test
    @Test
    public void openSite() {
        System.out.println("site opened!");
    }*/

    //Test
    @Test
    public void searchProductTest() {
        driver.findElement(By.name("search_query"))
                .sendKeys("summer dresses" + Keys.ENTER);

        String text = driver.findElement(By.className("lighter"))
                .getText();

        Assert.assertEquals(text, "\"SUMMER DRESSES\"");

    }

    //after - tearDown()
    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }


}
