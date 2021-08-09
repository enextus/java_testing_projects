package com.telran.demoqa.pages;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class BrokenLinksAndImagesPage extends PageBase {
    public BrokenLinksAndImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> allLinks;

    public BrokenLinksAndImagesPage checkAllUrl() {

        String url = "";
        System.out.println("Total links on the Page: " + allLinks.size());

        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }

    public BrokenLinksAndImagesPage checkBrokenLinks() {
        for (int i = 0; i < allLinks.size(); i++) {
            WebElement element = allLinks.get(i);
            String url = element.getAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    private void verifyLinks(String linkURL) {
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder()
                    .url(linkURL)
                    .build();

            Response response = client.newCall(request).execute();


            if (response.isSuccessful()) {
                System.out.println(linkURL + " - " + response.code() + " " + response.message());
            } else {
                System.out.println(linkURL + " - " + response.code() + " " + " is a broken link");
            }
            System.out.println("**********************************************************");


        } catch (Exception e) {
            System.out.println(linkURL + " - " + e.getMessage() + " is a broken link");
            System.out.println("***************************************************************");
        }
    }

    @FindBy(tagName = "img")
    List<WebElement> images;

    public BrokenLinksAndImagesPage checkBrokenImages() {
        System.out.println("We have " + images.size() + " images");

        for (int index = 0; index < images.size(); index++) {
            WebElement image = images.get(index);
            String imageURL = image.getAttribute("src");
            System.out.println("URL of Image " + (index + 1) + " is: " + imageURL);
            verifyLinks(imageURL);

            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return (typeof arguments[0].naturalWidth !='undefined' && arguments[0].naturalWidth > 0);", image);
                if (imageDisplayed) {
                    System.out.println("DISPLAY - OK");
                    System.out.println("***************************");
                } else {
                    System.out.println("DISPLAY - BROKEN");
                    System.out.println("**************************");
                }
            } catch (Exception e) {
                System.out.println("ERROR");
            }

        }

        return this;
    }

}
