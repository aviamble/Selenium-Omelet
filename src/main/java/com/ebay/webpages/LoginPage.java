package com.ebay.webpages;

import omelet.common.ExpectedConditionExtended;
import omelet.driver.DriverUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage{

	WebDriver driver;
	@FindBy(xpath="//input[@placeholder='Email or username'][@class='fld']")
	WebElement userNametxtBox;
	@FindBy(xpath="//input[@placeholder='Password'][@class='fld']")
	WebElement pswordtxtBox;
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	@FindBy(xpath="//span[@class='sd-err']")
	WebElement errorMessage;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public boolean loginAs(String username, String password)
	{
		userNametxtBox.sendKeys(username);
		pswordtxtBox.sendKeys(password);
		loginButton.click();
		return true;
	}
	public String getErrorMessage()
	{
		return errorMessage.getText();	
	}
	

	public boolean verifyLogin2()
	{
		//return errorMessage.getText();	
		if(DriverUtility.waitFor(ExpectedConditionExtended.elementToBeDisabled(errorMessage), driver, 5)!=null){
			return true;
		}else if(DriverUtility.waitFor(ExpectedConditionExtended.elementToBeDisabled(errorMessage), driver, 5)!=null){
			return true;
		}else return false;
	}
}
