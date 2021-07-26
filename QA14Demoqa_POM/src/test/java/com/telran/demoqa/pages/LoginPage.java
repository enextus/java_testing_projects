package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="userName")
    WebElement userName;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="login")
    WebElement login;

//    @FindBys(id="userName", )
//    WebElement login;

}
