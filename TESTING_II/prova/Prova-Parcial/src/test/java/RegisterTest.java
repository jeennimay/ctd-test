import Base.BasePage;
import Pages.RegisterPage;
import Pages.SearchPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest {

    private static RegisterPage page;
    public static RegisterPage page2;

    //beforeEach - p acontecer antes de todos os testes
    @BeforeEach
    public void setUp() {
        page = new RegisterPage();
        page.openApp();
    }

    @Test
    public void testeLogin() throws InterruptedException {

        page.clickMyAccount();
        Thread.sleep(2000);
        page.clickRegister();
        Thread.sleep(2000);
        page.inserirDadosRegister("Larissa", "Nunes", "lari123456@gmail.com", "11912368597", "12345", "12345");
        Thread.sleep(2000);
        page.clickNo();
        Thread.sleep(2000);
        page.clickCheck();
        Thread.sleep(2000);
        page.clickContinue();
        Thread.sleep(2000);
        Thread.sleep(2000);
        String findElement = page.getUsuario();

        assertTrue(findElement.contains("Congratulations! Your new account has been successfully created!"));

        System.out.println("Status do registro:" + findElement);
    }

    @AfterEach
    public void tearDown() {
        page.quitDriver();
    }
}
