package com.Tests;

import static org.junit.jupiter.api.Assertions.*;

import com.Pages.Register;
import com.Pages.Search;
import org.junit.jupiter.api.*;


import com.Base.BasePage;
import org.openqa.selenium.WebDriver;

public class TestRegister {
    private static WebDriver driver;

    @BeforeEach
    public void SetUp(){
        BasePage BPage = new BasePage();
        BPage.OpenSite();
        driver = BPage.getDriver();
    }

    @Test
    public void BuyTest() throws InterruptedException {

        Register RegisterPage = new Register();

        RegisterPage.AccountClick();
        Thread.sleep(3000);
        RegisterPage.RegisterClick();
        Thread.sleep(3000);

        //Personal Info
        RegisterPage.AddPersonalInfo("Byron", "Cardenas", "quis.lectus1.nullam@google.ca", "(545) 244-5537");
        Thread.sleep(3000);
        RegisterPage.AddPassword("VXO23LYF2WB","VXO23LYF2WB");
        Thread.sleep(3000);

        //Accepted
        RegisterPage.NewsLetter();
        Thread.sleep(3000);
        RegisterPage.TermsAgree();
        Thread.sleep(3000);

        //Continue
        RegisterPage.ContinueBtn();
        Thread.sleep(1000);
        System.out.println("Button Continue Clicked");

        //Confirm Message
        String CMessage = RegisterPage.ConfirmSuccess();
        assertTrue(CMessage.contains("Congratulations! Your new account has been successfully created!"));
        Thread.sleep(1000);
        System.out.println("Message: " + CMessage);

        //Seach IPhone
        Search SearchPage = new Search();
        SearchPage.SearchItem("IPhone");
        Thread.sleep(2000);

        //Add to cart
        SearchPage.AddItem();
        Thread.sleep(2000);

        //Confirm Message
        String ConfirmAddedMsg = SearchPage.ConfirmAdded();
        assertTrue(ConfirmAddedMsg.contains("Success: You have added iPhone to your shopping cart!"));
        Thread.sleep(1000);
        System.out.println("Message: " + ConfirmAddedMsg);
    }

    @AfterEach
    public void TearDown(){
        driver.quit();
    }
}
