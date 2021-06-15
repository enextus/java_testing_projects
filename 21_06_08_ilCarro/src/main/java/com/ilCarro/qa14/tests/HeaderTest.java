package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.fw.TestBase;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase {

    @Test
    public void findSearchTest() {
        app.getHeader().checkSearchPageLaunch();
    }

}
