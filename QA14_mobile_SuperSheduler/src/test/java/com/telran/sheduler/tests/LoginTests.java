package com.telran.sheduler.tests;

import com.telran.sheduler.models.User;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        app.user().login(new User());
    }

}
