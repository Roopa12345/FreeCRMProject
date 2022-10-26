package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage lp;
	HomePage hmp;
	TestUtil tup;
	ContactsPage cntcspage;
	String sheetName = "Contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		tup = new TestUtil();
		cntcspage = new ContactsPage();
		lp = new LoginPage();
		hmp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		tup.switchToFrame();
		cntcspage = hmp.clickOnContactsLink();
	}
	
	@Test(priority = 1)
	public void verifyContactsPageTest()
	{
		Assert.assertTrue(cntcspage.verifyContactsLabel(), "Contacts label is missing on the page");
	}
	
	@Test(priority = 2)
	public void selectSingleContactsTest()
	{
		cntcspage.selectContactsByName("TEST1 Automation1");
	}
	
	@Test(priority = 3)
	public void selectMultipleContactsTest()
	{
		cntcspage.selectContactsByName("TEST1 Automation1");
		cntcspage.selectContactsByName("TEST2 Automation2");
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
	    Object data[][] = TestUtil.getTestData(sheetName);
	    return data;
		
	}
	
	
	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) throws InterruptedException
	{
		hmp.moveOnContactsNClickOnNewContact();
		//hmp.clickOnNewContactsLink();
		cntcspage.createNewContact(title, firstName, lastName, company);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
