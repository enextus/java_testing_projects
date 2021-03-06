package com.telran.demoqa.pages;

import com.telran.demoqa.pages.bookstore.BookStorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='category-cards']/div[.='Book Store Application']")
    WebElement bookStoreBtn;

    public BookStorePage goToBookStore() {
        clickWithAction(bookStoreBtn,0,700);
        return new BookStorePage(driver);
    }

    @FindBy(xpath = "//div[@class='category-cards']/div[.='Alerts, Frame & Windows']")
    WebElement alertFrameAndWindowBtn;

    public SidePanelPage goToFrameAlertAndWindowPage() {
        clickWithAction(alertFrameAndWindowBtn,0,300);
        return new SidePanelPage(driver);
    }

    @FindBy(xpath = "//div//h5[.='Widgets']")
    WebElement widgetsBtn;

    public SidePanelPage gotoWidgetsPage() {
        clickWithAction(widgetsBtn,0,300);
        return new SidePanelPage(driver);
    }

    @FindBy(xpath = "//div[@class='category-cards']/div[2]")
    WebElement formsBtn;

    public SidePanelPage goToForms() {
        clickWithAction(formsBtn,0,300);
        return new SidePanelPage(driver);
    }

    @FindBy(xpath = "//h5[.='Interactions']")
    WebElement interactionsBtn;

    public SidePanelPage goToInteractionsPage() {
        clickWithAction(interactionsBtn, 0, 300);
        return new SidePanelPage(driver);
    }

    @FindBy(xpath = "//div//h5[.='Elements']")
    WebElement elementsBtn;

    public SidePanelPage goToElementsPage() {
        clickWithAction(elementsBtn,0,300);
        return new SidePanelPage(driver);
    }

}
