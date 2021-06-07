import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class findTermsOfTabTest {

    @Test
    public void findTermsOfUseTabTest() {

        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com/");

        Thread.sleep(5000);  // Let the user actually see something!

        WebElement searchBox = driver.findElement(By.name("q"));

        searchBox.sendKeys("ChromeDriver");

        searchBox.submit();


//
//
//
//
//        wd.findElement(By.xpath("//ul[@class='header__nav desktop']/li[3]")).click();
//        Assert.assertTrue(isElementPresent1(By.xpath("//div[contains(.,'Terms')]")));
//

        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();


    }

//    @Test
//    public void findSearchTest() {
//        wd.findElement(By.xpath("//ul[@class='header__nav desktop']/li[1]")).click();
//        Assert.assertTrue(isElementPresent1(By.cssSelector(".search-sidebar__content")));
//    }

}
