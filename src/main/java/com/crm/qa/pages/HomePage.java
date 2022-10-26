package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath ="//td[contains(text(),'User: ROOPA R')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initializing the Page Objects
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public ContactsPage clickOnNewContactsLink()
	{
		newContactsLink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDeals()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasks()
	{
		tasksLink.click();
		return new TasksPage();
	}
	
	public void moveOnContactsNClickOnNewContact() throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
		
		
		/*Actions actions = new Actions(driver);
		actions.moveToElement(contactsLink).moveToElement(newContactsLink).click().build().perform();*/
		
		//actions.moveToElement(newContactsLink).build().perform();
		//actions.moveToElement(newContactsLink).click().build().perform();
		//Thread.sleep(200);
		//driver.findElement(By.linkText("New Contact")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
		//newContactsLink.click();
		
		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'New Contact')]"))).click();
	}

}
