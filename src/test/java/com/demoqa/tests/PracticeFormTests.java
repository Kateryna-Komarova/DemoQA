package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.forms.PracticeFormPage;
import com.demoqa.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm().hideIframes();
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "addNewStudentWithCsv")

    public void createStudentAccount(String name,String lastName, String  email, String phone) {
        new PracticeFormPage(driver)
                .enterPersonalData(name,lastName,email,phone)
                .selectGender("Male")
                .enterDate("25 Aug 1965")
                .addSubjects(new String[]{"Math", "Chemistry"})
                .selectHobby(new String[]{"Sports", "Reading"})
                .uploadFile("/Users/kato/Tools/868.jpg")
                .inputState("NCR")
                .inputCity("Delhi")
                .submit()
                .verifySuccessRegistration("Thanks for submitting the form")
        ;
    }

    @Test
    public void createStudentAccountWithSelectDate() {
        new PracticeFormPage(driver).enterPersonalData("Kokos", "Apenmauer", "kokos@gmail.com", "2456743452")
                .selectGender("Male")
                .selectDate("September", "1990", "3")
                .addSubjects(new String[]{"Math", "Chemistry"})
                .selectHobby(new String[]{"Sports", "Reading"})
                .uploadFile("/Users/kato/Tools/868.jpg")
                .inputState("NCR")
                .inputCity("Delhi")
                .submit()
                .verifySuccessRegistration("Thanks for submitting the form")
        ;
    }
}
