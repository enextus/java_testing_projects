import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RefreshDemo {
    public static void main(String args[]) {
        WebDriver driver = new ChromeDriver();
        Dimension d = new Dimension(500, 600);

        driver.get("http://demo.guru99.com/selenium/guru99home/");

        driver.manage().window().maximize();

        for (int i = 0; i < 3; i++) {
            driver.navigate().refresh();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.manage().window().setSize(d);
        driver.navigate().refresh();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.close();
    }

}
