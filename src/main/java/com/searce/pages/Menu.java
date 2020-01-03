package com.searce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

	
	
	WebDriver driver;
	
	@FindBy(xpath="//mat-icon[text()='menu']")
	public WebElement btnMenu;
	
	@FindBy(xpath="//span[text()='Perform ']")
	public WebElement btnPerform;
	
	public WebElement  getbtnPerform()
	{
		return btnPerform;
	}
	
	public void clickbtnPerform()
	{
		btnPerform.click();
	}
	
	
	
	@FindBy(xpath="(//img[@oncontextmenu='return false'])[2]")
	public WebElement btnProfilePhoto;
	
	@FindBy (xpath="//div[text()='Admin Section']")
	public WebElement btnAdminSection;
	
	@FindBy (xpath="//div[text()='User Section']")
	public WebElement btnUserSection;
	
	@FindBy (xpath="//div[text()='Log Out']")
	public WebElement BtnLogout;
	
	public Menu(WebDriver driver)
	{
		this.driver=driver;
        PageFactory.initElements(driver,this);
	}
	
	public void clickbtnMenu()
	{
		btnMenu.click();
	}
	
	public void clickbtnProfilePhoto()
	{
		btnProfilePhoto.click();
	}
	
	public void clickbtnAdminSection()
	{
		btnAdminSection.click();
	}
	
	public void btnUserSection()
	{
		btnUserSection.click();
	}
	
	
public void clickBtnLogout()
{
	BtnLogout.click();
	}

	@FindBy (xpath="//div[text()='360° FEEDBACK']")
	public WebElement Feedback;
	
	public WebElement getFeedback()
	{
		return Feedback;
	}
	
	public void clickFeedback()
	{
		Feedback.click();
	}

	
	@FindBy (xpath="//div[text()='GOALS']")
	WebElement Goals;
	
	public void clickGoals()
	{
		Goals.click();
	}
	
	
	@FindBy (xpath="//div[text()='PORTFOLIO']")
	public WebElement Portfolio;
	
	public void clickPortfolio()
	{
		Portfolio.click();
	}
	
	@FindBy (xpath="//div[text()='PEP TALKS']")
	public  WebElement PepTalks;
	
	public void clickPepTalks()
	{
		PepTalks.click();
	}

	
	
	@FindBy (xpath="//div[text()='COMPETENCY']")
	public WebElement Competency;
	
	public void clickCompetency()
	{
		Competency.click();
	}
	
	
	@FindBy (xpath="//div[text()='APPRAISALS']")
	public WebElement Appraisals;
	
	public void clickAppraisals()
	{
		Appraisals.click();
	}

	@FindBy (xpath="//div[text()='CAREER PATH']")
	public WebElement CareerPath;
	
	public void clickCareerPath()
	{
		CareerPath.click();
	}


	
}
