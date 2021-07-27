package com.telran.demoqa.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.Random;

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

    public void takeScreenshotField(WebElement element) throws IOException {
        element.isSelected();

        File screenshotEmptyField = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotEmptyField,
                new File(System.getProperty("user.dir") + "/screenshots" + new Random().nextInt() + ".png"));
    }

}
