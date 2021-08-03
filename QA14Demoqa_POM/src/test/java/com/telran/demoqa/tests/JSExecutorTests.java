package com.telran.demoqa.tests;

import org.testng.annotations.Test;

public class JSExecutorTests extends TestBase {

    @Test
    public void executorTest() {
        new HomePage(driver).goToElementsPage();
        new SidePanelPage(driver).selectTextBox();
        new JSExecutor(driver).typeDataWithExecutor("aaaa", "aaaa@gmail.com");
    }
}
