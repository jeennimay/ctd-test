import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Driver {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();

        //entrada no site
        driver.get("https://www.mercadolivre.com.br");
        //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        //maximizar tela
        driver.manage().window().maximize();

        //Fechar o card de cookies
        WebElement closeCookies = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/button[1]"));
        closeCookies.click();

        //procurou por iPhone 13 no campo de busca
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"cb1-edit\"]"));
    /*
        //css
        WebElement searchBox = driver.findElement(By.cssSelector("#cb1-edit"));
        searchBox.sendKeys("iPhone 13");
    */

        //click para pesquisar
        WebElement searchButton = driver.findElement(By.cssSelector("body > header > div > form > button > div"));
        searchButton.click();

        //click no primeiro resultado apresentado
        WebElement firstResult = driver.findElement(By.cssSelector("#root-app > div > div.ui-search-main.ui-search-main--only-products.ui-search-main--with-topkeywords > section > ol > li:nth-child(1) > div > div > div.ui-search-result__content-wrapper > div.ui-search-item__group.ui-search-item__group--title > a > h2"));
        firstResult.click();

        //seleção do tamanho de memória
        WebElement memoryStorage = driver.findElement(By.cssSelector("#ui-pdp-main-container > div.ui-pdp-container__col.col-3.ui-pdp-container--column-center.pb-40 > div > div.ui-pdp-container__row.ui-pdp-with--separator--fluid.ui-pdp-with--separator--40 > div.ui-pdp-container__col.col-2.mr-32 > div.ui-pdp-variations > div:nth-child(1) > div > a:nth-child(3) > div > p"));
        memoryStorage.click();

        //seleção da cor
        WebElement colorChoice = driver.findElement(By.cssSelector("#ui-pdp-main-container > div.ui-pdp-container__col.col-3.ui-pdp-container--column-center.pb-40 > div > div.ui-pdp-container__row.ui-pdp-with--separator--fluid.ui-pdp-with--separator--40 > div.ui-pdp-container__col.col-2.mr-32 > div.ui-pdp-variations > div:nth-child(2) > div > a:nth-child(4) > div > img"));
        colorChoice.click();

        //Ir para o carrinho
        //WebElement sendToChart = driver.findElement(By.cssSelector("#buybox-form > div.ui-pdp-actions > div > button.andes-button.andes-spinner__icon-base.andes-button--quiet > span"));
        WebElement sendToChart = driver.findElement(By.xpath("//*[@id=\"buybox-form\"]/div[6]/div/button[2]"));
        sendToChart.click();
    }
}
