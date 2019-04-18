package com.qa.stepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import org.junit.Assert;
import org.junit.runner.RunWith;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;

@RunWith(Cucumber.class)
public class HomePageSteps extends TestBase {

	LoginPage loginPage;
	HomePage home;
	
    @Given("^user opens the browser$")
    public void user_opens_the_browser()  {
     TestBase.initialization();   
    }

    @Then("^user is on login page$")
    public void user_is_on_login_page()  {
    	 loginPage= new LoginPage();
    	String title = loginPage.validateLoginPageTitle();
        System.out.println(title);
        Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", title);
        
       boolean b = loginPage.validateCRMImage();
       Assert.assertTrue(b);
    }

    @Then("^user enters username and password$")
    public void user_enters_username_and_password()  {
        home = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        
    }

    @Then("^validate homepage title$")
    public void validate_homepage_title()  {
    	String title = home.verifyHomePageTitle();
        Assert.assertEquals("CRMPRO", title);
    }

    @Then("^validate logged in username$")
    public void validate_logged_in_username() {
    	driver.switchTo().frame("mainpanel");
    	//System.out.println(home.verifyCorrectUserName());
    	boolean uName = home.verifyCorrectUserName();
        Assert.assertTrue(uName);
        home.clickOnNewContactLink();
        driver.quit();
    }

} 