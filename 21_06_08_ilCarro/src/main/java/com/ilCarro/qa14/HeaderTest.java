package com.ilCarro.qa14;

import com.ilCarro.qa14.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase {

    @Test
    public void findTermsOfUseTabTest() {
        click(By.xpath("//ul[@class='header__nav desktop']/li[3]"));
        Assert.assertTrue(isElementPresent1(By.xpath("//div[contains(.,'Terms')]")));
    }

    @Test
    public void findSearchTest() {
        click(By.xpath("//ul[@class='header__nav desktop']/li[1]"));
        Assert.assertTrue(isElementPresent1(By.cssSelector(".search-sidebar__content")));
    }

}
