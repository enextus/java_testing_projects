package com.telran.oscar.tests;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.RegisterPage;
import com.telran.oscar.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).clickOnLoginOrRegisterBtn();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "registerNegativeEmailUsingFile", priority = 2)
    public void newUserRegistrationNegativeTest(String email) {
        new RegisterPage(driver).fillRegisterForm(email, "Draft1234!", "Draft1234!");
        Assert.assertTrue(new RegisterPage(driver).isRegisterFormDisplayed());
    }

    @Test(priority = 1, groups = {"functional"})
    public void newUserRegistrationPositiveTest() {
        new RegisterPage(driver).fillRegisterForm("dra4@gm.cm", "Draft1234!", "Draft1234!");

    }

}
