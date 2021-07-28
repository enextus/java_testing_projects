package de.sconto.steps;

import de.sconto.pages.HomePage;
import io.cucumber.java8.En;

import static com.codeborne.selenide.Selenide.open;
import static de.sconto.pages.HomePage.baseURL;

public class HomePageSteps implements En {

    HomePage homePage;

    public HomePageSteps() {
        Given("I am on the Homepage", () -> {
            //System.setProperty("selenide.browser","Firefox");
            homePage = open(baseURL, HomePage.class);
            homePage.acceptCookies();
        });
    }
}
