package com.searce.Perform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Feedback {

	WebDriver driver;
	

	
	
	@FindBy (xpath="//div[@role='listbox']")
	WebElement userEmailID;
	
	public WebElement getuserEmailID()
	{
		return userEmailID;
	}
	 
	
	public void clickuserEmailID()
	{
		userEmailID.click();
	}
	
	
	public Feedback(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (xpath="//i[contains(text(),'add')]")
	WebElement btnAdd;
	
	public WebElement getbtnAdd()
	{
		return btnAdd;
	}
	
	
	public void clickbtnAdd()
	{
		btnAdd.click();
	}
	
	
	@FindBy(xpath="//mat-radio-button[@value='REQUEST']/label/div[1]")
	WebElement radioBtnRequest;
	
	public void clickradioBtnRequest()
	{
		radioBtnRequest.click();
	}

	
	
	
	@FindBy(xpath="//mat-radio-button[@value='GIVE']/label/div[1]")
	WebElement radioBtnGive;
	
	public void clickradioBtnGive()
	{
		radioBtnGive.click();
		
	}
	
	
	@FindBy(name="searchUser")
	WebElement txtFrom;
	
	public void settxtFrom(String email)
	{
		txtFrom.sendKeys(email);
		
	}
	
	
	public WebElement gettxtFrom()
	{
		return txtFrom;
	}
	
	
	
	@FindBy(xpath="//input[@placeholder='Enter feedback title']")
	WebElement txtTitle;
	
	public void settxtTitle(String title)
	{
		txtTitle.sendKeys(title);
		
	}
	
	
	
	
	@FindBy(xpath="//div[text()='Template']/../div[2]/mat-form-field")
	WebElement dropdownTemplate;
	
	public void clickdropdownTemplate()
	{
		dropdownTemplate.click();
	}
	
	public WebElement getdropdownTemplate()
	{
		return dropdownTemplate;
	}
	
	@FindBy(xpath="//span[@class='mat-option-text']")
	WebElement dropdownTemplateOptions;
	
	public WebElement getdropdownTemplateOptions()
	{
		return dropdownTemplateOptions;
	}
	
	@FindBy(xpath="//textarea[@placeholder='Enter brief agenda of feedback']")
	WebElement txtAgenda;
	
	public void settxtAgenda(String agenda)
	{
		txtAgenda.sendKeys(agenda);
	}
	
	
	
	@FindBy(xpath="//span[text()='REQUEST']")
	WebElement btnRequest;
	
	public void clickbtnRequest()
	{
		btnRequest.click();
	}
	
	
	
	
	@FindBy(xpath="//textarea[@placeholder='Enter feedback']")
	WebElement txtFeeback;
	
	public void settxtFeeback(String feedback)
	{
		txtFeeback.sendKeys(feedback);
		
	}
	
	
	
	@FindBy (xpath="//input[@name='anonymousCheck']")
    WebElement checkboxAnonymous; 
	
	public void clickcheckboxAnonymous()
	{
		checkboxAnonymous.click();
	}
		
	
	
	
	@FindBy (xpath="//span[text()='GIVE']")
	WebElement btnGive; 
	
	public void clickbtnGive()
	{
		btnGive.click();
	}
	
	
	
	
	public void clickShowDetails(String agenda)
	{
		driver.findElement(By.xpath("//div[text()='"+agenda+"']/../../div[4]/div/button/span[text()='Show Details']")).click();
	}
	
	
	@FindBy (xpath="//i[text()='close']")
	WebElement btnCloseFeedbackDetails;
	
	public void clickbtnCloseFeedbackDetails()
	{
		btnCloseFeedbackDetails.click();
	}
	
	
	@FindBy(xpath="//textarea[@placeholder='Type your answer here']")
	WebElement txtFeedbackAnswer;
	
	public WebElement gettxtFeedbackAnswer()
	{
		return txtFeedbackAnswer;
	}
	
	public void settxtFeedbackAnswer(String feedbackanswer)
	{
		txtFeedbackAnswer.sendKeys(feedbackanswer);
	}
	
	public String getFeedbackText(String agenda)
	{
	 return	driver.findElement(By.xpath("//div[text()='"+agenda+"']/../../div[1]/div[1]/div/div/span")).getText();
	}
	
	
	
	
	public String getStatus(String agenda)
	{
		String status = driver.findElement(By.xpath("//div[@class='triangle-container ng-star-inserted']/i")).getText();
		return status;
		
	}
	
	
	
	@FindBy (xpath="//span[text()='Decline request']")
	WebElement btnDeclineRequst;
	
	public void clickbtnDeclineRequst()
	{
		btnDeclineRequst.click();
	}

	
	@FindBy (xpath="//span[text()='Give Feedback']")
	WebElement btnGiveFeedback;
	
	public void clickbtnGiveFeedback()
	{
		btnGiveFeedback.click();
	}
	
	
	
	@FindBy (xpath="//textarea[@placeholder='Summarize your review']")
	WebElement txtSummary;
	
	public void settxtSummary(String summary)
	{
		txtSummary.sendKeys(summary);
	}
	
	
	@FindBy (xpath="//span[text()='Submit']")
	WebElement btnSubmit;
	
	public void clickbtnSubmit()
	{
		btnSubmit.click();
		
	}
	
	@FindBy(xpath="//input[@name='reasonText']")
	WebElement txtDecineReason;
	
	public void settxtDecineReason(String reason)
	{
		txtDecineReason.sendKeys(reason);
	}
	
	
	@FindBy (xpath="//span[text()='Decline']")
	WebElement btnDeline;
	
	public void clickbtnDeline()
	{
		btnDeline.click();
	}
	
	
	// After submitting feedback bwlow are the locators
	
	@FindBy (xpath="//div[text()='Feedback Summary ']/following-sibling::div")
	WebElement FeedbackSummary;
	
	public String getFeedbackSummary()
	{
		return FeedbackSummary.getText();
	}
	
	public String getValidationmessage()
	{
		return driver.findElement(By.xpath("//div[text()='You cannot give feedback to yourself']")).getText();
	}
	
	
	@FindBy (xpath="//div[contains(text(),'Agenda 1')]/../../div[1]/div[1]/div/div/span")
	WebElement feedbackText;
	
	public String getfeedbackText()
	{
		return feedbackText.getText();
	}
	
	@FindBy(xpath="//simple-snack-bar/span")
	WebElement tostMessage;
	
	public String gettostMessage() {
		return tostMessage.getText();
	}
	
	
}

