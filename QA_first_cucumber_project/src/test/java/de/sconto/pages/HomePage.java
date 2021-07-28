package de.sconto.pages;

import com.codeborne.selenide.Condition;
import de.sconto.util.PropertiesLoader;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public static String baseURL = PropertiesLoader.loadProperty("url");

    private static By acceptBtn = By.xpath("//*[@data-accept-action='all']");
    private static By acceptBanner = By.cssSelector(".consentForm__root");

    public void acceptCookies() {

        $(acceptBtn).click();
        $(acceptBanner).shouldNot(Condition.exist);
    }

}
