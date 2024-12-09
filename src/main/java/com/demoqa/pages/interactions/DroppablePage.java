package com.demoqa.pages.interactions;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DroppablePage extends BasePage {
    public DroppablePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "draggable")
    WebElement dragMe;
    @FindBy(id = "droppable")
    WebElement dropHere;

    public DroppablePage actionDragMe() {
        pause(1000);
        moveWithJS(0, 200);
        new Actions(driver).dragAndDrop(dragMe, dropHere).perform();
        return this;
    }

    public DroppablePage verifyDropped(String text) {
        Assert.assertTrue(shouldHaveText(dropHere, text, 5));
        return this;
    }

    public DroppablePage dragAndDropBy(int x, int y) {
        pause(1000);
        moveWithJS(0, 200);
        // dragMe
        int xOffset1 = dragMe.getLocation().getX();
        int yOffset1 = dragMe.getLocation().getY();
        System.out.println("xOffset1: " + xOffset1 + "yOffset1: " + yOffset1);
        //dropHere
        int xOffset = dropHere.getLocation().getX();
        int yOffset = dragMe.getLocation().getY();
        System.out.println("xOffset: " + xOffset + "yOffset: " + yOffset);
        //find the difference x y
        xOffset = (xOffset - xOffset1)+x;
        yOffset =( yOffset - yOffset1) + y;
        new Actions(driver).dragAndDropBy(dragMe,xOffset,yOffset).perform();

        return this;
    }
}
