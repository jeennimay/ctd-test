import Base.BasePage;
import Pages.SearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {
    private static SearchPage page;

    @BeforeEach
    public void setUp() {
        page = new SearchPage();
        page.openApp();
    }

    @Test
    public void testSearch() throws InterruptedException {

        page.buscarIphone("Iphone");
        Thread.sleep(2000);
        page.buscar();
        Thread.sleep(2000);
        page.add();
        Thread.sleep(2000);

        String resultado = page.getResultado();

        assertTrue(resultado.contains("Success: You have added iPhone to your shopping cart!"));

        System.out.println("Resultado da busca:" + resultado);
    }

    @AfterEach
    public void tearDown() {
        page.quitDriver();
    }
}
