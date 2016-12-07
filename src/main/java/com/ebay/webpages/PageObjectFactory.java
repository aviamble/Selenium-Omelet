package com.ebay.webpages;

import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.driver.Driver;

import org.openqa.selenium.WebDriver;

public class PageObjectFactory {

	private WebDriver driver;
	
	HomePage homePage;
	ResultsPage resultPage;
	LoginPage loginPage;
	ProductDetailsPage prodDetailsPage;
	CartPage cartPage;

	private IProperty prop;
	
	public PageObjectFactory(IBrowserConf browserConf, IProperty prop)
	{
		this.driver=Driver.getDriver(browserConf);
		this.prop=prop;
	}
	
	public HomePage homePage()
	{
		if(homePage==null)
		homePage=new HomePage(driver);
		return homePage;
	}
	
	public ResultsPage resultPage()
	{
		if(resultPage==null)
			resultPage=new ResultsPage(driver);
		return resultPage;
	}
	
	public CartPage cartPage()
	{
		if(cartPage==null)
			cartPage=new CartPage(driver);
		return cartPage;
	}
	
	public LoginPage loginPage()
	{
		if(loginPage==null)
			loginPage=new LoginPage(driver);
		return loginPage;
	}
	
	public ProductDetailsPage prodDetailsPage()
	{
		if(prodDetailsPage==null)
			prodDetailsPage=new ProductDetailsPage(driver);
		return prodDetailsPage;
	}
}
