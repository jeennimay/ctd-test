package Pages;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountsOverviewPage extends BasePage {

    protected static final String AccountOverview = "//*[@id=\"leftPanel\"]/ul/li[2]/a";            //XPATH
    protected static final String MessageBalance = "//*[@id=\"accountTable\"]/tfoot/tr/td";         //XPATH
    protected static final String SelectAccount = "//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a";  //XPATH
    protected static final String AccountDetails = "//*[@id=\"rightPanel\"]/div/div[1]/h1";         //XPATH
    protected static final String BtnActivyPeriod = "//*[@id=\"month\"]/option[1]";                 //XPATH
    protected static final String BtnType = "//*[@id=\"transactionType\"]/option[1]";               //XPATH
    protected static final String BtnGo = "//*[@id=\"rightPanel\"]/div/div[2]/form/table/tbody/tr[3]/td[2]/input";     //XPATH


    public void OpenOverviewPage() throws InterruptedException{
        WebElement OverviewPage = getWebElement(By.xpath(AccountOverview));
        OverviewPage.click();
        Thread.sleep(4000);
    }

    public String VerifyBalanceMessage(){
        WebElement MsgBalance = getWebElement(By.xpath(MessageBalance));
        return MsgBalance.getText();
    }

    public void SelectingAccount() throws InterruptedException{
        WebElement SelectOption = getWebElement(By.xpath(SelectAccount));
        Thread.sleep(4000);
        SelectOption.click();
        Thread.sleep(4000);
    }

    public String VerifyAccDetailsPage(){
        WebElement AccountDetailsMsg = getWebElement(By.xpath(AccountDetails));
        return AccountDetailsMsg.getText();
    }

    public void AccountDetailsPage() throws InterruptedException{
        WebElement ActivityPeriod = getWebElement(By.xpath(BtnActivyPeriod));
        ActivityPeriod.click();
        Thread.sleep(2000);

        WebElement ActivityType = getWebElement(By.xpath(BtnType));
        ActivityType.click();
        Thread.sleep(2000);

        WebElement ButtonGo = getWebElement(By.xpath(BtnGo));
        ButtonGo.click();
        Thread.sleep(4000);
    }

}
