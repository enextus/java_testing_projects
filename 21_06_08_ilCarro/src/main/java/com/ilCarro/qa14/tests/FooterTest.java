package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.fw.TestBase;
import org.testng.annotations.Test;

public class FooterTest extends TestBase {

    @Test
    public void jumpToFooterTest() {
        app.getFooter().jumpToFooter();
    }

}
