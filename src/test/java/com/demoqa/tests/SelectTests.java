package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgest.SelectMenuPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWidgest();
        new SidePanel(driver).getSelectMenu().hideIframes();
    }

    @Test
    public void selectOldStyleTest() {
        new SelectMenuPage(driver).selectOldStyle("Blue")
                .verifyColor();
    }
    @Test
    public void multiSElectTest(){
        new SelectMenuPage(driver).multiselect(new String[]{"Red","Green"});
    }
    @Test
    public void  standardMultiSelect(){
        new SelectMenuPage(driver).standardMultiSelect(new String[]{"Volvo","Audi"});
    }
}