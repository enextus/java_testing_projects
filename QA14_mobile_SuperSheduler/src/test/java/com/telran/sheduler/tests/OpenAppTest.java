package com.telran.sheduler.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenAppTest {

    AppiumDriver driver;
    DesiredCapabilities capabilities;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("deviceName", "qa14_mob");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");
        capabilities.setCapability("app", "/home/enextus/Desktop/v.0.0.3.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);
    }

    /*{
    "platformName": "Android",
    "platformVersion": "8.0.0",
    "deviceName": "qa14_mob",
    "appPackage": "com.example.svetlana.scheduler",
    "appActivity": ".presentation.splashScreen.SplashScreenActivity"
    }*/

    @Test
    public void testLaunchApp() {

        driver.findElementsById("com.example.svetlana.scheduler:id/splash_logo_img");

        // Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));
    }

}
