package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {

    protected static final String inputBusca = "//*[@id=\"search\"]/input"; //xpath
    protected static final String btnBuscar = "//*[@id=\"search\"]/span/button"; //xpath
    protected static final String btnAddToCart = "//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]/i"; //xpath
    protected static final String resultadoBusca = "//*[@id=\"content\"]/div[3]/div/div/div[1]/a/img"; //xpath
    protected static final String findElement = "//*[@id=\"product-search\"]/div[1]"; //xpath

    //processo de buscar por um iphone
    public void buscarIphone(String iPhone) throws InterruptedException {
        Thread.sleep(2000);
        WebElement searchBox = getWebElement(By.xpath(inputBusca));
        searchBox.clear();
        searchBox.sendKeys(iPhone);
        Thread.sleep(2000);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void buscar() {
        WebElement buscar = getWebElement(By.xpath(btnBuscar));
        buscar.click();
    }

    public void add() {
        WebElement add = getWebElement(By.xpath(btnAddToCart));
        add.click();
    }

    public String getResultado() {
        WebElement resultado = getWebElement(By.xpath(findElement));
        return resultado.getText();
    }
}
