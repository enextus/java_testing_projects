package com.example.testTask;

        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.interactions.Actions;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.concurrent.TimeUnit;

public class SearchItemTest {

    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://yandex.ru/");
    }

    @Test
    public void itemTest() {
        click(By.xpath("//html/body/div[3]/div/div[1]/table/tbody/tr/td[2]/table/tbody/tr/td[2]/button"));
        click(By.cssSelector("[data-id='market']"));
        switchToNextTab();
        click(By.cssSelector("[href='/catalog--elektronika/54440']"));
        click(By.cssSelector("[href='/catalog--smartfony/16814639/list?glfilter=4940921%3A13475069&hid=91491']"));
        // click(By.cssSelector("[data-id='button-all']"));
        Actions actions = new Actions(wd);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        //to move page down
        type(By.cssSelector("#glpricefrom"), "20000");
        type(By.cssSelector("#glpriceto"),"35000");
        click(By.xpath("//span[text()='Apple']"));
        wd.navigate().refresh();

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

    @AfterMethod(enabled = false)
    public void tearDown() {
        wd.quit();
    }

    /*
    Запомнить второй элемент в результатах поиска
В поисковую строку ввести запомненное значение.
Найти и проверить, что наименование товара соответствует запомненному значению.
     */
}