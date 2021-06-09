package com.ilCarro.qa14;

import org.testng.annotations.Test;

public class HeaderTest extends TestBase {

    @Test
    public void findSearchTest() {
        app.checkSearchPageLaunch();
    }

}

