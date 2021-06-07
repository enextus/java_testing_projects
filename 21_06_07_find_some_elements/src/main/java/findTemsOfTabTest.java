import org.junit.jupiter.api.Test;

public class findTemsOfTabTest {











    @Test
    public void findTermsOfUseTabTest() {
        wd.findElement(By.xpath("//ul[@class='header__nav desktop']/li[3]")).click();
        Assert.assertTrue(isElementPresent1(By.xpath("//div[contains(.,'Terms')]")));
    }
    @Test
    public void findSearchTest() {
        wd.findElement(By.xpath("//ul[@class='header__nav desktop']/li[1]")).click();
        Assert.assertTrue(isElementPresent1(By.cssSelector(".search-sidebar__content")));
    }

}
