package Tests;

import BasePage.BasePage;
import Pages.AccountsOverviewPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountsOverviewTest {

    private static WebDriver driver;

    @BeforeEach
    public void SetUp(){
        BasePage BPage = new BasePage();
        BPage.OpenSite();
        driver = BPage.getDriver();
    }

    @Test
    public void VerifyOverviewMessage() throws InterruptedException{
        AccountsOverviewPage page = new AccountsOverviewPage();

        page.VerifyLogin("FloresRosa", "LOS14OIC8XX");
        Thread.sleep(4000);

        page.OpenOverviewPage();
        Thread.sleep(4000);

        String BalanceMsg = page.VerifyBalanceMessage();
        Thread.sleep(4000);
        assertTrue(BalanceMsg.contains("*Balance includes deposits that may be subject to holds"));

    }

    @AfterEach
    public void TearDown(){
        driver.quit();
    }
}

//"FloresRosa", "LOS14OIC8XX"