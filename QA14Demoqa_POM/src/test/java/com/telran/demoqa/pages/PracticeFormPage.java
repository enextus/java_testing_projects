package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage extends PageBase {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public PracticeFormPage fillPersonalData(String name, String lastName, String email, String number) {

        return this;
    }

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleBtn;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleBtn;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherBtn;


    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")) {
            maleBtn.click();
        } else if (gender.equals("Female")) {
            femaleBtn.click();
        } else {
            otherBtn.click();
        }

        return this;
    }

    
}
