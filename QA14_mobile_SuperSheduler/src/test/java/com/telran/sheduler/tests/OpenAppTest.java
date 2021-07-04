package com.telran.sheduler.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class OpenAppTest extends TestBase {

    /*{
    "platformName": "Android",
    "platformVersion": "8.0.0",
    "deviceName": "qa14_mob",
    "appPackage": "com.example.svetlana.scheduler",
    "appActivity": ".presentation.splashScreen.SplashScreenActivity"
    }*/

    @Test
    public void testLaunchApp() {
        List<AppiumDriver> ad = driver.findElementsById("com.example.svetlana.scheduler:id/splash_logo_img");

        System.out.println(ad.toString());
        System.out.println("_____________________________");
        // Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));
    }

}
