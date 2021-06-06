package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OpenHomePageTest extends TestBase{

    @Test
    public void homePageTest() {
        System.out.println("FindCarForm: "
                           + isElementPresent(By.cssSelector(".Main_mainpage__find_your_car__AHLkw")));
    }

}
