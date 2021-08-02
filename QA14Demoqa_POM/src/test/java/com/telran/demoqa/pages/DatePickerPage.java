package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DatePickerPage extends PageBase {
    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='datePickerMonthYearInput']")
    WebElement datePickerInput;

    @FindBy(css = ".react-datepicker__month-select")
    WebElement selectMonth;

    @FindBy(css = ".react-datepicker__year-select")
    WebElement selectYear;

    @FindBy(xpath = "//*[@class='react-datepicker__week']/div[@aria-label='Choose Wednesday, September 8th, 2021']")
    WebElement select8September;

    @FindBy(css = ".react-datepicker__day")
    List<WebElement> selectDay;

    public DatePickerPage selectDateToInput(String month, String year, String day) {
        datePickerInput.click();
        new Select(selectMonth).selectByVisibleText(month);
        new Select(selectYear).selectByVisibleText(year);

        // selectDay.get(getIndexElementWithDate(month,day)).click();
        setDay(month, day);

        return this;
    }

    public int getIndexElementWithDate(String month, String day) {
        for (WebElement element : selectDay) {
            String[] days = element.getAttribute("aria-label").split(",");
            System.out.println(days[1]);
            if (days[1].contains(month) && days[1].contains(day)) {
                return selectDay.indexOf(element);
            }
        }
        return -1;
    }

    public String getDate() {
        System.out.println("Date :" + datePickerInput.getAttribute("value"));
        return datePickerInput.getAttribute("value");
    }

    private void setDay(String month, String day) {
        if (getIndexElementWithDate(month, day) >= 0) {
            selectDay.get(getIndexElementWithDate(month, day)).click();
        } else {
            System.out.println("DatePickerPage.selectDateToInput: can't found a day : " + month + " , " + day);
        }
    }

}
