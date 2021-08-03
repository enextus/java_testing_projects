package com.telran.demoqa.tests;

import com.telran.demoqa.helpers.JSExecutor;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.annotations.Test;

public class JSExecutorTests extends TestBase {

    @Test
    public void executorTest() {
        new HomePage(driver).gotoElementsPage();
        new SidePanelPage(driver).selectTextBox();
        new JSExecutor(driver).typeDataWithExecutor("aaaa", "aaaa@gmail.com")
                .clickOnSubmitJSE();
    }

    @Test
    public void checkBoxWithJSTest() {
        new HomePage(driver).goToForms();
        new SidePanelPage(driver).selectPracticeForm();
        new JSExecutor(driver).checkBoxJSE().alertWithJSE();
        new

    }
}
