package com.ilCarro.qa14.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager{

    WebDriver wd;

    UserHelper user;
    CarHelper car;
    HeaderHelper header;
    String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }


    public void init() {
        //System.setProperty("webdriver.chrome.driver","path/chromedriver.exe");
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        user = new UserHelper(wd);
        car = new CarHelper(wd);
        header = new HeaderHelper(wd);
    }

    public UserHelper user() {
        return user;
    }

    public CarHelper car() {
        return car;
    }

    public HeaderHelper header() {
        return header;
    }

    public void stop() {
        wd.quit();
    }

}