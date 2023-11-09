package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Register extends BasePage {

    protected static final String BtnAccount = "//*[@id=\"top-links\"]/ul/li[2]/a";
    protected static final String BtnRegister = "Register";
    protected static final String InputFirstName = "input-firstname";
    protected static final String InputLastName = "input-lastname";
    protected static final String InputEmail = "input-email";
    protected static final String InputPhone = "input-telephone";
    protected static final String InputPassword = "input-password";
    protected static final String InputConfirmPw = "input-confirm";
    protected static final String RadioNo = "//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input";
    protected static final String CheckTermsAgree = "//*[@id=\"content\"]/form/div/div/input[1]";
    protected static final String BtnContinue = "//*[@id=\"content\"]/form/div/div/input[2]";
    protected static final String MsgSuccess = "//*[@id=\"content\"]/p[1]";

    public void AccountClick() throws InterruptedException{
        WebElement ACCBtn = getWebElement(By.xpath(BtnAccount));
        ACCBtn.click();
        Thread.sleep(2000);
    }

    public void RegisterClick() throws InterruptedException{
        WebElement RegisterBtn = getWebElement(By.partialLinkText(BtnRegister));
        RegisterBtn.click();
        Thread.sleep(2000);
    }

    public void AddPersonalInfo(String FirstName, String LastName, String Email, String Phone) throws InterruptedException{
        WebElement AddFName = getWebElement(By.id(InputFirstName));
        AddFName.sendKeys(FirstName);
        Thread.sleep(2000);

        WebElement AddLName = getWebElement(By.id(InputLastName));
        AddLName.sendKeys(LastName);
        Thread.sleep(2000);

        WebElement AddEmail = getWebElement(By.id(InputEmail));
        AddEmail.sendKeys(Email);
        Thread.sleep(2000);

        WebElement AddPhone = getWebElement(By.id(InputPhone));
        AddPhone.sendKeys(Phone);
        Thread.sleep(2000);
    }

    public void AddPassword(String Password, String ConfirmPw) throws InterruptedException{
        WebElement Pw = getWebElement(By.id(InputPassword));
        Pw.sendKeys(Password);
        Thread.sleep(2000);

        WebElement CPw = getWebElement(By.id(InputConfirmPw));
        CPw.sendKeys(ConfirmPw);
        Thread.sleep(2000);
    }

    public void NewsLetter(){
        WebElement BtnNo = getWebElement(By.xpath(RadioNo));
        BtnNo.click();
    }

    public void TermsAgree(){
        WebElement Terms = getWebElement(By.xpath(CheckTermsAgree));
        Terms.click();
    }

    public void ContinueBtn(){
        WebElement BContinue = getWebElement(By.xpath(BtnContinue));
        BContinue.click();
    }

    public String ConfirmSuccess(){
        WebElement Success = getWebElement(By.xpath(MsgSuccess));
        return Success.getText();
    }
}
