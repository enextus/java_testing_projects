package com.ilCarro.qa14;

public class FirefoxExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver",Path_of_Firefox_Driver"); // Setting system properties of FirefoxDriver
                WebDriver driver = new FirefoxDriver(); //Creating an object of FirefoxDriver
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Browserstack Guide"); //name locator for text box
        WebElement searchbutton = driver.findElement(By.name("btnK"));//name locator for google search
        searchbutton.click();
        driver.quit();
    }
}
