import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    static WebDriver wd;

    @BeforeSuite
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver","path/chromedriver.exe");
        wd = new ChromeDriver();
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public boolean isElementPresent(By by) {
        return wd.findElements(by).size()>0;
    }

    public boolean isElementPresent1(By locator) {
        try{
            wd.findElement(locator);
            return true;
        }catch (NoSuchElementException ex){
            return false;
        }
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        wd.quit();
    }

    public void logout() {
        click(By.xpath("//a[contains(.,'logOut')]"));
    }

    public boolean isSignUpFormPresent() {
        return isElementPresent(By.cssSelector("[href='/signup']"));
    }

    public void isLoginFormPresent() {
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void submit() {
        click(By.cssSelector("[type='submit']"));
    }

    public void isLogoutTabPresent() {
        Assert.assertTrue(isElementPresent(By.xpath("//a[contains(.,'logOut')]")));
    }

    public void jumpToFooter() {
        wd.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);
    }
}
