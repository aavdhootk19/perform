package com.searce.Perform;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;
import com.searce.pages.Login;
import com.searce.utilities.Driver;

public class GoalsTest {
	
	WebDriver driver  = Driver.getDriver(Driver.DriverTypes.CHROME);
	ExtentReports extent ;
	WebDriverWait wait=  new  WebDriverWait(driver,30);
	ResourceBundle rb ;
	
	@BeforeClass
	public void loginTest()
	{
		extent  = new ExtentReports("Report/report.html",true, NetworkMode.OFFLINE);
		
		 rb =ResourceBundle.getBundle("perform");
		String url = rb.getString("url");
		driver.get(url);
		
		Login login = new Login(driver);
		login.settxtEmail(rb.getString("NonAdminUser1EmailID"));
		
	   wait.until(ExpectedConditions.visibilityOf(login.getNextBtn()));
		login.settxtPassword(rb.getString("NonAdminUser1Password"));
		login.clickbtnNext();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	
	@AfterClass
	public void teardown()
	{
		driver.close();
		driver.quit();
		}
	

}
