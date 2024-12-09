package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgest.ToolTipsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsTest extends TestBase{
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getWidgest();
        new SidePanel(driver).selectToolTips();
    }
    @Test
    public void toolTipsTest(){
        new ToolTipsPage(driver).hoverToolTips()
                .verifyToolTips("buttonToolTip");
    }
}
