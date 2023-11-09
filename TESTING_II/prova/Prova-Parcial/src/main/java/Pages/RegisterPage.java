package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    protected static final String btnMyAccount = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]"; //xpath
    protected static final String btnRegister = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"; // xpath
    protected static final String inputFirstName = "//*[@id=\"input-firstname\"]"; //xpath
    protected static final String inputLastName = "//*[@id=\"input-lastname\"]"; //xpath
    protected static final String inputEmail = "//*[@id=\"input-email\"]"; //xpath
    protected static final String inputTelephone = "//*[@id=\"input-telephone\"]"; //xpath
    protected static final String inputPassword = "//*[@id=\"input-password\"]"; //xpath
    protected static final String inputConfirmPassword = "//*[@id=\"input-confirm\"]"; //xpath
    protected static final String radioNo = "//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input"; //xpath
    protected static final String checkPolicy = "//*[@id=\"content\"]/form/div/div/input[1]"; //xpath
    protected static final String btnContinue = "//*[@id=\"content\"]/form/div/div/input[2]"; //xpath
    protected static final String findElement = "//*[@id=\"content\"]/p[1]"; //xpath

    public void clickMyAccount() {
        WebElement iniciar = getWebElement(By.xpath(btnMyAccount));
        iniciar.click();
    }

    public void clickRegister() {
        WebElement register = getWebElement(By.xpath(btnRegister));
        register.click();
    }

    public void inserirDadosRegister(String firstName, String lastName, String email, String telephone, String password, String confirmPassword ) {
        WebElement campoFirstName = getWebElement(By.xpath(inputFirstName));
        campoFirstName.clear();
        campoFirstName.sendKeys(firstName);
        WebElement campoLastName = getWebElement(By.xpath(inputLastName));
        campoLastName.clear();
        campoLastName.sendKeys(lastName);
        WebElement campoEmail = getWebElement(By.xpath(inputEmail));
        campoEmail.clear();
        campoEmail.sendKeys(email);
        WebElement campoTelephone = getWebElement(By.xpath(inputTelephone));
        campoTelephone.clear();
        campoTelephone.sendKeys(telephone);
        WebElement campoPassword = getWebElement(By.xpath(inputPassword));
        campoPassword.clear();
        campoPassword.sendKeys(password);
        WebElement campoConfirmPassword = getWebElement(By.xpath(inputConfirmPassword));
        campoConfirmPassword.clear();
        campoConfirmPassword.sendKeys(confirmPassword);
    }

    public void clickNo() {
        WebElement clickRadioNo = getWebElement(By.xpath(radioNo));
        clickRadioNo.click();
    }

    public void clickCheck() {
        WebElement clickCheckPolicy = getWebElement(By.xpath(checkPolicy));
        clickCheckPolicy.click();
    }

    public void clickContinue() {
        WebElement clickbtnContinue= getWebElement(By.xpath(btnContinue));
        clickbtnContinue.click();
    }

    public String getUsuario() {
        WebElement identifica = getWebElement(By.xpath(findElement));
        return identifica.getText();
    }
}
