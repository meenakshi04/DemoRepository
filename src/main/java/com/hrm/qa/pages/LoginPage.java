package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	 @FindBy (id = "txtUsername")
	    WebElement username ;
	 
	 @FindBy (id = "txtPassword")
	    WebElement password ;
	 
	 @FindBy (id = "btnLogin")
	    WebElement loginButton;
	 
	 @FindBy (id = "divLogo")
	    WebElement hrmLogo;
	 
	 @FindBy (partialLinkText = "Forgot your password?")
	    WebElement forgotPasswordLink ;


	// Initializing page objects:

	    public LoginPage(){
	        PageFactory.initElements(driver,this);
	    }

	// Actions

	    public String validateLoginPageTitle (){
	        return driver.getTitle();
	    }

	    public boolean validateHRMImage(){
	        return hrmLogo.isDisplayed();
	    }

	    public DashboardPage login(String un , String pwd) throws InterruptedException {
	        username.sendKeys(un);
	        Thread.sleep(1000);
	        password.sendKeys(pwd);
	        Thread.sleep(1000);
	        loginButton.click();
	        return new DashboardPage();
	    }

	    public void validateForgotPassswordLink (){
	        forgotPasswordLink.click();
	    }


}
