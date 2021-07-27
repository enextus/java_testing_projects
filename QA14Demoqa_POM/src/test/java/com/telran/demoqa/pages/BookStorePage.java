package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.graalvm.compiler.nodes.PauseNode.pause;

public class BookStorePage extends PageBase{

    public BookStorePage(WebDriver driver, WebElement loginBtn) {
        super(driver);
        this.loginBtn = loginBtn;
    }

    @FindBy(id="login")
    WebElement loginBtn;

    public LoginPage goToLoginPage() {
        loginBtn.click();
        return new LoginPage(driver);
    }

    @FindBy(id="searchInput")
    WebElement searchInput;

    public BookStorePage typeInSearchInputFieldInput(String text) {
        type(searchInput, text);
        return this;
    }




    public String takeNameOfBook() {
        pause(500);

    }


}
