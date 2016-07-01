package com.sirsidynix.prokarma.laureano_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {

    WebDriver driver;

    @BeforeMethod
    public void before() {
        driver = new FirefoxDriver();	
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod 
    public void afterMethod(ITestResult result){
    	   switch (result.getStatus()){
           case ITestResult.SUCCESS: Reporter.log("TEST SUCCESSFUL");
               break;
           case ITestResult.FAILURE: Reporter.log("TEST FAILED");
               break;
           case ITestResult.SKIP: Reporter.log("TEST TEST SKIPED");
               break;
           default : Reporter.log("UNKNOWN TEST STATUS");
    	   }
      driver.quit();

    }
    
    
    
    
    
    @Test
    public void goToSite() {

    	//Testing is the Site URL and loading are OK
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.go(driver);
        Reporter.log("Navigate to Site");

        Assert.assertEquals(driver.getTitle(), "SirsiDynix.com |");
        Reporter.log("Site Confirmation");
    }


    @Test
    public void search() {

    	//Go to the Site
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.go(driver);
        Reporter.log("Navigate to Site");

        //Do the Search in the site
        homePage.searching("cosugi 2016");
        Reporter.log("Searching in the Site");
        
        //Search confirmation
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
        Assert.assertEquals(driver.getTitle(), "Search | SirsiDynix.com");
        Reporter.log("Search Site Confirmation");

        //Second Search confirmation
        Assert.assertEquals(searchPage.getSearchedFor().getText(), "Search results");
        Reporter.log("Successful searching confirmation");

        //Get the second Result in the search and click on it
        searchPage.getPublication(driver, 2).click();
       

        //Confirm you are in the Correct publication
        Assert.assertEquals(driver.getCurrentUrl(),
                "http://www.sirsidynix.com/blog/2016/05/09/your-cosugi-compendium-everything-you-need-to-know-about");
        Reporter.log("SuccessFull Publication opening");


    }

}
