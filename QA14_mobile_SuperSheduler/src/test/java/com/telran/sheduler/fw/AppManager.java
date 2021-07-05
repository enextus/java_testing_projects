package com.telran.sheduler.fw;

import com.telran.sheduler.fw.UserHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppManager {

    public AppiumDriver driver;
    DesiredCapabilities capabilities;

    UserHelper user;

    public UserHelper user() {
        return user;
    }

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("deviceName", "qa14_mob");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");
        capabilities.setCapability("app", "/home/enextus/Desktop/v.0.0.3.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);

        user = new UserHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

}
