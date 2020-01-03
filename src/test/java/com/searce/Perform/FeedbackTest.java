package com.searce.Perform;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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


public class FeedbackTest {
	
	WebDriver driver  = Driver.getDriver(Driver.DriverTypes.CHROME);
	ExtentReports extent ;
	WebDriverWait wait=  new  WebDriverWait(driver,30);
	ResourceBundle rb ;
	
	@BeforeClass
	public void loginTest()
	{
		
		PepTalks p = new PepTalks(driver);
		
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
	
	
	// Request Feedback
	// Decline feedback
	//pendig , completed , declined feedback filters
	// user
	//ascending , decending
	//anynomis feedback
	
	@Test(dataProvider="giveFeedbackDataProvider", enabled=false)
	public void giveFeedback(String email,String title,String template,String agenda, String feedback) throws InterruptedException
	{
		SoftAssert softassert = new SoftAssert();
		String expectedStatus="done";
	 Menu menu = new Menu(driver);	
	 Feedback feedbackObj = new Feedback(driver);
	 menu.clickbtnMenu();
	 wait.until(ExpectedConditions.visibilityOf(menu.getbtnPerform()));
	 menu.clickbtnPerform();
	 wait.until(ExpectedConditions.visibilityOf(menu.getFeedback()));
	 menu.clickFeedback();
	 wait.until(ExpectedConditions.visibilityOf(feedbackObj.getbtnAdd()));
	 feedbackObj.clickbtnAdd();
	 Thread.sleep(5000);
	 feedbackObj.clickradioBtnGive();
	 Thread.sleep(3000);
	 feedbackObj.settxtFrom(email);
	 wait.until(ExpectedConditions.visibilityOf(feedbackObj.getuserEmailID() ));
	 feedbackObj.clickuserEmailID();
	 
	 feedbackObj.settxtTitle(title);
	 feedbackObj.settxtAgenda(agenda);
	 feedbackObj.settxtFeeback(feedback);
	 Thread.sleep(2000);
	 
	 driver.findElement(By.xpath("//span[text()='Select template']")).click();
	 
Thread.sleep(3000);
	List <WebElement> options  = driver.findElements(By.xpath("//span[@class='mat-option-text']"));	 


	 for(WebElement option : options)
		 {
			 if(option.getText().equals(template))
			 {
				 option.click();
				 break;
			 }
			 
		 }

Thread.sleep(4000);
	 List <WebElement> textbox = driver.findElements(By.xpath("//textarea[@placeholder='Type your answer here']"));
	 for(WebElement text: textbox)
	 {
		 text.sendKeys(feedback);
		 
	 }
	 
	 feedbackObj.clickbtnGive();
	 Thread.sleep(10000);

	 // validate status
	 String actualStatus = feedbackObj.getStatus(agenda);
	 
	 feedbackObj.clickShowDetails(agenda);
	 Thread.sleep(4000);
	 // validate feedback summary 
	 String actualFeedbackSummary = feedbackObj.getFeedbackSummary();
	 
	 
	 // To verify status of feedback
	 softassert.assertEquals(actualStatus, expectedStatus);
	 softassert.assertEquals(actualFeedbackSummary, feedback);
	 softassert.assertAll();
	 
	
	 feedbackObj.clickbtnCloseFeedbackDetails();
	 
	}
	
	
	@Test(dataProvider="giveFeedbackDataProvider", enabled=true)
	public void giveAnonymousFeedback(String email,String title,String template,String agenda, String feedback) throws InterruptedException
	{
		SoftAssert softassert  = new SoftAssert();
		Menu menu  = new Menu(driver);
		Feedback feedbackObj = new Feedback(driver);
		
		menu.clickbtnMenu();
		wait.until(ExpectedConditions.visibilityOf(menu.getbtnPerform()));
		menu.clickbtnPerform();
		 wait.until(ExpectedConditions.visibilityOf(menu.getFeedback()));
		 menu.clickFeedback();
		 wait.until(ExpectedConditions.visibilityOf(feedbackObj.getbtnAdd()));
		 feedbackObj.clickbtnAdd();
		 Thread.sleep(5000);
		 feedbackObj.clickradioBtnGive();
		 Thread.sleep(3000);
		 
		 wait.until(ExpectedConditions.elementToBeClickable(feedbackObj.checkboxAnonymous));
		 Actions actions = new Actions(driver);
		 actions.moveToElement( feedbackObj.checkboxAnonymous).click().build().perform();
		 
		 feedbackObj.settxtFrom(email);
		 wait.until(ExpectedConditions.visibilityOf(feedbackObj.getuserEmailID() ));
		 feedbackObj.clickuserEmailID();
		 feedbackObj.settxtTitle(title);
		 feedbackObj.settxtAgenda(agenda);
		 feedbackObj.settxtFeeback(feedback); 
		 driver.findElement(By.xpath("//span[text()='Select template']")).click();
		 
		 Thread.sleep(3000);
		 	List <WebElement> options  = driver.findElements(By.xpath("//span[@class='mat-option-text']"));	 


		 	 for(WebElement option : options)
		 		 {
		 			 if(option.getText().equals(template))
		 			 {
		 				 option.click();
		 				 break;
		 			 }
		 			 
		 		 }

		 Thread.sleep(4000);
		 	 List <WebElement> textbox = driver.findElements(By.xpath("//textarea[@placeholder='Type your answer here']"));
		 	 for(WebElement text: textbox)
		 	 {
		 		 text.sendKeys(feedback);
		 		 
		 	 }

		 	feedbackObj.clickbtnGive();

	}
	
	
	
	
	@DataProvider
	public Object[][] giveFeedbackDataProvider() throws Exception
	{
		return GetDataFromExcel.getData("/Users/avdhoot.kulkarni/eclipse-workspace/Perform/data/Feedback.xlsx", "giveFeedback");
	}
	
	@Test(enabled=false)
	public void giveFeedbackValidation() throws InterruptedException
	{
		SoftAssert softassert = new SoftAssert();
		String expectedValidationMessage="You cannot give feedback to yourself";
		Feedback feedbackObj = new Feedback(driver);
		
		
		Menu menu = new Menu(driver);	
		
		 menu.clickbtnMenu();
		 wait.until(ExpectedConditions.visibilityOf(menu.getbtnPerform()));
		 menu.clickbtnPerform();
		 wait.until(ExpectedConditions.visibilityOf(menu.getFeedback()));
		 menu.clickFeedback();
		 wait.until(ExpectedConditions.visibilityOf(feedbackObj.getbtnAdd()));
		 feedbackObj.clickbtnAdd();
		Thread.sleep(4000);
		feedbackObj.clickradioBtnGive();
		wait.until( ExpectedConditions.visibilityOf(feedbackObj.gettxtFrom()));
		feedbackObj.settxtFrom(rb.getString("NonAdminUser1EmailID"));
		wait.until(ExpectedConditions.visibilityOf(feedbackObj.getuserEmailID()));
		feedbackObj.clickuserEmailID();
		String actualValidationMessage = feedbackObj.getValidationmessage();
		
		softassert.assertEquals(actualValidationMessage, expectedValidationMessage);
		softassert.assertAll();

		
	}

	@Test(enabled=false)
	public void requestFeedbackValidation() throws InterruptedException
	{
		SoftAssert softassert = new SoftAssert();
		String expectedValidationMessage="You cannot request feedback from yourself";
		Feedback feedbackObj = new Feedback(driver);
		
		
		Menu menu = new Menu(driver);	
		
		 menu.clickbtnMenu();
		 wait.until(ExpectedConditions.visibilityOf(menu.getbtnPerform()));
		 menu.clickbtnPerform();
		 wait.until(ExpectedConditions.visibilityOf(menu.getFeedback()));
		 menu.clickFeedback();
		 wait.until(ExpectedConditions.visibilityOf(feedbackObj.getbtnAdd()));
		 feedbackObj.clickbtnAdd();
		Thread.sleep(4000);
		feedbackObj.clickradioBtnRequest();
		
		wait.until( ExpectedConditions.visibilityOf(feedbackObj.gettxtFrom()));
		feedbackObj.settxtFrom(rb.getString("NonAdminUser1EmailID"));
		wait.until(ExpectedConditions.visibilityOf(feedbackObj.getuserEmailID()));
		feedbackObj.clickuserEmailID();
		String actualValidationMessage = driver.findElement(By.xpath("//div[text()='You cannot request feedback from yourself']")).getText();
		softassert.assertEquals(actualValidationMessage, expectedValidationMessage);
		softassert.assertAll();
		
		
	}
	
	@Test(enabled=false)
	public void declineFeedback() throws InterruptedException
	{
		SoftAssert softassert  = new SoftAssert();
		Feedback feedbackObj = new Feedback(driver);
		Menu menu = new Menu(driver);
		String expectedDeclinedFeedbackText="You declined feedback request of";
		
			
		
		 menu.clickbtnMenu();
		 wait.until(ExpectedConditions.visibilityOf(menu.getbtnPerform()));
		 menu.clickbtnPerform();
		 wait.until(ExpectedConditions.visibilityOf(menu.getFeedback()));
		 menu.clickFeedback();
		 wait.until(ExpectedConditions.visibilityOf(feedbackObj.getbtnAdd()));
		 feedbackObj.clickbtnAdd();
		
		Thread.sleep(4000);
		
		feedbackObj.settxtFrom(rb.getString("NonAdminUser2EmailID"));
		wait.until(ExpectedConditions.visibilityOf(feedbackObj.getuserEmailID()));
		feedbackObj.clickuserEmailID();
		feedbackObj.settxtTitle("Demo title 1");
		feedbackObj.settxtAgenda("Agenda 1");
		
		
		// Select feedback temlate
		driver.findElement(By.xpath("//span[text()='Select template']")).click();
		 
		Thread.sleep(3000);
			List <WebElement> options  = driver.findElements(By.xpath("//span[@class='mat-option-text']"));	 


			 for(WebElement option : options)
				 {
					 if(option.getText().equals("Automation Feedback Template"))
					 {
						 option.click();
						 break;
					 }
					 
				 }

			 
			 feedbackObj.clickbtnRequest();
			 Thread.sleep(2000);
			 String  submitRequestMessage = feedbackObj.gettostMessage();
			 System.out.println(submitRequestMessage);
			 
			 Thread.sleep(3000);
			 menu.clickbtnProfilePhoto();
			 Thread.sleep(3000);
			 menu.clickBtnLogout();
			 Thread.sleep(4000);
			 driver.findElement(By.xpath("//div[text()='Use another account']")).click();
			 Thread.sleep(4000);
			 Login login = new Login(driver);
				login.settxtEmail(rb.getString("NonAdminUser2EmailID"));
				login.clickbtnNext();
				wait.until(ExpectedConditions.visibilityOf(login.getNextBtn()));
				login.settxtPassword(rb.getString("NonAdminUser2Password"));
				login.clickbtnNext();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				menu.clickbtnMenu();
				 wait.until(ExpectedConditions.visibilityOf(menu.getbtnPerform()));
				 menu.clickbtnPerform();
				 wait.until(ExpectedConditions.visibilityOf(menu.getFeedback()));
				 menu.clickFeedback();
				 Thread.sleep(4000);
				 feedbackObj.clickbtnDeclineRequst();
				 feedbackObj.settxtDecineReason("Declined Reason");
		
				 feedbackObj.clickbtnDeline();
				 
				 String actualDeclinedFeedbackText= feedbackObj.getfeedbackText();
				 softassert.assertEquals(actualDeclinedFeedbackText, expectedDeclinedFeedbackText);
				 
				 
	}
	
	
	
	
	

}
