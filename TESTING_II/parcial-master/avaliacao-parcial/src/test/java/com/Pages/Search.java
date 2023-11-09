package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Search extends BasePage {
    protected static final String InputSearch = "//*[@id=\"search\"]/input";
    protected static final String BtnSearch = "//*[@id=\"search\"]/span/button";
    protected static final String AddToCart = "//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]";
    protected static final String SuccessCart = "//*[@id=\"product-search\"]/div[1]";

    public void SearchItem(String Item) throws InterruptedException{
        WebElement ISearch = getWebElement(By.xpath(InputSearch));
        ISearch.sendKeys(Item);
        Thread.sleep(2000);

        WebElement BSearch = getWebElement(By.xpath(BtnSearch));
        BSearch.click();
        Thread.sleep(2000);
    }

    public void AddItem(){
        WebElement AddCart = getWebElement(By.xpath(AddToCart));
        AddCart.click();
    }

    public String ConfirmAdded(){
        WebElement CSuccess = getWebElement(By.xpath(SuccessCart));
        return CSuccess.getText();
    }
}
