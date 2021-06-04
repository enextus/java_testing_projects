package com.telran.qa14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        WebElement div = driver.findElement(By.xpath("//div[@id='block_top_menu']"));

        //div.findElement(By.xpath(".//*[@title='T-shirts']")).click(); // find the menu element and click them

        WebElement name;

        for (int i = 1; i < 4; i++) {
            name = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[" + i + "]/a"));
            System.out.println(name);
            System.out.println("Name " + " " + (i) + ": " + name.getTagName() + ",  " + name.getText());

            driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[" + i + "]")).click();

            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }

    }

    //after - tearDown()
    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

}
