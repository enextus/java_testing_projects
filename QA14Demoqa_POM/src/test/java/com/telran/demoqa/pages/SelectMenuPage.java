package com.telran.demoqa.pages;

import com.telran.demoqa.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMenuPage extends TestBase {


    public SelectMenuPage(EventFiringWebDriver driver) {
        super();
    }

    @FindBy(xpath = "//select[@id='oldSelectMenu']")
    WebElement oldSelectMenu;

    public SelectMenuPage clickOnOldStyle(String text) {

        Select select = new Select(oldSelectMenu);
        // HTML Select
        select.selectByVisibleText(text);

        List<WebElement> options = select.getOptions();
        System.out.println(select.getFirstSelectedOption().getText() + "<--------- It is first");

        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        return this;
    }

    @FindBy(xpath = "(//div[@class=' css-1wy0on6'])[3]")
    WebElement multiSelectDropDown;

    @FindBy(xpath = "//html")
    WebElement lostFocus;

    public SelectMenuPage clickMultiSelectDropDown(String text) {
        clickWithAction(multiSelectDropDown, 0, 200);

        WebElement el = driver.findElement(By.xpath(String.format("//div[text()='%s']", text)));
        el.click();

        pause(500);
        lostFocus.click();

        return this;
    }

}
