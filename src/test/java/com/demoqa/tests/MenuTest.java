package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgest.MenuPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getWidgest();
        new SidePanel(driver).getMenu().hideIframes();
    }
    @Test
    public void moveToMenuTest(){
        new MenuPage(driver).selectSubMenu()
                .verifySubMenu();
    }

}
