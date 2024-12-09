package com.demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public class BasePage {

  public   WebDriver driver;
 public static JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    public void click(WebElement element){
        element.click();
    }

    public void type(WebElement element, String text){
        if(text != null){
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }
    public void clickWithJS(WebElement element,int x,int y){
        moveWithJS(x, y);
        click(element);
    }

    public void moveWithJS(int x, int y) {
        js.executeScript("window.scrollBy("+ x +","+ y +")");
    }
    public void typeWithJS(WebElement element,String text, int x, int y) {
        moveWithJS(x,y);
        type(element, text);

    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.textToBePresentInElement(element,text));
    }


    public void hideAd(){
        js.executeScript("document.getElementById('fixedban').style.display='none';");
    }

    public void hideFooter(){
        js.executeScript("document.querySelector('footer').style.display='none';");
    }

    public void hideIframes(){
        hideAd();
        hideFooter();
    }
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public  boolean isElementDisplayed(WebElement element){
        try {
            element.isDisplayed();
            return true;
        }catch (NoSuchElementException exception){
            exception.getMessage();
            return false;
        }
    }

    public void verifyLinks(String url) {
        try {
            URL linkUrl = new URL(url);
            //create URL connection and get response code
            HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            if (connection.getResponseCode() >= 400) {
                System.out.println(url + " - " + connection.getResponseMessage() + "is a broken link");
            } else {
                System.out.println(url + " - " + connection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(url + " - " + e.getMessage() + "Error occurred");
        }
    }
}
