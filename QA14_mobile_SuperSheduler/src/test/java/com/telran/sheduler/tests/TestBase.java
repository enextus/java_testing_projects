package com.telran.sheduler.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AppManager{

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        init();
    }

    @AfterMethod
    public void tearDown() {
        stop();
    }

}
