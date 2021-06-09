package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ApplicationManager extends CarHelper{

    WebDriver wd;

    protected void init() {
        //System.setProperty("webdriver.chrome.driver","path/chromedriver.exe");
        wd = new ChromeDriver();
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected void stop() {
        wd.quit();
    }

    public void isLogoutTabPresent() {
        Assert.assertTrue(isElementPresent(By.xpath("//a[contains(.,'logOut')]")));
    }

    public void jumpToFooter() {
        wd.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    }

    public boolean isFindCarFormPresent() {
        return isElementPresent1(By
                .cssSelector(".Main_mainpage__find_your_car__AHLkw"));
    }

    public void clickOnAddCarTab() {
        click(By.xpath("//ul[@class='header__nav desktop']/li[2]"));
    }

    public void fillCarForm(Car car) {
        type(By.cssSelector(".country"), car.getCountry());
        type(By.cssSelector(".address"), car.getAddress());
        type(By.cssSelector(".distance_included"), car.getDistance());
    }

    public void clickOnSignUpTab() {
        click(By.cssSelector("[href='/signup']"));
    }

    public void checkSearchPageLaunch() {
        click(By.xpath("//ul[@class='header__nav desktop']/li[1]"));
        Assert.assertTrue(isElementPresent1(By.cssSelector(".search-sidebar__content")));
    }

}
