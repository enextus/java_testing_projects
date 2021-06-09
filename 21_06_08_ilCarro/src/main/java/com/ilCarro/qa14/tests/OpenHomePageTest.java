package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.framework.TestBase;
import org.testng.annotations.Test;

public class OpenHomePageTest extends TestBase {

    @Test
    public void homePageTest() {
        System.out.println("FindCarForm: " + app.car.isFindCarFormPresent());
    }

}
