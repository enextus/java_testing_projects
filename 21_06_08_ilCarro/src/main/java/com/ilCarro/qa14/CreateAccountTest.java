package com.ilCarro.qa14;

import com.ilCarro.qa14.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    //preconditions: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isSignUpFormPresent()) {
            logout();
        }
    }

    @Test
    public void signUpTest() {
        click(By.cssSelector("[href='/signup']"));
        isLoginFormPresent();

        fillRegistrationForm(new User()
                .withFirstName("Mats")
                .withSecondName("Hummels")
                .withEmail("hummels2@gmail.com")
                .withPassword("Hummels098765"));

        click(By.cssSelector("#check_policy"));
        submit();
        Assert.assertTrue(isElementPresent(By.cssSelector(".Login_login__right_block__1niYm")));

    }

    public void fillRegistrationForm(User user) {
        type(By.cssSelector("#first_name"), user.getFirstName());
        type(By.cssSelector("#second_name"), user.getSecondName());
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }

}
