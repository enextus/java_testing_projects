package com.telran.demoqa.pages.bookstore;

import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStorePage extends PageBase {
    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login")
    WebElement loginBtn;

    public LoginPage goToLoginPage() {
        loginBtn.click();

        return new LoginPage(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchInput;

    public BookStorePage typeInSearchFieldInput(String text) {
        type(searchInput,text);

        return this;
    }

    @FindBy(xpath = "//span[@class='mr-2']/a")
    WebElement nameOfBook;

    public String takeNameOfBook() {
        // pause(500);

        return nameOfBook.getText();
    }

    @FindBy(css = ".rt-tr-group:nth-child(1) .rt-td:nth-child(2)")
    WebElement firstTitle;

    public String verifyEmptyField() {

        return firstTitle.getText();
    }

    public BookStorePage clickByFirstBook() {
        nameOfBook.click();

        return this;
    }

    @FindBy(css = ".text-right.fullButton")
    WebElement addToCollectionBtn;

    public BookStorePage addToYourCollection() {
        clickWithAction(addToCollectionBtn,0,700);
        pause(500);
        driver.switchTo().alert().accept();

        return this;
    }

    @FindBy(css = ".show #item-3")
    WebElement profileBtn;

    public ProfilePage clickOnProfileButton() {
        clickWithAction(profileBtn,0,700);

        return new ProfilePage(driver);
    }

}
