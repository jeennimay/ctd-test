package Tests;

import BasePage.BasePage;
import Pages.TransferFundsPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransferFundsTest {
    private static WebDriver driver;

    @BeforeEach
    public void SetUp(){
        BasePage BPage = new BasePage();
        BPage.OpenSite();
        driver = BPage.getDriver();
    }

    @Test
    public void TranferingFunds() throws InterruptedException {
        TransferFundsPage Transfer = new TransferFundsPage();

        Transfer.VerifyLogin("FloresRosa", "LOS14OIC8XX");
        Thread.sleep(4000);

        Transfer.OpenTransferPage();
        Thread.sleep(4000);

        Transfer.TransferFundsPage("200");
        Thread.sleep(3000);

        String SuccessMsg = Transfer.SuccessMessage();
        assertTrue(SuccessMsg.contains("Transfer Complete!"));
    }

    @AfterEach
    public void TearDown(){
        driver.quit();
    }
}


//"FloresRosa", "LOS14OIC8XX"