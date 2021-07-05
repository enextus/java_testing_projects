package com.telran.sheduler.fw;

import com.telran.sheduler.models.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class UserHelper extends HelperBase {

    public UserHelper(AppiumDriver driver) {
        super(driver);
    }

    public void login(User user) {
        type(By.id(""), user.getEmail());
        type(By.id(""), user.getPassword());
    }
}
