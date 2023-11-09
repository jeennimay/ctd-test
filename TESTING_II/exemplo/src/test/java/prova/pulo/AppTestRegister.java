package prova.pulo;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import prova.pulo.Base.BasePage;
import prova.pulo.Pages.HomePage;
import prova.pulo.Pages.RegisterPage;
import prova.pulo.Pages.SearchPage;

/**
 * Unit test for simple App.
 */
public class AppTestRegister {
    private static WebDriver driver;

	@Before
	public void setUp(){
		BasePage basePage = new BasePage();
		basePage.openSite();
		driver = basePage.getDriver();
	}

	@Test
	public void testItAll() throws InterruptedException{
		HomePage home = new HomePage();
		home.btnAccount();
		Thread.sleep(2000);
		home.btnRegister();
		Thread.sleep(2000);

        RegisterPage register = new RegisterPage();
        register.enterPersonalInfo("Jonas", "Antunes", "email@jonas.dothree", "666-666-666");
        Thread.sleep(2000);
        register.enterPwAndConfirm("1BoaSenha!", "1BoaSenha!");
        Thread.sleep(2000);
        register.acceptNewsletter();
        Thread.sleep(2000);
        register.acceptTerms();
        Thread.sleep(2000);
        register.proceed();
        Thread.sleep(2000);

        String confirmMessage = register.confirmSucccess();
        assertTrue(confirmMessage.contains("Congratulations! Your new account has been successfully created!"));
        System.out.println("Confirmation: " + confirmMessage);

		SearchPage search = new SearchPage();
		search.searchItem("iphone");
		Thread.sleep(2000);
		search.addItemToCart();
		Thread.sleep(2000);

		String successAdded = search.confirmSucccess();
		assertTrue(successAdded.contains("Success: You have added iPhone to your shopping cart!"));
		System.out.println("Confirmation: " + successAdded);
	}

	@After
	public void tearDown(){
		driver.quit();
	}
}
