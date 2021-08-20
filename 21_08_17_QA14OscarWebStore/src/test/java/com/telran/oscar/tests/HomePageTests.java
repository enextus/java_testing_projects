package com.telran.oscar.tests;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.ProductPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    HomePage homePage;
    ProductPage productPage;

    @BeforeMethod
    public void pageInit() {

        System.out.println("_____________**********_____________");
        System.out.println(HomePage.class.getFields());
        System.out.println("_____________**********_____________");

        homePage = PageFactory.initElements(driver, HomePage.class);
        productPage = PageFactory.initElements(driver, ProductPage.class);
    }

    @Test
    public void userCanSelectProductMenuTest() {
        homePage.selectCategory();
        Assert.assertTrue(productPage.isItProductPage());
    }

}
