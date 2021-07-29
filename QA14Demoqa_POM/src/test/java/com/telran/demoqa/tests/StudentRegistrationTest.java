package com.telran.demoqa.tests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.PracticeFormPage;
import com.telran.demoqa.pages.SidePanelPage;
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
        new PracticeFormPage(driver).fillPersonalData("Jack", "Sparrow", "jack@gmail.com", "1232142343234")
                .selectGender("Male").typeOfDay("13 May 1983").addSubject("FDdsafsdfsd df sd")
                .chooseHobby("Sports").chooseHobby("Reading").chooseHobby("Music")
                .uploadFile("/home/enextus/Desktop/fPQaV.png").typeAddress("Tortuga")
                .inputState("NCR").inputCity("Delhi").submit();
    }
}
