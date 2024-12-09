package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class FramePage extends BasePage {
    public FramePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(tagName = "iframe")
    List<WebElement> iframe;

    public FramePage returnListOfFrames() {
        System.out.println("The total number of iframes are " + iframe.size());
        Integer numberOfFrames = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("The total number of iframes are " + numberOfFrames);
        return this;
    }

    public FramePage  switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        return this;

    }

    @FindBy(id="sampleHeading")
    WebElement sampleHeading;

    public FramePage verifyIframeByText(String text) {
        Assert.assertTrue(shouldHaveText(sampleHeading,text,1));
        return this;
    }

    @FindBy(id="frame1")
    WebElement frame1;

    public FramePage switchToIframeById() {
        driver.switchTo().frame(frame1);
        return this;
    }

    public FramePage switchToMainPage() {
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy (tagName = "h1")
    WebElement title;
    public FramePage verifyMainPageByTitle(String text) {
        Assert.assertTrue(title.getText().contains(text));
        return this;
    }

    @FindBy(tagName="body")
    WebElement body;
    public FramePage handleNestedIframes() {
        driver.switchTo().frame(frame1);
        System.out.println("Iframe is " + body.getText());
        System.out.println("Number of iframes inside parent iframe is " + iframe.size());
        driver.switchTo().frame(0);
        System.out.println("Iframe" + body.getText());

        driver.switchTo().parentFrame();
        System.out.println("Iframe is " + body.getText());
        return this;
    }
}
