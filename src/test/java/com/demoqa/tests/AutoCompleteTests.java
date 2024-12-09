package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgest.AutoCompletePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompleteTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getWidgest();
        new SidePanel(driver).selectAutoComplete().hideIframes();
    }

    @Test
    public void autoCompleteTest(){
        new AutoCompletePage(driver).autoComplete();
    }
}
