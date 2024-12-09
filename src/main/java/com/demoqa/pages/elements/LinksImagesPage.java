package com.demoqa.pages.elements;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class LinksImagesPage extends BasePage {
    public LinksImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a")
    List<WebElement> allLinks;

    public LinksImagesPage checkAllLinks() {
        String url = "";
        System.out.println("Total links on the page: " + allLinks.size());
        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
            System.out.println("*******************************************");
        }
        return this;
    }

    public LinksImagesPage checkBrokenLinks() {
        for (int i = 0; i < allLinks.size(); i++) {
            WebElement element = allLinks.get(i);
            String url = element.getDomAttribute("href");
            verifyLinks(url);

        }

        return this;
    }

    @FindBy(css="img")
    List<WebElement> images;
    public LinksImagesPage checkBrokenImages() {
        System.out.println(images.size() + " - " + "images");
        for (int i = 0; i < images.size(); i++) {
            WebElement element = images.get(i);
            String imageURL = element.getAttribute("src");
            verifyLinks(imageURL);
            try{
                boolean imageDisplayed = (Boolean)
                        js.executeScript("return (typeof arguments[0].naturalWidth!=undefined && arguments[0].naturalWidth>0);", element);
                if(imageDisplayed){
                    System.out.println("Display - ok");
                }else {
                    System.out.println("Display - broken");
                    System.out.println("******************");
                }

            }catch (Exception e){
                System.out.println("Error occurred");
            }
        }
        return this;
    }
}
