
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RefreshDemo {
    public static void main(String args[]) throws InterruptedException
    {



        WebDriver driver = new ChromeDriver();

        driver.get("http://demo.guru99.com/selenium/guru99home/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(100, 100);
        driver.navigate().refresh();

        driver.close();
    }
}