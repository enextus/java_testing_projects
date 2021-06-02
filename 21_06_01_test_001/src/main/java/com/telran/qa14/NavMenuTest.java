package com.telran.qa14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class NavMenuTest {

    WebDriver driver;

    //before - setUp(){}
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();

        driver.navigate().to("http://automationpractice.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
}
