

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver","path/chromedriver.exe");
        //driver = new ChromeDriver();
        WebDriver driver = new ChromeDriver();
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

    @AfterMethod(enabled = true)
    public void tearDown() {
        System.out.println("Driver: " + driver.getTitle());
        driver.quit();
    }

}
