package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="(//img[contains(@class,'img-responsive')])[1]")
	WebElement crmLogo;
	
	//How will you initialize page factory, we do it using PageFactory.initElements
	//Initializing the Page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);//Here driver is initialized to all current class @FindBy elements.
	
	}
	
	//Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pswd)
	{
		username.sendKeys(un);
		password.sendKeys(pswd);
		loginBtn.click();
		
		return new HomePage();
	}

}
