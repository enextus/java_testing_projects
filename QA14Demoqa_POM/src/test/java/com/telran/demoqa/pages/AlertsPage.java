package com.telran.demoqa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collection;

public class AlertsPage extends PageBase {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "timerAlertButton")
    WebElement alertBtn2;

    public AlertsPage clickAlertButton2AndWait() {
        alertBtn2.click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        myAlert.accept();

        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement alertBtn3;

    public AlertsPage clickAlertButton3() {
        alertBtn3.click();

        return this;
    }

    public AlertsPage clickOnCancelButton(String text) {
        if (text != null && text.equals("Cancel")){
            driver.switchTo().alert().dismiss();
        }else if (text != null && text.equals("Ok")){
            driver.switchTo().alert().accept();
        }

        return this;
    }

    @FindBy(id = "confirmResult")
    WebElement confirmText;

    public String getConfirmResult() {

        return confirmText.getText();
    }

    @FindBy(id = "promtButton")
    WebElement alertBtn4;

    public AlertsPage clickAlertButton4() {
        alertBtn4.click();

        return this;
    }

    public AlertsPage sendTextToAlert(String text) {
        if (text != null)
            driver.switchTo().alert().sendKeys(text);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        return this;
    }

    @FindBy(xpath = "//span[@id='promptResult']")
    WebElement confirmSendText;

    public String getConfirmLastResult() {

        return confirmSendText.getText();
    }

}
