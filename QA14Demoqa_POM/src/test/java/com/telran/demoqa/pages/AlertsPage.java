package com.telran.demoqa.pages;

import com.google.common.base.Strings;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends PageBase {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "timerAlertButton")
    WebElement alertBtn2;

    public void clickAlertButton2AndWait() {
        alertBtn2.click();
        WebDriverWait wait = new WebDriverWait(driver, 18);
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        String gt = myAlert.getText();
        System.out.println("Message: " + gt);

        myAlert.accept();
    }

    @FindBy(id = "confirmButton")
    WebElement alertBtn3;

    public AlertsPage clickAlertButton3() {
        alertBtn3.click();

        WebDriverWait wait = new WebDriverWait(driver, 1);
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        String gt = myAlert.getText();
        System.out.println("Message: " + gt);

        return this;
    }

    public void clickOnCancelButton(String text) {
        if (!Strings.isNullOrEmpty(text)) {
            if (text.equals("Cancel")) {
                driver.switchTo().alert().dismiss();
            } else driver.switchTo().alert().accept();
        } else {
            throw new java.lang.RuntimeException("Something bad happened. The text value is empty or null!");
        }
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

    public void sendTextToAlert(String text) {
        if (!Strings.isNullOrEmpty(text)) {
            driver.switchTo().alert().sendKeys(text);
            System.out.println("Message: " + driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
        } else {
            throw new java.lang.RuntimeException("Something bad happened. The text value is empty or null!");
        }
    }

    @FindBy(xpath = "//span[@id='promptResult']")
    WebElement confirmSendText;

    public String getConfirmLastResult() {
        return confirmSendText.getText();
    }

}
