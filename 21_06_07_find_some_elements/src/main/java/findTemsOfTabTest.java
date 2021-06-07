import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

class findTermsOfTabTest {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver","path/chromedriver.exe");
        //driver = new ChromeDriver();
        WebDriver driver = new ChromeDriver();
        driver.get("https://ilcarro-dev-v1.firebaseapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public boolean isFindCarFormPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

    @Test
    public void findTermsOfUseTabTest() throws InterruptedException {

        WebElement wd = driver.findElement(By.name("address"));

/*        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();*/
//
        wd.findElement(By.xpath("//ul[@class='header__nav desktop']/li[3]")).click();

        //Assert.assertTrue(isElementPresent(By.xpath("//div[contains(.,'Terms')]")));
        Assert.assertTrue(isElementPresent(By.cssSelector(".search-sidebar__content")));
    }

    private boolean isElementPresent(By cssSelector) {
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
