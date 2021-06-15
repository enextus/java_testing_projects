package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.fw.TestBase;
import com.ilCarro.qa14.models.Car;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCarTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getUser().isUserLoggedIn()){
            app.getUser().logIn();
        }
    }

    @Test
    public void addCarTest() throws InterruptedException {
        app.getUser().pause();
        app.getCar().clickOnAddCarTab();
        app.getCar().fillCarForm(new Car()
                .setCountry("Germany")
                .setAddress("Friedrichstrasse")
                .setDistance("1000")
                .setVin("464 32 902")
                .setBrand("Volvo")
                .setModel("740")
        );
    }

}
