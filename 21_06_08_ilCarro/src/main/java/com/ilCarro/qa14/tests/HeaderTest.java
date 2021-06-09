package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.framework.TestBase;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase {

    @Test
    public void findSearchTest() {
        app.header.checkSearchPageLaunch();
    }

}
