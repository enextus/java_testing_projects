package com.telran.demoqa.tests;

import com.telran.demoqa.helpers.MyListener;
import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected EventFiringWebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void setUp() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new MyListener());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/login");
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

}
