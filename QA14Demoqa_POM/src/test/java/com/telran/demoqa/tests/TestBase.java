package com.telran.demoqa.tests;

import com.telran.demoqa.helpers.MyListener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected EventFiringWebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        options.addArguments("--no-sandbox");

        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");

        options.setBinary("/usr/bin/google-chrome-stable"); // path to our chrome binary

        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("window-size=1024,768"); // Bypass OS security model
        options.addArguments("--log-level=3"); // set log level
        options.addArguments("--silent");//
        options.setCapability("chrome.verbose", false); //disable logging

        // With options
        driver = new EventFiringWebDriver(new ChromeDriver(options));

        // Without options
        //driver = new EventFiringWebDriver(new ChromeDriver());

        driver.register(new MyListener());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/");
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

}
