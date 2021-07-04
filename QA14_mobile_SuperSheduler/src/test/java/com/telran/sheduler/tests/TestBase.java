package com.telran.sheduler.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class TestBase extends AppManager{

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        init();
    }

    @AfterMethod
    public void tearDown() {
        stop();
    }

}
