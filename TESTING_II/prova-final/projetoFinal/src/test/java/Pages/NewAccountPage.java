package Pages;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewAccountPage extends BasePage {
    protected static final String OpenNewAccount = "//*[@id=\"leftPanel\"]/ul/li[1]/a";                     //XPATH
    protected static final String SelectAccountTypeSaving = "//*[@id=\"type\"]/option[2]";                        //XPATH
    protected static final String BtnOpenNewAccount = "//*[@id=\"rightPanel\"]/div/div/form/div/input";     //XPATH
    protected static final String MessageSuccess = "//*[@id=\"rightPanel\"]/div/div/p[1]";                  //XPATH

    public void OpenNewAccountPage() throws InterruptedException{
        WebElement OpenPage = getWebElement(By.xpath(OpenNewAccount));
        OpenPage.click();
        Thread.sleep(4000);

        WebElement SelectOption = getWebElement(By.xpath(SelectAccountTypeSaving));
        SelectOption.click();
        Thread.sleep(2000);

        WebElement OpenNewAccount = getWebElement(By.xpath(BtnOpenNewAccount));
        OpenNewAccount.click();
        Thread.sleep(4000);
    }

    public String ConfirmSuccess(){
        WebElement Success = getWebElement(By.xpath(MessageSuccess));
        return Success.getText();
    }

}
