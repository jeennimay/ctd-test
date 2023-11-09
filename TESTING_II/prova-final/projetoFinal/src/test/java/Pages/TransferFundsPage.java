package Pages;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TransferFundsPage extends BasePage {
    protected static final String PageTransferFunds = "//*[@id=\"leftPanel\"]/ul/li[3]/a";            //XPATH
    protected static final String TransferFunds = "//*[@id=\"rightPanel\"]/div/div/h1";               //XPATH
    protected static final String InputAmount = "amount";                                                  //ID
    protected static final String InputFromAcc = "//*[@id=\"fromAccountId\"]/option[1]";              //XPATH
    protected static final String InputToAcc = "//*[@id=\"fromAccountId\"]/option[2]";                //XPATH
    protected static final String BtnTransfer = "//*[@id=\"rightPanel\"]/div/div/form/div[2]/input";  //XPATH
    protected static final String MsgSuccess = "//*[@id=\"rightPanel\"]/div/div/h1";                  //XPATH

    public void OpenTransferPage() throws InterruptedException{
        WebElement OpenTransfer = getWebElement(By.xpath(PageTransferFunds));
        OpenTransfer.click();
        Thread.sleep(4000);
    }

    public String VerifyTransferPage(){
        WebElement TransferFundsMsg = getWebElement(By.xpath(TransferFunds));
        return TransferFundsMsg.getText();
    }

    public void TransferFundsPage(String Amount) throws InterruptedException{
        WebElement SendAmount = getWebElement(By.id(InputAmount));
        SendAmount.sendKeys(Amount);
        Thread.sleep(2000);

        WebElement FromAcc = getWebElement(By.xpath(InputFromAcc));
        FromAcc.click();
        Thread.sleep(2000);

        WebElement ToAcc = getWebElement(By.xpath(InputToAcc));
        ToAcc.click();
        Thread.sleep(2000);

        WebElement Transfer = getWebElement(By.xpath(BtnTransfer));
        Transfer.click();
        Thread.sleep(4000);
    }

    public String SuccessMessage(){
        WebElement SuccessMsg = getWebElement(By.xpath(MsgSuccess));
        return SuccessMsg.getText();
    }
}
