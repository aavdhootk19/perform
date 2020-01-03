package com.searce.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	
	WebDriver driver;
	
	@FindBy(id="identifierId")
	WebElement txtEmail;
	
	@FindBy(xpath="//span[(text()='Next')]")
	WebElement btnNext;
	
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	public void settxtEmail(String email)
	{
		txtEmail.sendKeys(email,Keys.ENTER);
	}
	
	
	public void settxtPassword(String password)
	{
		txtPassword.sendKeys(password,Keys.ENTER);
	}
	
	public void clickbtnNext()
	{
		btnNext.click();
		
	}
	
	public WebElement getNextBtn()
	{
		return btnNext;
	}
	
	
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
        PageFactory.initElements(driver,this);
	}
	
	
}
