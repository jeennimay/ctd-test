package BasePage;

import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    public static WebDriver driver;
    protected static final String URL = "https://parabank.parasoft.com/parabank/index.htm";

    public BasePage() {
        if(driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public void OpenSite(){
        driver.get(URL);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public WebElement getWebElement(By locator){
        WebElement element = null;
        try{
            element = driver.findElement(locator);
        } catch (Exception e) {
            System.out.println("Element not found");
            System.out.println("Error: " + e);
        }
        return element;
    }

    public void VerifyLogin(String User, String PW) throws InterruptedException {
        LoginPage VerificandoLogin = new LoginPage();
        String LoginPainel = VerificandoLogin.VerificarPainelLogin();

        if (LoginPainel.contains("Customer Login")){
            VerificandoLogin.FazerLogin(
                    User,
                    PW
            );
        }
    }
}
