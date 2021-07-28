package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BrowserWindowsPage extends PageBase {
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    WebElement newTabBtn;


    public BrowserWindowsPage clickOnNewTabBtn() {
        newTabBtn.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleText;

    public String getTextFromNewTab() {
        return sampleText.getText();
    }

    @FindBy(id = "windowButton")
    WebElement newWindowsBtn;

    public BrowserWindowsPage clickOnNewWindowsBtn() {
        newWindowsBtn.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

}
