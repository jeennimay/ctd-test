package Tests;

import BasePage.BasePage;
import Pages.AccountsOverviewPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AcountActivityTest {
    private static WebDriver driver;

    @BeforeEach
    public void SetUp(){
        BasePage BPage = new BasePage();
        BPage.OpenSite();
        driver = BPage.getDriver();
    }

    @Test
    public void AccountActivity() throws InterruptedException{
        AccountsOverviewPage page = new AccountsOverviewPage();

        page.VerifyLogin("FloresRosa", "LOS14OIC8XX");
        Thread.sleep(4000);

        page.OpenOverviewPage();
        Thread.sleep(4000);

        String BalanceMsg = page.VerifyBalanceMessage();
        Thread.sleep(4000);
        assertTrue(BalanceMsg.contains("*Balance includes deposits that may be subject to holds"));

        page.SelectingAccount();
        Thread.sleep(4000);

        String DetailsPage = page.VerifyAccDetailsPage();
        Thread.sleep(4000);
        assertTrue(DetailsPage.contains("Account Details"));
        Thread.sleep(4000);

        page.AccountDetailsPage();
        Thread.sleep(4000);
    }

    @AfterEach
    public void TearDown(){
        driver.quit();
    }
}
