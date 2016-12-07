package com.ebay.tests;

import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.testng.support.SAssert;

import org.testng.annotations.Test;

import com.ebay.webpages.PageObjectFactory;

public class RemoveFromCartTest {

	SAssert sAssert= new SAssert();
	
	@Test (dataProvider="XmlData")
	public void verifyRemovingFromCart(IBrowserConf browserConf, IProperty prop)
	{
		PageObjectFactory prof=new PageObjectFactory(browserConf,prop);
		
		sAssert.assertTrue(prof.homePage().loadUrl(prop.getValue("HomePage_url")),"Access URL"+prop.getValue("HomePage_url"));
		sAssert.assertTrue(prof.homePage().searchProduct(prop.getValue("HomePage_productname")), "Search Product");
		sAssert.assertTrue(prof.resultPage().clickOnFirstProduct(), "Click on first product");
		sAssert.assertTrue(prof.prodDetailsPage().clickAddToCart(), "Click Add to cart");
		sAssert.assertTrue(prof.cartPage().removeFromCart(),"Remove from cart");
	}

}
