package com.searce.Perform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PepTalks {
	
	WebDriver driver;
	
	public PepTalks(WebDriver driver)
	{
		this.driver=driver;
        PageFactory.initElements(driver,this);
	}
	
	
	@FindBy (xpath="//div[@role='listbox']")
	public WebElement userEmailID;
	
	@FindBy(xpath="//div[text()='PEP TALKS']")
	public WebElement PepTalksBtn;
	
	@FindBy(xpath="//i[text()='add ']")
	public WebElement addBtn;
	
	
	@FindBy (xpath="//mat-select[@name='appliedFilterSelect']")
	public WebElement FilterBydd;
	
	@FindBy(xpath="(//div[@class='mat-select-value'])[2]")
	public WebElement Sort_By_Last_Update_DD;
	
	@FindBy(xpath="//input[@placeholder='Select reviewer']")
	public WebElement select_reviewer;
	
	@FindBy(xpath="//input[@placeholder='Enter review title']")
	public WebElement enterReviweTitle;
	
	@FindBy(xpath="//div[text()='Template']/../div[2]/mat-form-field")
	public WebElement dropdownTemplate;
	

	
	public WebElement getdropdownTemplate()
	{
		return dropdownTemplate;
	}
	
	@FindBy(xpath="//*[@placeholder='Enter brief agenda of review']")
	public WebElement agenda;
	
	

	@FindBy(xpath="//input[@placeholder='Enter meeting place']")
	public WebElement meetingPlace;
	
	
	@FindBy (xpath="(//td[@class='fc-widget-content'])[1]")
	public WebElement calender;
	
	
	
	@FindBy(xpath="(//button[@aria-label='Open calendar'])[1]")
	public WebElement startDate;
	
	
	@FindBy(xpath="(//button[@aria-label='Open calendar'])[2]")
	public WebElement endDate;
	
	@FindBy(xpath="(//*[@placeholder='HH'])[1]")
	public WebElement startHH;
	
	@FindBy(xpath="(//*[@placeholder='MM'])[1]")
	public WebElement startMM;
	
	
	@FindBy(xpath="(//*[@placeholder='HH'])[2]")
	public WebElement endHH;
	
	@FindBy(xpath="(//*[@placeholder='MM'])[2]")
	public WebElement endMM;
	
	
	@FindBy(xpath="//span[text()='Add']")
	public WebElement SelectTimeBtn;

	public void SelectDate(WebElement calender,String year, String month, String dd) throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@aria-label='Choose month and year']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='"+year+"']")).click();
		Thread.sleep(1000);
		month.toUpperCase();
		driver.findElement(By.xpath("//div[text()='"+month+"']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='"+dd+"']")).click();
		Thread.sleep(1000);	
		
	}
	
	@FindBy(xpath="//span[text()='REQUEST']")
	public WebElement requestBtn;
	
	

	@FindBy(xpath="//span[text()='Reschedule']")
	public WebElement rescheduleBtn;
	
	
	
	@FindBy(xpath="//span[text()='Give Feedback']")
	public WebElement giveFeedbackBtn;
	
	public void clickgiveFeedbackBtn()
	{
		giveFeedbackBtn.click();
	}
	
	@FindBy(xpath="//div[text()='Back']")
	public WebElement backBtn;
	
	
	
	@FindBy(xpath="//div[text()='Feedback form ']")
	public WebElement feedbackForm;
	
	@FindBy(xpath="//*[@ng-reflect-name='feedbackSummaryInput']")
	public WebElement summarytxt;
	
	
	
	@FindBy(xpath="//span[text()='Submit']")
	public WebElement submitBtn;
	
	@FindBy(xpath="//span[text()='Show Details']")
	public WebElement showDetailsBtn;

	@FindBy(xpath="//input[@placeholder='Select user']")
	public WebElement SelectUser;
	
	@FindBy(xpath="//div[text()='Given on']/following-sibling::hwlibs-date-time-conversion")
	public WebElement FeedbackGiveOn;
	
	
	
}
