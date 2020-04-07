package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.AdminPage;
import com.hrm.qa.pages.DashboardPage;
import com.hrm.qa.pages.LoginPage;

public class DashboardPageTest extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	AdminPage adminPage;

	public DashboardPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		Thread.sleep(2000);
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.navigate().refresh();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void validateHomePageTitleTest() {
		String dashboardPageTitle = dashboardPage.dashboardPageTitle();
		Assert.assertEquals(dashboardPageTitle, "OrangeHRM");
	}

	@Test(priority = 2)
	public void validateUsernameTest() {
		Assert.assertTrue(dashboardPage.validateUsername());
	}

	@Test(priority = 3)
	public void validatedashboardDiagramTest() {
		Assert.assertTrue(dashboardPage.validateDashboardDiagram());
	}

	@Test (priority = 4)
	    public void validateAdminLinkTest (){
	        
		 adminPage =  dashboardPage.clickOnAdminLink();
	    }

	@AfterMethod
    public void tearDown (){
       driver.quit();
    }
}
