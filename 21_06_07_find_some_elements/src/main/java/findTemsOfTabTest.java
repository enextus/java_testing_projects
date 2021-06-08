import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

class findTermsOfTabTest {

    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void setUp() {
        driver.get("https://ilcarro-dev-v1.firebaseapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public boolean isFindCarFormPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @Test
    public void findTermsOfUseTabTest() throws InterruptedException {
        WebElement wd = driver.findElement(By.name("address"));

/*      searchBox.sendKeys("ChromeDriver");
        searchBox.submit();*/

        wd.findElement(By.xpath("//ul[@class='header__nav desktop']/li[3]")).click();
        Assert.assertTrue(isElementPresent(By.xpath("//div[contains(.,'Terms')]")));
        //Assert.assertTrue(isElementPresent(By.cssSelector(".search-sidebar__content")));
    }

    @Test
    public void findSearchTest() {
        driver.findElement(By.xpath("//ul[@class='header__nav desktop']/li[1]")).click();
        System.out.println(driver);
        Assert.assertTrue(isElementPresent(By.cssSelector(".search-sidebar__content")));
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        System.out.println("Driver: " + driver.getTitle());
        driver.quit();
    }

}
