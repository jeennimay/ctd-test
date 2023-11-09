package Tests;

import BasePage.BasePage;
import Pages.LoginPage;
import Pages.NewAccountPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;

public class OpenNewAccountTest {
    private static WebDriver driver;

    @BeforeEach
    public void SetUp(){
        BasePage BPage = new BasePage();
        BPage.OpenSite();
        driver = BPage.getDriver();
    }

    @Test
    public void OpenAccount() throws InterruptedException{
        NewAccountPage NewAccount = new NewAccountPage();

        NewAccount.VerifyLogin("FloresRosa", "LOS14OIC8XX");

        NewAccount.OpenNewAccountPage();
        Thread.sleep(3000);

        String Msg = NewAccount.ConfirmSuccess();
        Thread.sleep(3000);
        assertTrue(Msg.contains("Congratulations, your account is now open."));
    }

    @AfterEach
    public void TearDown(){
        driver.quit();
    }
}
