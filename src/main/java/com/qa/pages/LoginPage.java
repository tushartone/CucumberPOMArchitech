package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class LoginPage extends TestBase{

	//Initialization of PageFacotry
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	//PageFactory
	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	
	//Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
		
	}
	
	//validate CRMImage
	public boolean validateCRMImage()
	{
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un ,String pass)
	{
		username.sendKeys(un);
		password.sendKeys(pass);
		//LoginBtnClick
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",loginBtn);
		
		return new HomePage();
		
	}
	
	
	
	
	
	
	
	
}
