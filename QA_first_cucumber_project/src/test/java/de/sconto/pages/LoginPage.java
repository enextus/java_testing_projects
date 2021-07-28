package de.sconto.pages;

import com.codeborne.selenide.SelenideElement;
import de.sconto.util.PropertiesLoader;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static By loginTab = By.xpath("//*[contains(text(),'Anmelden')]");

    private static By loginHeader = By.cssSelector(".existingAccount__headline");

    private static String validEmail = PropertiesLoader.loadProperty("valid.email");
    private static String validPassword = PropertiesLoader.loadProperty("valid.password");

    private static By emailInput = By.id("loginEmail");
    private static By passwordInput = By.id("loginPassword");
    private static By loginButton = By.id("login-submit");

    private static By myAccountIcon = By.cssSelector(".headerElement--login");

    private static By title = By.cssSelector(".titleHeadline");

    public void clickOnLoginTab() {
        $(loginTab).click();
    }

    public void validLoginInput() {
        $(emailInput).val(validEmail);
        $(passwordInput).val(validPassword);
    }

    public void clickOnSubmitButton() {
        $(loginButton).click();
    }

    public SelenideElement validMyAccountIcon() {
        return $(myAccountIcon);
    }

    public void clickOnMyAccountIcon() {
        $(myAccountIcon).click();
    }

    public SelenideElement accountTitle() {
        return $(title);
    }

    public SelenideElement loginPageHeader() {
        return $(loginHeader);
    }

    public void invalidPasswordInput(String email,String password) {
        $(emailInput).val(email);
        $(passwordInput).val(password);
    }

    private static By errorMessage = By.id("loginEmail-error");

    public void errorPasswordMessage() {
        $(errorMessage).shouldHave(text("Benutzername nicht gefunden oder Passwort falsch."));
    }

}

