package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    public static WebDriver driver;
    protected static final String URL = "https://parabank.parasoft.com/parabank/index.htm";
    protected static final String login = "//*[@id=\"loginPanel\"]/form/div[1]/input"; // XPATH
    protected static final String password = "//*[@id=\"loginPanel\"]/form/div[2]/input"; // XPATH
    protected static final String loginBTN = "//*[@id=\"loginPanel\"]/form/div[3]/input"; // XPATH

    public BasePage() {
        driver = new ChromeDriver();
    }

    //Pré-condições: Abrir o site
    public void openApp() {
        getDriver().get(URL);
        getDriver().manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getWebElement(By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
        } catch (Exception e) {
            System.out.println("Elemento não encontrado");
            System.out.println("Mensagem de erro: " + e.getMessage());
        }
        return element;
    }

    public void loginUser() throws InterruptedException {
        WebElement loginInput = getWebElement(By.xpath(login));
        loginInput.sendKeys("joaolindao1112");
        WebElement passwordInput = getWebElement(By.xpath(password));
        passwordInput.sendKeys("minhaSenhatop57@");
        Thread.sleep(1000);
        WebElement btn = getWebElement(By.xpath(loginBTN));
        btn.click();
        Thread.sleep(2000);


    }

    public void quitDriver() {
        getDriver().quit();
    }
}
