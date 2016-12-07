package com.ebay.tests;

import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.testng.support.SAssert;

import org.testng.annotations.Test;
import com.ebay.webpages.PageObjectFactory;

public class CartCountTest{
	
	@Test(dataProvider="XmlData")
	public void verifyCartCount(IBrowserConf browserConf, IProperty prop)
	{
		PageObjectFactory prof=new PageObjectFactory(browserConf,prop);
		SAssert sAssert= new SAssert();
		sAssert.assertTrue(prof.homePage().loadUrl(prop.getValue("HomePage_url")),"Access URL"+prop.getValue("HomePage_url"));
		sAssert.assertTrue(prof.homePage().searchProduct(prop.getValue("HomePage_productname")), "Search Product");
		sAssert.assertTrue(prof.resultPage().clickOnFirstProduct(), "Click on first product");
		sAssert.assertTrue(prof.prodDetailsPage().clickAddToCart(), "Click Add to cart");
		sAssert.assertTrue(prof.cartPage().verifyCartCount(), "Verify Cart Count");
	}

}
