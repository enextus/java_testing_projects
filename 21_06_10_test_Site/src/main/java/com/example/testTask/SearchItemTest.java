package com.example.testTask;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTest extends TestBase {

    @Test
    public void itemTest() throws InterruptedException {

        goToMarket();
        switchToNextTab();

        selectElectronicaDepartment();

        filterItem(
                new Item().setItemType("smartfony/16814639/list?glfilter=4940921%3A13475069&hid=91491")
                        .setPriceFrom("20000")
                        .setPriceTo("35000")
                        .setBrand("Apple"));
        refresh();

        pause();
        String itemName = getItemNameFromListByOrder(2);

        typeInSearchInputField(itemName);
        String foundItemName = getItemNameFromListByOrder(1);
        Assert.assertEquals(foundItemName, itemName);
    }

}
