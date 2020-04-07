package com.hrm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.DashboardPage;
import com.hrm.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage ;
	DashboardPage dashboardPage ;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() throws InterruptedException{
    	String title = loginPage.validateLoginPageTitle();
    	Assert.assertEquals(title, "OrangeHRM");
    	Thread.sleep(1000);
        System.out.println(title);
    }

    @Test(priority = 2)
    public void hrmLogotest() throws InterruptedException{
    	boolean flag = loginPage.validateHRMImage();
    	Thread.sleep(1000);
    	Assert.assertTrue(flag);
    }
    
    @Test(priority = 3)
    public void loginTest() throws InterruptedException {
    	dashboardPage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        Thread.sleep(1000);
        }
    
    @Test(priority = 4)
    public void forgotPasswordLinkTest() throws InterruptedException {
        Thread.sleep(1000);
        loginPage.validateForgotPassswordLink();
        Thread.sleep(1000);
        String url = driver.getCurrentUrl();
        Thread.sleep(1000);
        Assert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode");
        System.out.println(url);
    }
    
    @AfterMethod
    public void tearDown(){
    	driver.quit();
    }

}
