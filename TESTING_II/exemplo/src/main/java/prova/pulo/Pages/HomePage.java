package prova.pulo.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import prova.pulo.Base.BasePage;

public class HomePage extends BasePage{
    protected static final String myAccBtn = "My Account";
    protected static final String registerBtn = "Register";


    public void btnAccount() throws InterruptedException{
        WebElement myAccountButton = getWebElement(By.partialLinkText(myAccBtn));
        myAccountButton.click();
        Thread.sleep(1000);
    }

    public void btnRegister() throws InterruptedException{
        WebElement registerButton = getWebElement(By.partialLinkText(registerBtn));
        registerButton.click();
        Thread.sleep(1000);
    }
}
