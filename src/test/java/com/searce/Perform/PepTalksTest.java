package com.searce.Perform;

import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;
import com.searce.pages.Login;
import com.searce.pages.Menu;
import com.searce.utilities.Driver;
import com.searce.utilities.GetDataFromExcel;

public class PepTalksTest {

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
	//	login.clickbtnNext();
		driver.findElement(By.xpath("//span[text()='Next' and @class='RveJvd snByac']"));
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	
	@AfterClass
	public void teardown()
	{
		driver.close();
		driver.quit();
		}
	
	
	@Test(dataProvider="schedulePepTalksDataProvider", enabled=true)
	public void schedulePepTalks(String email, String title, String template, String agenda,String year,String month,String date,String startHH,String startMM, String endHH, String endMM) throws InterruptedException
	{
		SoftAssert softassert = new SoftAssert();
		String expectedStatus="done";
	 Menu menu = new Menu(driver);
	 PepTalks peptalks = new PepTalks(driver);
	 //wait.until(ExpectedConditions.elementToBeClickable(menu.btnMenu));
	 
	 JavascriptExecutor executor = (JavascriptExecutor)driver;
	 executor.executeScript("arguments[0].click();", menu.btnMenu );


	 
	// menu.btnMenu.click();
	 wait.until(ExpectedConditions.visibilityOf(menu.getbtnPerform()));
	 menu.clickbtnPerform();
	 wait.until(ExpectedConditions.visibilityOf( peptalks.PepTalksBtn));
	 peptalks.PepTalksBtn.click();
	 wait.until(ExpectedConditions.visibilityOf(peptalks.addBtn));
	 peptalks.addBtn.click();
	// wait.until(ExpectedConditions.visibilityOf(peptalks.select_reviewer));
	 
	 Thread.sleep(3000);
	 peptalks.select_reviewer.sendKeys(email);
	 wait.until(ExpectedConditions.elementToBeClickable(peptalks.userEmailID));
	 peptalks.userEmailID.click();
	 peptalks.enterReviweTitle.sendKeys(title);
	 peptalks.dropdownTemplate.click();
	 wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//*[@class='mat-option-text']"))));
	 List<WebElement> list = driver.findElements(By.xpath("//*[@class='mat-option-text']"));
	 for(WebElement temp: list  )
	 {
		if( temp.getText().equalsIgnoreCase(template))
		{
			temp.click();
			break;
		}
		 

	 }

	 peptalks.agenda.sendKeys(agenda);
	 peptalks.calender.click();
	 wait.until(ExpectedConditions.visibilityOf(peptalks.startDate ));
	 
	 try {
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Choose month and year']"))) ;
		Driver.SelectDate(peptalks.startDate,year, month,date);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 try {
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Choose month and year']"))) ;
		 Driver.SelectDate(peptalks.endDate , year, month,date);
	 }catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	 peptalks.startHH.click();
	 peptalks.startHH.clear();
	 peptalks.startHH.sendKeys(startHH);
	 
	 peptalks.startMM.click();
	 peptalks.startMM.clear();
	 peptalks.startMM.sendKeys(startMM);
		
	 peptalks.endHH.click();
	 peptalks.endMM.clear();
	 peptalks.endHH.sendKeys(endHH);
	 
	 peptalks.endMM.click();
	 peptalks.endMM.clear();
	 peptalks.endMM.sendKeys(endMM);
	 
	 peptalks.SelectTimeBtn.click();
	 wait.until(ExpectedConditions.elementToBeClickable(peptalks.requestBtn));
	 peptalks.requestBtn.click();
		
		
		
	}
	
	@DataProvider
	public Object[][] schedulePepTalksDataProvider() throws Exception
	{
		return GetDataFromExcel.getData(System.getProperty("user.dir")+"/data/PepTalks.xlsx", "schedulePepTalks");
	}
	
	
	
	
}
