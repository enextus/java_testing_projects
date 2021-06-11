import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RefreshTest extends TestBase {

    @Test
    public void itemTest() throws InterruptedException {

        wd.manage().window().maximize();

        for (int i = 0; i < 3; i++) {
            wd.navigate().refresh();
        }

        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        wd.manage().window().setSize(d);
        wd.navigate().refresh();

        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        wd.manage().window().maximize();
    }

}
