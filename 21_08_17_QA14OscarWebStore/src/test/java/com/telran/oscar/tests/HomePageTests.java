package com.telran.oscar.tests;

import com.telran.oscar.pages.TestBase;
import org.testng.annotations.BeforeMethod;

public class HomePageTests extends TestBase {

    HomePage homePage;
    ProductPage productPage;

    @BeforeMethod
    public void pageInit() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        productPage = PageFactory.initElements(driver, ProductPage.class);
    }

    @Test
    public void user

}
