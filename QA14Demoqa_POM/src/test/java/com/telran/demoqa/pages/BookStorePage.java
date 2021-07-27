package com.telran.demoqa.pages;

import org.openqa.selenium.By;
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

    @FindBy(id="searchBox")
    WebElement searchInput;

    public BookStorePage typeInSearchInputFieldInput(String text) {
        type(searchInput, text);
        return this;
    }

    @FindBy(xpath="searchBox")
    WebElement searchInput;

    public String takeNameOfBook() {
        pause(500);
        return nameOfBook.getText();
    }


}
