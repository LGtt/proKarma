package com.sirsidynix.prokarma.laureano_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(id = "edit-search-block-form--2")
    private WebElement search;

    @FindBy(id ="edit-submit")
    private WebElement searchSubmit;



    public void go(WebDriver driver) {
        driver.navigate().to("http://www.sirsidynix.com/");
    }

    public void searching(String query) {
        search.sendKeys(query);
        search.submit();
    }

}
