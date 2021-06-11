package com.example.testTask;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    public String getItemNameFromListByOrder(int number) {
        return wd.findElement(By
                .xpath("//*[@data-autotest-id='product-snippet']["+ number+"]//h3")).getText();
    }

    public void pause() throws InterruptedException {
        Thread.sleep(2000);
    }

    public void refresh() {
        wd.navigate().refresh();
    }

    public void filterItem(Item item) {
        click(By.cssSelector("[href='/catalog--"+ item.getItemType() +"']"));
        // click(By.cssSelector("[data-id='button-all']"));
        Actions actions = new Actions(wd);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        //to move page down
        type(By.cssSelector("#glpricefrom"), item.getPriceFrom());
        type(By.cssSelector("#glpriceto"), item.getPriceTo());
        click(By.xpath("//span[text()='"+ item.getBrand() +"']"));
    }

    public void selectElectronicaDepartment() {
        click(By.cssSelector("[href='/catalog--elektronika/54440']"));
    }

    public void goToMarket() {
        click(By.cssSelector("[data-id='market']"));
    }

    public void typeInSearchInputField(String itemName) {
        type(By.cssSelector("#header-search"),itemName);
        click(By.cssSelector("[type='submit']"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void switchToNextTab() {
        List<String> availableTab = new ArrayList<>(wd.getWindowHandles());
        if (!availableTab.isEmpty()) {
            wd.switchTo().window(availableTab.get(1));
        }
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://yandex.ru/");
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        wd.quit();
    }

}
