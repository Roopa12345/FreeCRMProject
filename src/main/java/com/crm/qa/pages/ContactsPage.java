package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath ="//td[contains(text(),'Contacts')]")
	//@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(id ="first_name")
	WebElement firstName;
	
	@FindBy(id ="surname")
	WebElement lastName;
	
	@FindBy(name ="client_lookup")
	WebElement company;
	
	@FindBy(xpath ="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	//Initializing the Page objects
		public ContactsPage()
		{
			PageFactory.initElements(driver, this);//Here driver is initialized to all current class @FindBy elements.
		
		}
		
		public boolean verifyContactsLabel()
		{
			return contactsLabel.isDisplayed();
		}
		
		public void selectContactsByName(String name)
		{
			driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
					+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		}
		
		public void createNewContact(String title, String fn, String ln, String cmpny)
		{
			Select sel = new Select(driver.findElement(By.name("title")));
			sel.selectByVisibleText(title);
			
			firstName.sendKeys(fn);
			lastName.sendKeys(ln);
			company.sendKeys(cmpny);
			saveBtn.click();
		}

}
