package com.telran.demoqa.tests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.PracticeFormPage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentRegistrationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).goToForms();
        new SidePanelPage(driver).selectPracticeForm();
    }

    @Test
    public void fillStudentRegFormTest() {
        new PracticeFormPage(driver)
                .fillPersonalData("Jack", "Sparrow", "jack@gmail.com", "1234567890")
                .selectGender("Male").typeOfDay("13 May 1835")
                .addSubjectWithEnter("Maths").addSubjectWithEnter("Commerce")
                .chooseHobby("Sports").chooseHobby("Music")
                .uploadFile("/home/enextus/Pictures/Screenshot from 2020-12-02 12-59-33.png")
                .typeAddress("Tortuga")
                .inputState("NCR")
                .inputCity("Delhi")
                .submit();
        Assert.assertTrue(new PracticeFormPage(driver).getTitleFromDialog()
                .contains("Thanks for submitting the form"));

        new PracticeFormPage(driver).closeSuccessDialog();
    }

}
