package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class BrokenLinksAndImagesPage extends PageBase {

    public BrokenLinksAndImagesPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> allLinks;

    public BrokenLinksAndImagesPage checkAllURL() {

        String url = "";
        System.out.println("Total links on the Page: " + allLinks.size());

        Iterator<WebElement> iterator = allLinks.iterator();

        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }

        return this;
    }

    public BrokenLinksAndImagesPage checkBrokenLinks() throws IOException {

        for (int i = 0; i < allLinks.size(); i++) {
            WebElement element = allLinks.get(i);

            String url = element.getAttribute("href");

            verifyLinks(url);

        }

        return this;
    }

    private void verifyLinks(String linkURL) {

        try {
            URL url = new URL(linkURL);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();

            if (connection.getResponseCode() >= 400) {
                System.out.println(linkURL + " - " + connection.getResponseMessage() + " is broken link");

            } else {
                System.out.println(linkURL + " - " + connection.getResponseMessage());

            }
        } catch (Exception e) {
            System.out.println(linkURL + " - " + e.getMessage() + " - is a broken link");
        }

    }

}
