package com.telran.qa14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NavMenuTest {

    WebDriver driver;

    //before - setUp(){}
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();

        driver.navigate().to("http://automationpractice.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void navMenuTest() {
        WebElement name;
        List<WebElement> names = driver.findElements(By.xpath("//*[@id='block_top_menu']/ul/li"));
        int count = names.size();

        for (int i = 1; i < count + 1; i++) {
            name = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[" + i + "]/a"));
            System.out.println("Name " + i + ": " + name.getTagName() + ",  " + name.getText());

            name.click();
        }

    }

    //after - tearDown()
    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }

}

/*        WebElement div = driver.findElement(By.xpath("//div[@id='block_top_menu']"));
        div.findElement(By.xpath(".//*[@title='T-shirts']")).click(); // find the menu element and click them*/