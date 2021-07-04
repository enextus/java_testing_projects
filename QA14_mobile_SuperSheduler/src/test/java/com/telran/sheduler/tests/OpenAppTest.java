package com.telran.sheduler.tests;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

public class OpenAppTest {

    AppiumDriver ad;

    DesiredCapabilities capabilities;

    @BeforeMethod
    public void setUp() {
        capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("deviceName", "qa14_mob");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");
        capabilities.setCapability("app", "/home/enextus/Desktop/v.0.0.3.apk");

    }

    /*{
  "platformName": "Android",
  "platformVersion": "8.0.0",
  "deviceName": "qa14_mob",
  "appPackage": "com.example.svetlana.scheduler",
  "appActivity": ".presentation.splashScreen.SplashScreenActivity"
}*/
}
