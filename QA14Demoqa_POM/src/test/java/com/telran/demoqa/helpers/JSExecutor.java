package com.telran.demoqa.helpers;

import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExecutor extends PageBase {

    JavascriptExecutor js;

    public JSExecutor(WebDriver driver) {
        super(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
    }

    public JSExecutor typeDataWithExecutor(String name, String email) {
        js.executeScript("document.getElementById('userName').value='" + name + "';");
        js.executeScript("document.getElementById('userName').style.border='1px dotted red ';");

        js.executeScript("document.getElementById('userEmail').value='" + email + "';");

        WebElement el = driver.findElement(By.id("userName"));
        System.out.println(el.getText() + "By text");
        System.out.println(el.getAttribute("value") + "By value");

        return this;
    }

    public JSExecutor clickOnSubmitJSE() {
        js.executeScript("document.querySelector('#submit').style.display.backgroundColor='red';");
        js.executeScript("document.querySelector('footer').style.display='none';");
        pause(500);

        js.executeScript("document.getElementById('submit').click();");

        return this;
    }

    public JSExecutor checkBoxJSE() {
        // to handle checkbox
        js.executeScript("document.getElementById('hobbies-checkbox-1').checked=false;");
        js.executeScript("document.getElementById('hobbies-checkbox-1').checked=true;");

        return this;
    }

    public JSExecutor alertWithJSE() {
        // to generate alert
        js.executeScript("alert('Handled checkbox');");
        return this;
    }

    public JSExecutor refreshBrowserJSE() {
        // to refresh of the Page
        js.executeScript("history.go(0);");
        return this;
    }

    public JSExecutor getTitlePageJSE() {
        // to get Title of our webpage
        String text = js.executeScript("return documnet.title;").toString();
        System.out.println("******************" + "\n" + text);

        return this;
    }

    public JSExecutor getURLPageJSE() {
        // to get URL
        String url = js.executeScript("return document.URL").toString();
        System.out.println("URL -> " + url);

        return this;
    }

    public JSExecutor scrollWithJSE() {
        // to perform Scroll
        // vertical scroll down by 50px
        js.executeScript("window.scrollBy(0,50);");


        return this;
    }
}
