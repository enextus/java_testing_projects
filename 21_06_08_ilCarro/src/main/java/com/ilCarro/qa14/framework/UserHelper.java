package com.ilCarro.qa14.framework;

import com.ilCarro.qa14.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void logout() {
        click(By.xpath("//a[contains(.,'logOut')]"));
    }

    public void clickOnLoginTab() {
        click(By.xpath("//ul[@class='header__nav desktop']/li[5]"));
    }

    public boolean isSignUpButtonPresent() {
        return isElementPresent(By.cssSelector("[href='/signup']"));
    }

    public void isSignUpFormPresent() {
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));
    }

    public void submit() {
        click(By.cssSelector("[type='submit']"));
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("[name='email']"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void logIn() {
        clickOnLoginTab();
        type(By.cssSelector("[name='email']"),"hummels@gmail.com");
        type(By.name("password"),"Hummels098765");
        submit();
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath("//a[contains(.,'logOut')]"));
    }

    public void isLogInFormPresent() {
        Assert.assertTrue(isElementPresentTwo(By.cssSelector(".Login_login__right_block__1niYm")));
        // #root > div > div:nth-child(2) > div > div.Login_login__right_block__1niYm
        // //*[@id="root"]/div/div[1]/div/div[2]
    }

    public void clickCheckPolicy() {
        click(By.cssSelector("#check_policy"));
    }

    public void fillRegistrationForm(User user) {
        type(By.cssSelector("#first_name"), user.getFirstName());
        type(By.cssSelector("#second_name"), user.getSecondName());
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }
}
