package Tests;

import Pages.RegisterPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRegister {
    private static RegisterPage page;

    @BeforeAll
    static void setUp() {
        page = new RegisterPage();
        page.openApp();
    }

    @Test
    @Tag("Regression")
    public void testRegister() throws InterruptedException {
        page.clickRegister();
        page.fillForm(
                "João",
                "Silva",
                "Rua Silva Souza",
                "São Paulo",
                "SP",
                "09372110",
                "71991713860",
                "10",
                "joaolindao1112",
                "minhaSenhatop57@"
        );
        page.saveRegister();
        String msg = page.verifyMsg();
        assertTrue(msg.contains("Your account was created successfully. You are now logged in."));
    }

    @AfterAll
    static void tearDown() {
        page.quitDriver();
    }
}
