package prova.pulo.Pages;
import prova.pulo.Base.BasePage;
import org.openqa.selenium.*;

public class SearchPage extends BasePage {
    protected static final String searchInput = "//*[@id=\"search\"]/input";
    protected static final String searchBtn = "//*[@id=\"search\"]/span/button";
    protected static final String addToCart = "//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]";
    protected static final String successCart = "//*[@id=\"product-search\"]/div[1]";

    public void searchItem(String item) throws InterruptedException{
        WebElement searchArea = getWebElement(By.xpath(searchInput));
        searchArea.clear();
        searchArea.sendKeys(item);
        Thread.sleep(1000);
        WebElement searchButton = getWebElement(By.xpath(searchBtn));
        searchButton.click();
        Thread.sleep(1000);

    }

    public void addItemToCart(){
        WebElement addToCartButton = getWebElement(By.xpath(addToCart));
        addToCartButton.click();
    }
    public String confirmSucccess(){
        WebElement success = getWebElement(By.xpath(successCart));
        return success.getText();
    }
}
