package com.ilCarro.qa14.tests;

import org.testng.annotations.Test;

public class OpenHomePageTest extends TestBase {

    @Test(enabled = false)
    public void homePageTest() {
        System.out.println("FindCarForm: " + app.car().isFindCarFormPresent());
    }

}