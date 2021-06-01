package com.telran.qa14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSelenimTest {

    WebDriver driver;

    //before - setUp(){}
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver", "Path...../chromedriver")
        driver.get("https://www.google.com/");
    }

    //Test
    @Test
    public void openSite() {
        System.out.println("site opened!");
    }
}
