package com.telran.scheduler.fw;

import com.telran.scheduler.models.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class UserHelper extends HelperBase{

    public UserHelper(AppiumDriver driver) {
        super(driver);
    }

    public void login(User user) {
        type(By.id("log_email_input"), user.getEmail());
        type(By.id("log_password_input"), user.getPassword());
        hideKeyboard();
        tap(By.id("login_btn"));
    }

    public void fillLoginForm(User user) {
        waitForElementAndType(By.id("log_email_input"), 5,user.getEmail());
        type(By.id("log_password_input"), user.getPassword());
    }


    public void defaultLogin() {
        login(new User().setEmail("neuer@gmail.com").setPassword("Neuer2021"));
    }


    public void register() {
        Random random = new Random();
        int r = random.nextInt(1000);
        login(new User().setEmail("cd" + r + "@gmail.com").setPassword("Cdefj2021"));
    }
}