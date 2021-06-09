package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HeaderHelper extends HelperBase{
    public void isLogoutTabPresent() {
        Assert.assertTrue(isElementPresent(By.xpath("//a[contains(.,'logOut')]")));
    }

    public void clickOnSignUpTab() {
        click(By.cssSelector("[href='/signup']"));
    }

    public void checkSearchPageLaunch() {
        click(By.xpath("//ul[@class='header__nav desktop']/li[1]"));
        Assert.assertTrue(isElementPresent1(By.cssSelector(".search-sidebar__content")));
    }
}
