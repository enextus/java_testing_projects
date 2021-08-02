package com.telran.demoqa.pages.bookstore;

import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstname")
    WebElement firstName;

    @FindBy(id = "lastname")
    WebElement lastName;

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;


    public RegisterPage fillRegisterForm(String fName, String lName, String uName, String pwd) {
        type(firstName, fName);
        type(lastName, lName);
        type(userName, uName);
        typeWithAction(password, 0, 300, pwd);

        return this;
    }

    @FindBy(id = "g-recaptcha")
    WebElement captcha;

    public RegisterPage clickCaptcha() {
        captcha.click();

        return this;
    }

}
