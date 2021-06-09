package com.ilCarro.qa14;

import org.testng.annotations.Test;

public class OpenHomePageTest extends TestBase {

    @Test
    public void homePageTest() {
        System.out.println("FindCarForm: " + isFindCarFormPresent());
    }

}
