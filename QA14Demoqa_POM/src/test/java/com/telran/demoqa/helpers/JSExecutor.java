package com.telran.demoqa.helpers;

import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSExecutor extends PageBase {

    JavascriptExecutor js;

    public JSExecutor(WebDriver driver) {
        super(driver);
        js =;
    }

    public JSExecutor typeDataWithExecutor(String name, String email) {

    }
}
