package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;
public class DashboardPage extends TestBase
{
	@FindBy (id = "welcome")
    WebElement userNameLabel ;

	@FindBy (id = "menu_admin_viewAdminModule")
    WebElement adminLink ;
	
	@FindBy (id = "menu_pim_viewPimModule")
    WebElement pimLink ;
	
	@FindBy (id = "menu_leave_viewLeaveModule")
    WebElement leaveLink ;
	
	@FindBy (id = "menu_time_viewTimeModule")
    WebElement timeLink ;
	
	@FindBy (id = "menu_recruitment_viewRecruitmentModule")
    WebElement recruitmentLink ;
	
	@FindBy (id = "menu__Performance")
    WebElement performanceLink ;
	
	@FindBy (id = "menu_directory_viewDirectory")
    WebElement directoryLink ;
	
	@FindBy (id = "menu_maintenance_purgeEmployee")
    WebElement maintenanceLink ;
    
    @FindBy (id = "dashboard__employeeDistribution")
    WebElement dashboardDiagram;
	
	public DashboardPage(){
        PageFactory.initElements(driver,this);
    }


    public String dashboardPageTitle(){
        return driver.getTitle();
    }

    public boolean validateUsername () {
        return userNameLabel.isDisplayed();
    }

    public boolean validateDashboardDiagram () {
        return dashboardDiagram.isDisplayed();
    }

    public AdminPage clickOnAdminLink (){
    	adminLink.click();
        return new AdminPage();
    }

    public PimPage clickOnDealsLink (){
        pimLink.click();
        return new PimPage() ;
    }

    public LeavePage clickOnTaskLink (){
        leaveLink.click();
        return new LeavePage();
    }

    public TimePage clickOnDocsLink(){
        timeLink.click();
        return new TimePage() ;
    }

    public RecruitmentPage clickOnCompanyLink(){
        recruitmentLink.click();
        return new RecruitmentPage();
    }

    public PerformancePage clickOnCalendarLink(){
        performanceLink.click();
        return new PerformancePage() ;
    }

    public DirectoryPage clickOnReportsLink(){
        directoryLink.click();
        return new DirectoryPage();
    }

    public MaintenacePage clickOnFormsLink(){
        maintenanceLink.click();
        return new MaintenacePage();
    }


	}
