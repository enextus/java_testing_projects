package com.telran.sheduler.tests;

import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        List<AppiumDriver> ad = app.driver.findElementsById("com.example.svetlana.scheduler:id/splash_logo_img");

        System.out.println(ad.toString());
    }

    @Test
    public void testLaunchAppTwo() {
        List<AppiumDriver> ad = app.driver.findElementsById("com.example.svetlana.scheduler:id/");

        Assert.assertTrue(ad.isEmpty());
    }

}
