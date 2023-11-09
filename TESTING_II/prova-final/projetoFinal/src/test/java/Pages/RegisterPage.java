package Pages;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class RegisterPage extends BasePage {

    protected static final String RegisterPage = "//*[@id=\"loginPanel\"]/p[2]/a";    //XPATH
    protected static final String InputFirstName = "customer.firstName";             //ID
    protected static final String InputLastName = "customer.lastName";                   //ID
    protected static final String InputStreet = "customer.address.street";           //ID
    protected static final String InputCity = "customer.address.city";               //ID
    protected static final String InputState = "customer.address.state";             //ID
    protected static final String InputZipCode = "customer.address.zipCode";         //ID
    protected static final String InputPhone = "customer.phoneNumber";               //ID
    protected static final String InputSSN = "customer.ssn";                         //ID
    protected static final String InputUsername = "customer.username";               //ID
    protected static final String InputPassword = "customer.password";               //ID
    protected static final String InputConfirmPassword = "repeatedPassword";         //ID
    protected static final String BtnRegister = "//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input";     //XPATH
    protected static final String MsgSuccess = "//*[@id=\"rightPanel\"]/p";         //XPATH

    public void OpenRegisterPage() throws InterruptedException{
        WebElement Register = getWebElement(By.xpath(RegisterPage));
        Register.click();
        Thread.sleep(2000);
    }

    public void AddPersonalInfo(String FirstName, String LastName, String StreetAddress, String CityAddress, String StateAddress, String ZipCode, String PhoneNumber, String SSN, String Username, String PW) throws InterruptedException{
        WebElement AddFName = getWebElement(By.id(InputFirstName));
        AddFName.sendKeys(FirstName);
        Thread.sleep(2000);

        WebElement AddLName = getWebElement(By.id(InputLastName));
        AddLName.sendKeys(LastName);
        Thread.sleep(2000);

        WebElement AddStreet = getWebElement(By.id(InputStreet));
        AddStreet.sendKeys(StreetAddress);
        Thread.sleep(2000);

        WebElement AddCity = getWebElement(By.id(InputCity));
        AddCity.sendKeys(CityAddress);
        Thread.sleep(2000);

        WebElement AddState = getWebElement(By.id(InputState));
        AddState.sendKeys(StateAddress);
        Thread.sleep(2000);

        WebElement AddZipCode = getWebElement(By.id(InputZipCode));
        AddZipCode.sendKeys(ZipCode);
        Thread.sleep(2000);

        WebElement AddPhone = getWebElement(By.id(InputPhone));
        AddPhone.sendKeys(PhoneNumber);
        Thread.sleep(2000);

        WebElement AddSSN = getWebElement(By.id(InputSSN));
        AddSSN.sendKeys(SSN);
        Thread.sleep(2000);

        WebElement AddUsername = getWebElement(By.id(InputUsername));
        AddUsername.sendKeys(Username);
        Thread.sleep(2000);

        WebElement AddPW = getWebElement(By.id(InputPassword));
        AddPW.sendKeys(PW);
        Thread.sleep(2000);

        WebElement AddCPW = getWebElement(By.id(InputConfirmPassword));
        AddCPW.sendKeys(PW);
        Thread.sleep(2000);

        WebElement RegisterBtn = getWebElement(By.xpath(BtnRegister));
        RegisterBtn.click();
    }

    public String ConfirmSuccess(){
        WebElement Success = getWebElement(By.xpath(MsgSuccess));
        return Success.getText();
    }

}
