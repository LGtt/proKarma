package com.sirsidynix.prokarma.laureano_test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchPage {

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div/div/h2")
    private WebElement searchedFor;


    
    public WebElement getPublication (WebDriver driver, int position){

        List <WebElement> CssElements = driver.findElements(By.className("search-result"));
        WebElement getPublication = CssElements.get(position-1).findElement(By.tagName("a"));
        return getPublication;
    }


    public WebElement getSearchedFor() {
        return searchedFor;
    }

    public void setSearchedFor(WebElement searchedFor) {
        this.searchedFor = searchedFor;
    }

}