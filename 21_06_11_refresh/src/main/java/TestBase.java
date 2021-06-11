import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public class TestBase {

    WebDriver wd = new ChromeDriver();
    Dimension d = new Dimension(500, 600);

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wd.navigate().to("https://yandex.ru/");
        wd.get("http://demo.guru99.com/selenium/guru99home/");
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        wd.quit();
    }

}
