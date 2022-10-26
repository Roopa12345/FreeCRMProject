package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage lp;
	HomePage hmp;
	TestUtil tup;
	ContactsPage cntcspage;
	
	public HomePageTest()
	{
		super();
	}
	
	//Test Cases should be separated -- independent with each other
	//Before each test case -- launch the browser and login
	//@Test -- Execute the test case
	//After each test case -- Close the browser
	@BeforeMethod
	public void setUp()
	{
		initialization();
		tup = new TestUtil();
		cntcspage = new ContactsPage();
		 lp = new LoginPage();
		 hmp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHOmePageTitleTest()
	{
		String homePageTitle = hmp.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home Page title not matched");
	}
	
	@Test(priority = 2)
	public void verifyUserNameTest()
	{
		tup.switchToFrame();
		Assert.assertTrue(hmp.verifyCorrectUserName());
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest()
	{
		tup.switchToFrame();
		cntcspage = hmp.clickOnContactsLink();
	}
	

	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
