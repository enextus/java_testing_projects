import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RefreshDemo {
    public static void main(String args[]) {
        WebDriver driver = new ChromeDriver();
        Dimension d = new Dimension(500, 600);

        driver.get("http://demo.guru99.com/selenium/guru99home/");

        RefreshTest.maxim(driver, d);
        driver.close();
    }

}
