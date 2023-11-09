package prova.pulo.Pages;
import prova.pulo.Base.BasePage;
import org.openqa.selenium.*;


public class RegisterPage extends BasePage {
    protected static final String firstNameInput = "input-firstname";
    protected static final String lastNameInput = "input-lastname";
    protected static final String emailInput = "input-email";
    protected static final String telephoneInput = "input-telephone";
    protected static final String passwordInput = "input-password";
    protected static final String confirmPasswordInput = "input-confirm";
    protected static final String radioNo = "//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input";
    protected static final String termsAgree = "//*[@id=\"content\"]/form/div/div/input[1]";
    protected static final String btnContinue = "//*[@id=\"content\"]/form/div/div/input[2]";
    protected static final String successMsg = "//*[@id=\"content\"]/p[1]";

    public void enterPersonalInfo(String firstName, String lastName, String email, String telephone) throws InterruptedException{
        WebElement name = getWebElement(By.id(firstNameInput));
        name.clear();
        name.sendKeys(firstName);
        Thread.sleep(1000);
        WebElement surname = getWebElement(By.id(lastNameInput));
        surname.clear();
        surname.sendKeys(lastName);
        Thread.sleep(1000);
        WebElement emailAddy = getWebElement(By.id(emailInput));
        emailAddy.clear();
        emailAddy.sendKeys(email);
        Thread.sleep(1000);
        WebElement telephoneNumber = getWebElement(By.id(telephoneInput));
        telephoneNumber.clear();
        telephoneNumber.sendKeys(telephone);
        Thread.sleep(1000);
    }

    public void enterPwAndConfirm(String password, String confirmation) throws InterruptedException{
        WebElement pw = getWebElement(By.id(passwordInput));
        pw.clear();
        pw.sendKeys(password);
        Thread.sleep(1000);
        WebElement confirm = getWebElement(By.id(confirmPasswordInput));
        confirm.clear();
        confirm.sendKeys(confirmation);
        Thread.sleep(1000);
    }

    public void acceptNewsletter(){
        WebElement radioButton = getWebElement(By.xpath(radioNo));
        radioButton.click();
    }

    public void acceptTerms(){
        WebElement terms = getWebElement(By.xpath(termsAgree));
        terms.click();
    }

    public void proceed(){
        WebElement conclude = getWebElement(By.xpath(btnContinue));
        conclude.click();
    }

    public String confirmSucccess(){
        WebElement success = getWebElement(By.xpath(successMsg));
        return success.getText();
    }
    
}
