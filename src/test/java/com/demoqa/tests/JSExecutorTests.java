package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.TextBoxPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutorTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getElements();
        new SidePanel(driver).selectTextBox().hideIframes();
    }

    @Test
    public void jsExecutorTest(){
        new TextBoxPage(driver).enterDataWithJs("Pina Kolada", "kokos@gmail.com")
                .clickOnSubmitWithJs()
                .refreshWithJs()
                .getInnerTextWithJs()
                .verifyUrlWithJs()
                .navigateToNewPageWithJs()
                .verifyTitleOFPageWithJs()
                .generateAlertWithJs();
    }
}
