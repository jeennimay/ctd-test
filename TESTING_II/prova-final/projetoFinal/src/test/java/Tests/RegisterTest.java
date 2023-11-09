package Tests;

import BasePage.BasePage;
import Pages.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;

public class RegisterTest {
    private static WebDriver driver;

    @BeforeEach
    public void SetUp(){
        BasePage BPage = new BasePage();
        BPage.OpenSite();
        driver = BPage.getDriver();
    }

    @Test
    public void TestRegister() throws InterruptedException{
        RegisterPage Register = new RegisterPage();

        Register.OpenRegisterPage();
        Thread.sleep(3000);

        Register.AddPersonalInfo(
                "Rosa",
                "Flores",
                "Jardim das flores",
                "Flores de Setembro",
                "Algum lugar bonito",
                "1234521",
                "58-1861-7590",
                "23451236",
                "FloresRosa",
                "LOS14OIC8XX"
        );
        Thread.sleep(4000);

        String SuccessMsg = Register.ConfirmSuccess();
        Thread.sleep(3000);
        assertTrue(SuccessMsg.contains("Your account was created successfully. You are now logged in."));
    }

    @AfterEach
    public void TearDown(){
        driver.quit();
    }
}
