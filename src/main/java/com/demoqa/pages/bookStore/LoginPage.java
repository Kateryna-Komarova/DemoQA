package com.demoqa.pages.bookStore;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "userName")
    WebElement userField;
    @FindBy(id ="password")
    WebElement passwordField;
    public LoginPage enterUserData(String userName, String password) {
        type(userField,userName);
        type(passwordField, password);
        return this;
    }

    @FindBy(id = "login")
    WebElement loginButton;

    public ProfilePage clickOnLoginButton() {
        clickWithJS(loginButton,0,800);
        return new ProfilePage(driver);
    }
}
