package com.telran.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage extends PageBase {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "userNumber")
    WebElement mobilNumber;

    public PracticeFormPage fillPersonalData(String fName, String lName, String email, String number) {
        type(firstName, fName);
        type(lastName, lName);
        type(userEmail, email);
        type(mobilNumber, number);

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

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage typeOfDay(String bDay) {
        clickWithAction(dateOfBirthInput, 0, 200);
        String os = System.getProperty("os.name");
        System.out.println(os);

        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            dateOfBirthInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }

        dateOfBirthInput.sendKeys(bDay);

        dateOfBirthInput.sendKeys(Keys.ENTER);

        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectInput;

    @FindBy(id = "react-select-2-option-0")
    WebElement selectInput;

    public PracticeFormPage addSubject(String subject) {
        type(subjectInput, subject);
        selectInput.click();

        return this;
    }

    public PracticeFormPage addSubjectWithEnter(String subject) {
        type(subjectInput, subject);
        subjectInput.sendKeys(Keys.ENTER);

        return this;
    }

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sport;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement reading;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement music;

    public PracticeFormPage chooseHobby(String hobby) {
        if (hobby.equals("Sports")) {
            sport.click();
        } else if (hobby.equals("Reading")) {
            reading.click();
        } else if (hobby.equals("Music")) {
            music.click();
        }

        return this;
    }

    @FindBy(xpath = "//input[@id='uploadPicture']")
    WebElement chooseFile;

    public PracticeFormPage uploadFile(String path) {
        chooseFile.sendKeys(path);
        pause(2000);

        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement address;

    public PracticeFormPage typeAddress(String text) {
        typeWithAction(address, 0, 300, text);

        return this;
    }

    @FindBy(id = "state")
    WebElement state;
    @FindBy(id = "react-select-3-input")
    WebElement stateBlock;

    public PracticeFormPage inputState(String st) {
        state.click();
        stateBlock.sendKeys(st);
        stateBlock.sendKeys(Keys.ENTER);

        return this;
    }

    @FindBy(id = "city")
    WebElement city;
    @FindBy(id = "react-select-4-input")
    WebElement cityBlock;

    public PracticeFormPage inputCity(String c) {
        city.click();
        cityBlock.sendKeys(c);
        cityBlock.sendKeys(Keys.ENTER);

        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public PracticeFormPage submit() {
        submit.click();

        return this;
    }

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement modalTitle;

    public String getTitleFromDialog() {

        return modalTitle.getText();
    }

    @FindBy(id = "closeLargeModal")
    WebElement closeBtn;

    public PracticeFormPage closeSuccessDialog() {
        closeBanner();
        closeBtn.click();

        return this;
    }

}
