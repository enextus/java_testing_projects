package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends PageBase {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;

    @FindBy(id = "droppable")
    WebElement dropHere;

    public DragAndDropPage actionDragMe() {
        Actions actions = new Actions(driver);
        pause(2000);
        actions.dragAndDrop(dragMe, dropHere).build().perform();

        String textTo = dropHere.getText();

        if (textTo.equals("Dropped!")) {
            System.out.println("PASS: Source is dropped to target as expected");
        } else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected");
        }

        return this;
    }

    public DragAndDropPage dragAndDropBy() {

        Actions actions = new Actions(driver);

        int xOffset1 = dragMe.getLocation().getX();
        int yOffset1 = dragMe.getLocation().getY();
        System.out.println("xOffset1--->" + xOffset1 + " yOffset1 --" + yOffset1);

        int xOffset = dropHere.getLocation().getX();
        int yOffset = dropHere.getLocation().getY();
        System.out.println("xOffset1--->" + xOffset + " yOffset1 --" + yOffset);

        xOffset = (xOffset - xOffset1) + 50;
        yOffset = (yOffset - yOffset1) + 100;

        pause(1000);
        actions.dragAndDropBy(dragMe, xOffset, yOffset).build().perform();

        String textTo = dropHere.getText();
        if (textTo.equals("Dropped!")) {
            System.out.println("PASS: Source is dropped to target as expected");
        } else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected");
        }

        return this;
    }

    public DragAndDropPage dragAndDropBy100() {
        Actions actions = new Actions(driver);
        pause(2000);
        actions.dragAndDropBy(dragMe, 100, 100).build().perform();

        return this;
    }

}
