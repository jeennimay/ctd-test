package Pages;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    protected static final String LoginPainel = "//*[@id=\"leftPanel\"]/h2";                       //XPATH
    protected static final String InputLogin = "//*[@id=\"loginPanel\"]/form/div[1]/input";         //XPATH
    protected static final String InputPassword = "//*[@id=\"loginPanel\"]/form/div[2]/input";      //XPATH
    protected static final String BtnLogin = "//*[@id=\"loginPanel\"]/form/div[3]/input";

    public String VerificarPainelLogin() throws InterruptedException{
        WebElement PainelLogin = getWebElement(By.xpath(LoginPainel));
        Thread.sleep(3000);
        return PainelLogin.getText();
    }

    public void FazerLogin(String Username, String Password) throws InterruptedException{
        WebElement LoginUsername = getWebElement(By.xpath(InputLogin));
        LoginUsername.sendKeys(Username);
        Thread.sleep(3000);

        WebElement LoginPassword = getWebElement(By.xpath(InputPassword));
        LoginPassword.sendKeys(Password);
        Thread.sleep(3000);

        WebElement Login = getWebElement(By.xpath(BtnLogin));
        Login.click();
        Thread.sleep(4000);

    }
}
