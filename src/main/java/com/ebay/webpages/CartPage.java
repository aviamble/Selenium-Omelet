package com.ebay.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {

	WebDriver driver;
	
	@FindBy(xpath="//div[@id='sc_usr_action']/div")
	WebElement cartAddText;
	@FindBy(xpath="//i[@id='gh-cart-n']")
	WebElement cartCount;
	@FindBy(xpath="//i[@id='gh-cart-i']")
	WebElement cart;
	@FindBy(xpath="//div[@class='xo-itm-remv']")
	WebElement removeLink;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);		
	}
	public boolean verifyProductInCart()
	{
		String text=cartAddText.getText();
		Assert.assertTrue(text.contains("was just added to your cart"),"Product is added in the cart");
		return true;
	}
	
	public boolean verifyCartCount()
	{
		int count=Integer.parseInt(cartCount.getText());
		System.out.println("There are " +count+" products in cart.");
		return true;
	}
	
	public boolean removeFromCart()
	{
		cart.click();
		if(removeLink.isDisplayed())
		{
			removeLink.click();
		}
		else
		{
			System.out.println("Cart is empty.");
		}
		return true;
	}
}
