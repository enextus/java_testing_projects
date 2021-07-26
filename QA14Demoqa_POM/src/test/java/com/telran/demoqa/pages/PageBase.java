package com.telran.demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }

    }

    public void clickWithAction(WebElement element, int x, int y) {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).moveByOffset(x, y).click().build().perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.")




    }

}
