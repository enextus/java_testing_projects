package com.telran.qa14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class FirstSelenimTest {

    WebDriver driver;

    // befor - setUp(){}
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        // System.setProperty("webdriver.chrome.driver", "Path...../chromedriver")
    }
}
