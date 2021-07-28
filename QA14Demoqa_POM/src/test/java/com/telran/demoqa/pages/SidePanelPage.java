package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelPage extends PageBase{
    public SidePanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindowsBtn;

    public BrowserWindowsPage selectBrowserWindows() {
        clickWithAction(browserWindowsBtn,0,300);
        return new BrowserWindowsPage(driver);
    }
}