package com.ebay.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	WebDriver driver;

	@FindBy(id = "gh-ac")
	public WebElement searchBox;
	@FindBy(id = "gh-btn")
	public WebElement searchButton;
	@FindBy(xpath = "//select")
	WebElement dropDown;
	@FindBy(linkText = "Sign in")
	WebElement signInLink;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean loadUrl(String url) {
	
		driver.get(url);
		return true;
	}

	public boolean searchProduct(String value) {
		searchBox.sendKeys(value);
		searchButton.click();
		return true;
	}

	public boolean selectCategory(String category) {
		Select options = new Select(dropDown);
		options.selectByVisibleText(category);
		return true;
	}

	public boolean clickOnSignIn() {
		signInLink.click();
		return true;
	}
}
