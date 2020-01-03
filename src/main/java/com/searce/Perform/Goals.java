package com.searce.Perform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Goals {

	WebDriver driver;
	
	public Goals(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//div[text()='GOALS']")
	WebElement Goals;
	
	@FindBy (xpath="//div[text()='My OKR']")
	WebElement btnMyOKR;
	
	@FindBy (xpath="//div[text()='Group OKR']")
	WebElement btnGroupOKR;
	
	@FindBy (xpath="//div[text()='Organisation OKR']")
	WebElement btnOrganosationOKR;
	
	@FindBy (xpath="//div[text()='Favourite OKR']")
	WebElement btnFavouriteOKR;
	
	@FindBy (xpath="//div[text()='Shared OKR']")
	WebElement btnSharedOKR;
	
	@FindBy (xpath="//div[text()='Team OKR']")
	WebElement btnTeamOKR;
	
	
	@FindBy (name="cycleSelect")
	WebElement dropdownOKRCycle;
	
	@FindBy(xpath="//i[text()='keyboard_arrow_right']")
	WebElement btnNextCycle;
	
	@FindBy(xpath="//i[text()='keyboard_arrow_left']")
	WebElement btnPreviousCycle;
	
	
	@FindBy (xpath="//div[@class='mat-checkbox-frame']")
	WebElement checkboxWeighage;
	
	
	@FindBy(xpath="//i[contains(text(),'sync')]")
	WebElement btnRefresh;
	
	@FindBy (xpath="//i[text()='add']")
	WebElement btnCreateOKR;
	
	@FindBy(xpath="//i[@aria-label='Create new OKR']")
	WebElement btnCreateNewOKR;
	
	@FindBy(xpath="//i[@aria-label='Create new KPI']")
	WebElement btnCreateNewKPI;
	
	@FindBy (xpath="//i[@aria-label='Copy from reference']")
	WebElement btnCopyFromReference;
	
	@FindBy (name="newObjectiveTitle")
	WebElement txtNewOKRTitle;
	
	@FindBy (id="createOkrObjectiveDescription_txt")
	WebElement newOKRDescription;
	
	
	//this locator can be used for KR of KPI and OKR 
	@FindBy(name="searchTextInput")
	WebElement KRTitle;
	
	@FindBy(xpath="//input[@aria-autocomplete='list']")
	WebElement listUnit;
	
	@FindBy(xpath="//input[starts-with(@id,'krTarget')]")
	WebElement KRTarget;
	
	@FindBy(xpath="//input[starts-with(@id,'krActualCompletion')]")
	WebElement KRProgress;
	
	@FindBy(xpath="//input[starts-with(@id,'krWeightage')]")
	WebElement KRWeightage;
	
	@FindBy(xpath="//textarea[starts-with(@id,'newKeyResultDescription')]")
	WebElement NewKRDescription;
	
	@FindBy(xpath="//span[text()='ADD KEY RESULT']")
	WebElement btnAddKeyResult;
	
	
	@FindBy(xpath="//span[contains(text(),'Dismiss ')]")
	WebElement btnDismiss;
	
	@FindBy (xpath="//span[text()='Done']")
	WebElement btnDone;
	
	@FindBy (xpath="//span[text()='ADD KPI']")
	WebElement btnAddKPI;
	
	@FindBy (xpath="//span[text()='Send for approval']")
	WebElement btnSendForApproval;
 
	@FindBy(xpath="//i[text()='star_border']")
	WebElement btnFavoutite;
	
	@FindBy(xpath="//mat-icon[@title='Comment']")
	WebElement btnComment;
	
	@FindBy(xpath="//textarea[@id='commentArea']")
	WebElement txtComment;
	
	@FindBy(xpath="//button[@aria-label='Options']")
	WebElement btnAction;
	
	@FindBy(xpath="//div[@class='mat-menu-content']")
	WebElement dropdownAction;
	
	
	// Circel progress 
	//div[text()='Key Performance Indicator']/../../../div[2]/div/circle-progress/*[name()='svg']/*[5]/*
	
	//Copy From Referance Window
	@FindBy(xpath="//copy-okr-from-reference")
	WebElement copyFromReferenceWindow;
	
	@FindBy(xpath="//div[text()='OKR Template']")
	WebElement btnOKRTemplate;
	
	@FindBy(xpath="//div[text()='Objectives']")
	WebElement btnObjectives;
	
	@FindBy(xpath="//input[@name='searchbarInput' and @placeholder='Search designation']")
	WebElement txtSearchDesignation;
	
	@FindBy(xpath="//i[text()='keyboard_arrow_down']")
	WebElement btnExpand;
	
	@FindBy (className="mat-checkbox-inner-container.mat-checkbox-inner-container-no-side-margin")
    WebElement checkboxKR;

	@FindBy (xpath="//span[text()='Next']")
	WebElement btnNext;
	
	@FindBy(xpath="//span[text()='Check OKR status']")
	WebElement btnCheckOKRStatus;
	
	@FindBy(xpath="//span[text()='Apply']")
	WebElement btnApply;

	
	

	
}
