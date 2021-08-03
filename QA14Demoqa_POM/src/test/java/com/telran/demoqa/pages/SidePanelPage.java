package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelPage extends PageBase{
    public SidePanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    // @FindBy(xpath = "//span[contains(text(),'Browser Windows')]")
    WebElement browserWindowsBtn;

    public BrowserWindowsPage selectBrowserWindows() {
        clickWithAction(browserWindowsBtn, 0, 300);

        return new BrowserWindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alertsBtn;

    public AlertsPage selectAlerts() {
        clickWithAction(alertsBtn, 0, 300);

        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    // @FindBy(xpath = "//span[contains(text(),'Select Menu')]")
    WebElement selectMenuBtn;

    public SelectMenuPage selectSelectMenuBtn() {
        clickWithAction(selectMenuBtn, 0, 700);

        return new SelectMenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceFormBtn;

    public PracticeFormPage selectPracticeForm() {
        clickWithAction(practiceFormBtn, 0, 500);

        return new PracticeFormPage(driver);
    }

    @FindBy(xpath = "//span[.='Date Picker']")
    WebElement datePickerBtn;

    public DatePickerPage selectDatePicker() {
        clickWithAction(datePickerBtn, 0, 300);

        return new DatePickerPage(driver);
    }

    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppableBtn;

    public DragAndDropPage selectDroppable() {
        clickWithAction(droppableBtn, 0, 300);

        return new DragAndDropPage(driver);
    }

    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBoxBtn;

    public ElementsPage selectTextBox() {
        textBoxBtn.click();
        return new ElementsPage(driver);
    }


}